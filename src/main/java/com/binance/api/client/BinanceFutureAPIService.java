/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client;

import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * @Ttron May 31, 2024
 */
public interface BinanceFutureAPIService
{
	// General endpoints
	@GET("/fapi/v1/ping")
	Call<Void> ping();


	/**
	 * USD-M Futures
	 * @return
	 */
	@GET("/fapi/v1/exchangeInfo")
	Call<ExchangeInfo> getExchangeInfo();


	@GET("/fapi/v1/time")
	Call<ServerTime> getServerTime();
}
