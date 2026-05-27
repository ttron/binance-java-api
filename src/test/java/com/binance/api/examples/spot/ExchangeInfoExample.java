package com.binance.api.examples.spot;

import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.FilterType;
import com.binance.api.client.domain.general.SmartOrderRouting;
import com.binance.api.client.domain.general.SymbolFilter;
import com.binance.api.client.domain.general.SymbolInfo;
import com.binance.api.client.spot.IBinanceSpotAPIRestClient;
import com.binance.api.examples.ExampleBase;

/**
 * Examples on how to use the general endpoints.
 */
public class ExchangeInfoExample extends ExampleBase
{
	public static void main(String[] args)
	{
		IBinanceSpotAPIRestClient spot = createSpotClient();

		// Test connectivity
		spot.ping();

		// Check server time
		long serverTime = spot.getServerTime();
		System.out.println( serverTime );

		// Exchange info
		ExchangeInfo exchangeInfo = spot.getExchangeInfo();
		System.out.println( exchangeInfo.getTimezone() + ", Epoch: " + exchangeInfo.getServerTime() );
		System.out.println( "Pair Count: " + exchangeInfo.getSymbolCount() );

		// Obtain symbol information
		SymbolInfo symbolInfo = exchangeInfo.getSymbolInfo( "SHIBUSDT" );
		System.out.println( symbolInfo.getStatus() );

		System.out.println( "quoteAsset: " + symbolInfo.getQuoteAsset() );
		System.out.println( "quotePrecision: " + symbolInfo.getQuotePrecision() );
		System.out.println( "baseAsset: " + symbolInfo.getBaseAsset() );
		System.out.println( "baseAssetPrecision: " + symbolInfo.getBaseAssetPrecision() );

		// "filterType": "PRICE_FILTER",
		// "minPrice": "0.00000001",
		// "maxPrice": "1.00000000",
		// "tickSize": "0.00000001"
		System.out.println( "------------------------" + "PRICE_FILTER" + "------------------------" );
		SymbolFilter priceFilter = symbolInfo.getSymbolFilter( FilterType.PRICE_FILTER );
		System.out.println( "MIN_P: " + priceFilter.getMinPrice() );
		System.out.println( "MAX_P: " + priceFilter.getMaxPrice() );

		System.out.println( "TIK: " + priceFilter.getTickSize() );

		// "filterType": "LOT_SIZE",
		// "minQty": "1.00",
		// "maxQty": "46116860414.00",
		// "stepSize": "1.00"
		SymbolFilter lotSize = symbolInfo.getSymbolFilter( FilterType.LOT_SIZE );
		System.out.println( "------------------------" + "LOT_SIZE" + "------------------------" );
		System.out.println( "MIN_Q: " + lotSize.getMinQty() );
		System.out.println( "MAX_Q: " + lotSize.getMaxQty() );

		// Obtain asset information
		// List<Asset> allAssets = client.getAllAssets();
		// System.out.println( allAssets.stream().filter( asset -> asset.getAssetCode().equals( "BNB" )
		// ).findFirst().get() );

		for ( SymbolInfo symbol : exchangeInfo.getSymbols() )
		{
			if ("USDT".equalsIgnoreCase( symbol.getQuoteAsset() ))
				System.out.println( symbol.getBaseAsset() + "/" + symbol.getQuoteAsset() + ": " + symbol.getStatus() );
		}

		// Smart Order Routing (SOR)
		if (exchangeInfo.getSors() != null)
		{
			SmartOrderRouting sor = exchangeInfo.getSmartOrderRouting( "ETH" );
			System.out.println( sor );
		}
	}
}
