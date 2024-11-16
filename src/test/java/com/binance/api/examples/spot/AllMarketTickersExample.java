package com.binance.api.examples.spot;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.spot.BinanceAPIWebSocketClient;

/**
 * All market tickers channel examples.
 *
 * It illustrates how to create a stream to obtain all market tickers.
 */
public class AllMarketTickersExample
{

	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance();
		BinanceAPIWebSocketClient client = factory.newWebSocketClient();
		client.onAllMarketTickersEvent( event -> {
			System.out.println( event );
		} );
	}
}
