/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.derivative.impl;

import static com.binance.api.client.BinanceAPIServiceGenerator.createService;
import static com.binance.api.client.BinanceAPIServiceGenerator.executeSync;
import static com.binance.api.client.config.BinanceAPIConfig.getFutureBaseUrl;

import com.binance.api.client.BinanceFutureAPIService;
import com.binance.api.client.derivative.IBinanceFutureAPIRestClient;
import com.binance.api.client.domain.general.ExchangeInfo;

/**
 * @Ttron May 31, 2024
 */
public class BinanceFutureAPIRestClientImpl implements IBinanceFutureAPIRestClient
{
	private final BinanceFutureAPIService binanceAPIService;

	public BinanceFutureAPIRestClientImpl(String apiKey, String secret)
	{
		binanceAPIService = createService( BinanceFutureAPIService.class, getFutureBaseUrl(), apiKey, secret );
	}


	@Override
	public ExchangeInfo getExchangeInfo()
	{
		return executeSync( binanceAPIService.getExchangeInfo() );
	}


	@Override
	public Long getServerTime()
	{
		return executeSync( binanceAPIService.getServerTime() ).getServerTime();
	}


	@Override
	public void ping()
	{
		executeSync( binanceAPIService.ping() );
	}
}
