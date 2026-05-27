/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.derivative;

import java.util.List;

import com.binance.api.client.domain.market.MarkPrice;
import com.binance.api.client.domain.market.OpenInterest;
import com.binance.api.client.domain.market.TickerStatistics;

/**
 * @Ttron May 31, 2024
 */
public interface IBinanceDerivativeAPIRestClient
{
	/**
	 * Get 24 hour price change statistics.
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 */
	TickerStatistics get24HPriceStatistics(String symbol);


	/**
	 * Get 24 hour price change statistics for all symbols.
	 */
	List<TickerStatistics> get24HPriceStatisticsAll();


	/**
	 * @return Current exchange trading rules and symbol information
	 */
	DerivativeExchangeInfo getExchangeInfo();


	MarkPrice getMarkPrice(String symbol);


	List<MarkPrice> getMarkPriceAll();


	/**
	 * /fapi/v1/openInterest
	 * @param symbol
	 * @return
	 */
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
