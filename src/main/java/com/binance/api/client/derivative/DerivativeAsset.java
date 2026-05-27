/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.derivative;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Ttron May 26, 2026
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DerivativeAsset
{
	private String asset;

	private double autoAssetExchange;

	private boolean marginAvailable;

	public String getAsset()
	{
		return asset;
	}


	public double getAutoAssetExchange()
	{
		return autoAssetExchange;
	}


	public boolean isMarginAvailable()
	{
		return marginAvailable;
	}


	public void setAsset(String asset)
	{
		this.asset = asset;
	}


	public void setAutoAssetExchange(double autoAssetExchange)
	{
		this.autoAssetExchange = autoAssetExchange;
	}


	public void setMarginAvailable(boolean marginAvailable)
	{
		this.marginAvailable = marginAvailable;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "asset", asset )
				.append( "autoAssetExchange", autoAssetExchange ).append( "marginAvailable", marginAvailable ).toString();
	}
}
