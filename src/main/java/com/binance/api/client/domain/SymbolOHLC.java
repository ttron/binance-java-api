/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.domain;

/**
 * @Ttron May 25, 2026
 */
public class SymbolOHLC extends SymbolRR
{
	protected Double close;

	protected Double high;

	protected Double low;

	protected Double open;

	protected Double volume;

	public Double getClose()
	{
		return close;
	}


	public Double getHigh()
	{
		return high;
	}


	public Double getLow()
	{
		return low;
	}


	public Double getOpen()
	{
		return open;
	}


	public Double getVolume()
	{
		return volume;
	}


	public void setClose(Double close)
	{
		this.close = close;
	}


	public void setHigh(Double high)
	{
		this.high = high;
	}


	public void setLow(Double low)
	{
		this.low = low;
	}


	public void setOpen(Double open)
	{
		this.open = open;
	}


	public void setVolume(Double volume)
	{
		this.volume = volume;
	}
}
