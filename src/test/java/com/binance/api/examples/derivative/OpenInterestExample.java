/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.examples.derivative;

import java.util.List;

import com.binance.api.client.derivative.IBinanceFutureAPIRestClient;
import com.binance.api.client.domain.market.OpenInterest;
import com.binance.api.examples.ExampleBase;

import cn.ttron.protocol.util.DateHelper;

/**
 * @MR006 Jun 5, 2024
 */
public class OpenInterestExample extends ExampleBase
{

	public static void main(String[] args)
	{
		IBinanceFutureAPIRestClient client = createFutureClient();

		OpenInterest oi = client.getOpenInterest( "FIDAUSDT" );
		System.out.println( oi.getOpenInterest() );

		List<OpenInterest> ois = client.getOpenInterestStatistics( "TONUSDT", "30m", 50 );// "5m","15m","30m","1h","2h","4h","6h","12h","1d"
		for ( OpenInterest o : ois )
			LOG.info( "{}/{}, {}/{} USDT", o.getTimestamp(), DateHelper.getDateYYYY_MM_DD( o.getTimestamp() ),
					o.getSumOpenInterest(), o.getSumOpenInterestValue() );
	}
}
