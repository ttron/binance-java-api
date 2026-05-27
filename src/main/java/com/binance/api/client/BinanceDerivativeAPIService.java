/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client;

import java.util.List;

import com.binance.api.client.derivative.DerivativeExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.MarkPrice;
import com.binance.api.client.domain.market.OpenInterest;
import com.binance.api.client.domain.market.TickerStatistics;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * @Ttron May 31, 2024
 */
public interface BinanceDerivativeAPIService
{
	@GET("/fapi/v1/ticker/24hr")
	Call<TickerStatistics> get24HPriceStatistics(@Query("symbol") String symbol);


	@GET("/fapi/v1/ticker/24hr")
	Call<List<TickerStatistics>> get24HPriceStatisticsAll();


	/**
	 * USD-M Futures
	 * @return
	 */
	@GET("/fapi/v1/exchangeInfo")
	Call<DerivativeExchangeInfo> getExchangeInfo();


	@GET("/fapi/v1/premiumIndex")
	Call<MarkPrice> getMarkPrice(@Query("symbol") String symbol);


	@GET("/fapi/v1/premiumIndex")
	Call<List<MarkPrice>> getMarkPriceAll();


	@GET("/fapi/v1/openInterest")
	Call<OpenInterest> getOpenInterest(@Query("symbol") String symbol);


	@GET("/futures/data/openInterestHist")
	Call<List<OpenInterest>> getOpenInterestStatistics(@Query("symbol") String symbol, @Query("period") String period,
			@Query("limit") Integer limit, @Query("startTime") Long startTime, @Query("endTime") Long endTime);


	@GET("/fapi/v1/time")
	Call<ServerTime> getServerTime();


	// General endpoints
	@GET("/fapi/v1/ping")
	Call<Void> ping();

}
