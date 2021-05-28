package com.binance.api.examples;

import com.binance.api.client.BinanceApiAsyncRestClient;
import com.binance.api.client.BinanceApiClientFactory;
import com.binance.api.client.domain.general.FilterType;
import com.binance.api.client.domain.general.SymbolFilter;
import com.binance.api.client.domain.general.SymbolInfo;

/**
 * Examples on how to use the general endpoints.
 */
public class GeneralEndpointsExampleAsync
{
	public static void main(String[] args) throws InterruptedException
	{
		BinanceApiClientFactory factory = BinanceApiClientFactory.newInstance();
		BinanceApiAsyncRestClient client = factory.newAsyncRestClient();

		// Test connectivity
		client.ping( response -> System.out.println( "Ping succeeded." ) );

		// Check server time
		client.getServerTime( response -> System.out.println( response.getServerTime() ) );

		// Exchange info
		client.getExchangeInfo( exchangeInfo -> {
			System.out.println( exchangeInfo.getTimezone() );
			// System.out.println( exchangeInfo.getSymbols() );

			// Obtain symbol information
			SymbolInfo symbolInfo = exchangeInfo.getSymbolInfo( "BTCUSDT" );
			System.out.println( symbolInfo.getStatus() );

			// minPrice defines the minimum price/stopPrice allowed; disabled on minPrice == 0.
			// maxPrice defines the maximum price/stopPrice allowed; disabled on maxPrice == 0.
			// tickSize defines the intervals that a price/stopPrice can be increased/decreased by; disabled
			// on tickSize == 0.
			// {
			// "filterType": "PRICE_FILTER",
			// "minPrice": "0.00000100",
			// "maxPrice": "100000.00000000",
			// "tickSize": "0.00000100"
			// }

			SymbolFilter priceFilter = symbolInfo.getSymbolFilter( FilterType.PRICE_FILTER );
			System.out.println( "PRICE_FILTER Min: " + priceFilter.getMinPrice() );
			System.out.println( "PRICE_FILTER Max: " + priceFilter.getMaxPrice() );
			System.out.println( "PRICE_FILTER Tick: " + priceFilter.getTickSize() );

			// price <= weightedAveragePrice * multiplierUp
			// price >= weightedAveragePrice * multiplierDown
			priceFilter = symbolInfo.getSymbolFilter( FilterType.PERCENT_PRICE );
			System.out.println( priceFilter.getMinPrice() );
			System.out.println( priceFilter.getTickSize() );
		} );

		// Obtain asset information
		client.getAllAssets( allAssets -> System.out
				.println( allAssets.stream().filter( asset -> asset.getAssetCode().equals( "BNB" ) ).findFirst().get() ) );
	}
}
