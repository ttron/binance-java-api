/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.examples.websocket;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.spot.IBinanceAPIWebSocketClient;

/**
 * @Ttron May 22, 2025
 */
public class AnySubsctibeExample
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance();
		IBinanceAPIWebSocketClient client = factory.newWebSocketClient();
	}
}
