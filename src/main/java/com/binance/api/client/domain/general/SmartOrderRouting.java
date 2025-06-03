/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.domain.general;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Ttron May 22, 2025
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SmartOrderRouting
{
	private String baseAsset;

	private List<String> symbols;

	public String getBaseAsset()
	{
		return baseAsset;
	}


	public List<String> getSymbols()
	{
		return symbols;
	}


	public void setBaseAsset(String baseAsset)
	{
		this.baseAsset = baseAsset;
	}


	public void setSymbols(List<String> symbols)
	{
		this.symbols = symbols;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "symbols", symbols )
				.append( "baseAsset", baseAsset ).toString();
	}
}
