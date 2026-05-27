/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.examples.derivative;

import com.binance.api.client.derivative.IBinanceDerivativeAPIRestClient;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.api.examples.ExampleBase;

/**
 * @Ttron May 25, 2026
 */
public class DerivativeTickerPriceChangeStatistics24HExample extends ExampleBase
{
	public static void main(String[] args)
	{
		IBinanceDerivativeAPIRestClient derivative = createDerivativeClient();

		// Test connectivity
		derivative.ping();

		// Check server time
		long serverTime = derivative.getServerTime();
		System.out.println( serverTime );

		// {
		// "symbol": "BTCUSDT",
		// "priceChange": "-94.99999800",
		// "priceChangePercent": "-95.960",
		// "weightedAvgPrice": "0.29628482",
		// "lastPrice": "4.00000200",
		// "lastQty": "200.00000000",
		// "openPrice": "99.00000000",
		// "highPrice": "100.00000000",
		// "lowPrice": "0.10000000",
		// "volume": "8913.30000000",
		// "quoteVolume": "15.30000000",
		// "openTime": 1499783499040,
		// "closeTime": 1499869899040,
		// "firstId": 28385, // First tradeId
		// "lastId": 28460, // Last tradeId
		// "count": 76 // Trade count
		// }

		TickerStatistics rep = derivative.get24HPriceStatistics( "BTCUSDT" );

		LOG.info( "get24HPriceStatistics: {}", rep );
	}
}
