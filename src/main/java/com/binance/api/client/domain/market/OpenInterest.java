/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @MR006 Jun 5, 2024
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OpenInterest
{
	private double openInterest;

	private double sumOpenInterest;

	private double sumOpenInterestValue;

	private String symbol;

	private long timestamp;

	public double getOpenInterest()
	{
		return openInterest;
	}


	public double getSumOpenInterest()
	{
		return sumOpenInterest;
	}


	public double getSumOpenInterestValue()
	{
		return sumOpenInterestValue;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public long getTimestamp()
	{
		return timestamp;
	}


	public void setOpenInterest(double openInterest)
	{
		this.openInterest = openInterest;
	}


	public void setSumOpenInterest(double sumOpenInterest)
	{
		this.sumOpenInterest = sumOpenInterest;
	}


	public void setSumOpenInterestValue(double sumOpenInterestValue)
	{
		this.sumOpenInterestValue = sumOpenInterestValue;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setTimestamp(long timestamp)
	{
		this.timestamp = timestamp;
	}

}
