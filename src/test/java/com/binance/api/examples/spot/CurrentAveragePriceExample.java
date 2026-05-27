/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.examples.spot;

import com.binance.api.client.spot.IBinanceSpotAPIRestClient;
import com.binance.api.examples.ExampleBase;

/**
 * @Ttron May 5, 2026
 */
public class CurrentAveragePriceExample extends ExampleBase
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		IBinanceSpotAPIRestClient spot = createSpotClient();

		// TODO Auto-generated method stub
		System.out.print( spot.getCurrentAveragePrice( "BTCUSDT" ) );
	}
}
