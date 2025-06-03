package com.binance.api.examples.websocket;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.spot.IBinanceAPIWebSocketClient;

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
		IBinanceAPIWebSocketClient client = factory.newWebSocketClient();
		client.onAllMarketTickersEvent( event -> {
			System.out.println( event );
		} );
	}
}
