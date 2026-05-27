/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.derivative.impl;

import static com.binance.api.client.BinanceAPIServiceGenerator.createService;
import static com.binance.api.client.BinanceAPIServiceGenerator.executeSync;
import static com.binance.api.client.config.BinanceAPIConfig.getFutureBaseUrl;

import java.util.List;

import com.binance.api.client.BinanceDerivativeAPIService;
import com.binance.api.client.derivative.DerivativeExchangeInfo;
import com.binance.api.client.derivative.IBinanceDerivativeAPIRestClient;
import com.binance.api.client.domain.market.MarkPrice;
import com.binance.api.client.domain.market.OpenInterest;
import com.binance.api.client.domain.market.TickerStatistics;

/**
 * @Ttron May 31, 2024
 */
public class BinanceDerivativeAPIRestClientImpl implements IBinanceDerivativeAPIRestClient
{
	private final BinanceDerivativeAPIService binanceAPIService;

	public BinanceDerivativeAPIRestClientImpl(String apiKey, String secret)
	{
		binanceAPIService = createService( BinanceDerivativeAPIService.class, getFutureBaseUrl(), apiKey, secret );
	}


	@Override
	public TickerStatistics get24HPriceStatistics(String symbol)
	{
		return executeSync( binanceAPIService.get24HPriceStatistics( symbol ) );
	}


	@Override
	public List<TickerStatistics> get24HPriceStatisticsAll()
	{
		return executeSync( binanceAPIService.get24HPriceStatisticsAll() );
	}


	@Override
	public DerivativeExchangeInfo getExchangeInfo()
	{
		return executeSync( binanceAPIService.getExchangeInfo() );
	}


	@Override
	public MarkPrice getMarkPrice(String symbol)
	{
		return executeSync( binanceAPIService.getMarkPrice( symbol ) );
	}


	@Override
	public List<MarkPrice> getMarkPriceAll()
	{
		return executeSync( binanceAPIService.getMarkPriceAll() );
	}


	@Override
	public OpenInterest getOpenInterest(String symbol)
	{
		return executeSync( binanceAPIService.getOpenInterest( symbol ) );
	}


	@Override
	public List<OpenInterest> getOpenInterestStatistics(String symbol, String period, int limit)
	{
		return getOpenInterestStatistics( symbol, period, limit, null, null );
	}


	@Override
	public List<OpenInterest> getOpenInterestStatistics(String symbol, String peroid, int limit, Long epochFrom, Long epochTo)
	{
		return executeSync( binanceAPIService.getOpenInterestStatistics( symbol, peroid, limit, epochFrom, epochTo ) );
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
