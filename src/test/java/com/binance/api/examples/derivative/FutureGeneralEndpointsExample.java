/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.examples.derivative;

import java.util.List;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.derivative.IBinanceFutureAPIRestClient;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.FilterType;
import com.binance.api.client.domain.general.SymbolFilter;
import com.binance.api.client.domain.general.SymbolInfo;

/**
 * @Ttron May 31, 2024
 */
public class FutureGeneralEndpointsExample
{
	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance();
		IBinanceFutureAPIRestClient client = factory.newFutureRestClient();

		// Test connectivity
		// client.ping();

		// Check server time
		long serverTime = client.getServerTime();
		System.out.println( serverTime );

		// Exchange info
		ExchangeInfo exchangeInfo = client.getExchangeInfo();
		System.out.println( exchangeInfo.getTimezone() + ", Epoch:" + exchangeInfo.getServerTime() );
		// System.out.println( exchangeInfo.getSymbols() );

		// Obtain symbol information
		SymbolInfo symbolInfo = exchangeInfo.getSymbolInfo( "BTCUSDT" );
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

		List<SymbolInfo> symbolList = exchangeInfo.getSymbols();
		for ( int i = 0; i < symbolList.size(); i++ )
		{
			SymbolInfo symbol = symbolList.get( i );
			System.out.println( i + ", " + symbol.getSymbol() + " (" + symbol.getContractType() + ")" );
		}
	}
}
