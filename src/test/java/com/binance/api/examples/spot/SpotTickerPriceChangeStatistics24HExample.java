/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.examples.spot;

import java.util.List;

import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.api.client.spot.IBinanceSpotAPIRestClient;
import com.binance.api.examples.ExampleBase;

/**
 * @Ttron May 25, 2026
 */
public class SpotTickerPriceChangeStatistics24HExample extends ExampleBase
{
	public static void main(String[] args)
	{
		IBinanceSpotAPIRestClient spot = createSpotClient();

		// Test connectivity
		spot.ping();

		// Check server time
		long serverTime = spot.getServerTime();
		System.out.println( serverTime );

		// {
		// "symbol": "BNBBTC",
		// "priceChange": "-94.99999800",
		// "priceChangePercent": "-95.960",
		// "weightedAvgPrice": "0.29628482",
		// "prevClosePrice": "0.10002000",
		// "lastPrice": "4.00000200",
		// "lastQty": "200.00000000",
		// "bidPrice": "4.00000000",
		// "bidQty": "100.00000000",
		// "askPrice": "4.00000200",
		// "askQty": "100.00000000",
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

		List<TickerStatistics> rep = spot.get24HPriceStatisticsAll();

		LOG.info( "COUNT: {}", rep.size() );
	}
}
