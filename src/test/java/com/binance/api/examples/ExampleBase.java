/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.examples;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.derivative.IBinanceFutureAPIRestClient;
import com.binance.api.client.spot.IBinanceSpotAPIAsyncRestClient;
import com.binance.api.client.spot.IBinanceSpotAPIRestClient;

/**
 * @MR006 Jun 5, 2024
 */
public class ExampleBase
{
	protected static final Logger LOG = LogManager.getLogger( ExampleBase.class );

	static BinanceAPIClientFactory FACTORY;

	protected static IBinanceFutureAPIRestClient createFutureClient()
	{
		if (FACTORY == null)
			FACTORY = BinanceAPIClientFactory.newInstance();
		IBinanceFutureAPIRestClient client = FACTORY.newFutureRestClient();
		return client;
	}


	protected static IBinanceSpotAPIRestClient createSpotClient()
	{
		if (FACTORY == null)
			FACTORY = BinanceAPIClientFactory.newInstance();
		IBinanceSpotAPIRestClient client = FACTORY.newSpotRestClient();
		return client;
	}


	protected static IBinanceSpotAPIAsyncRestClient createSpotAsyncClient()
	{
		if (FACTORY == null)
			FACTORY = BinanceAPIClientFactory.newInstance();
		IBinanceSpotAPIAsyncRestClient client = FACTORY.newAsyncRestClient();
		return client;
	}
}
