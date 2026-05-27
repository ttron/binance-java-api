/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.derivative;

import java.util.List;

import com.binance.api.client.domain.general.RateLimit;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.exception.BinanceAPIException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Ttron May 26, 2026
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DerivativeExchangeInfo extends ServerTime
{
	private List<DerivativeAsset> assets;

	private List<RateLimit> rateLimits;

	private List<DerivativeSymbolInfo> symbols;

	private String timezone;

	public List<DerivativeAsset> getAssets()
	{
		return assets;
	}


	public List<RateLimit> getRateLimits()
	{
		return rateLimits;
	}


	/**
	 * @param symbol the symbol to obtain information for (e.g. ETHBTC)
	 * @return symbol exchange information
	 */
	public DerivativeSymbolInfo getSymbolInfo(String symbol)
	{
		return symbols.stream().filter( symbolInfo -> symbolInfo.getSymbol().equals( symbol ) ).findFirst()
				.orElseThrow( () -> new BinanceAPIException( "Unable to obtain information for symbol " + symbol ) );
	}


	public List<DerivativeSymbolInfo> getSymbols()
	{
		return symbols;
	}


	public String getTimezone()
	{
		return timezone;
	}


	public void setAssets(List<DerivativeAsset> assets)
	{
		this.assets = assets;
	}


	public void setRateLimits(List<RateLimit> rateLimits)
	{
		this.rateLimits = rateLimits;
	}


	public void setSymbols(List<DerivativeSymbolInfo> symbols)
	{
		this.symbols = symbols;
	}


	public void setTimezone(String timezone)
	{
		this.timezone = timezone;
	}
}
