/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.derivative;

import java.util.List;

import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.market.OpenInterest;

/**
 * @Ttron May 31, 2024
 */
public interface IBinanceFutureAPIRestClient
{
	/**
	 * @return Current exchange trading rules and symbol information
	 */
	ExchangeInfo getExchangeInfo();


	OpenInterest getOpenInterest(String symbol);


	List<OpenInterest> getOpenInterestStatistics(String symbol, String period, int limit);


	List<OpenInterest> getOpenInterestStatistics(String symbol, String period, int limit, Long epochFrom, Long epochTo);


	/**
	 * Test connectivity to the Rest API and get the current server time.
	 *
	 * @return current server time.
	 */
	Long getServerTime();


	/**
	 * Test connectivity to the Rest API.
	 */
	void ping();
}
