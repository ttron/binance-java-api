/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.domain.market;

import com.binance.api.client.domain.SymbolRR;

/**
 * @Ttron May 25, 2026
 */
public class MarkPrice extends SymbolRR
{
	// {
	// "symbol": "BTCUSDT",
	// "markPrice": "11793.63104562", // mark price
	// "indexPrice": "11781.80495970", // index price
	// "estimatedSettlePrice": "11781.16138815", // Estimated Settle Price, only useful in the last hour
	// before the settlement starts.
	// "lastFundingRate": "0.00038246", // This is the Latest funding rate
	// "interestRate": "0.00010000",
	// "nextFundingTime": 1597392000000,
	// "time": 1597370495002
	// }

	private double markPrice, indexPrice, estimatedSettlePrice, lastFundingRate, interestRate;

	private long nextFundingTime, time;

	public double getEstimatedSettlePrice()
	{
		return estimatedSettlePrice;
	}


	public double getIndexPrice()
	{
		return indexPrice;
	}


	public double getInterestRate()
	{
		return interestRate;
	}


	public double getLastFundingRate()
	{
		return lastFundingRate;
	}


	public double getMarkPrice()
	{
		return markPrice;
	}


	public long getNextFundingTime()
	{
		return nextFundingTime;
	}


	public long getTime()
	{
		return time;
	}


	public void setEstimatedSettlePrice(double estimatedSettlePrice)
	{
		this.estimatedSettlePrice = estimatedSettlePrice;
	}


	public void setIndexPrice(double indexPrice)
	{
		this.indexPrice = indexPrice;
	}


	public void setInterestRate(double interestRate)
	{
		this.interestRate = interestRate;
	}


	public void setLastFundingRate(double lastFundingRate)
	{
		this.lastFundingRate = lastFundingRate;
	}


	public void setMarkPrice(double markPrice)
	{
		this.markPrice = markPrice;
	}


	public void setNextFundingTime(long nextFundingTime)
	{
		this.nextFundingTime = nextFundingTime;
	}


	public void setTime(long time)
	{
		this.time = time;
	}
}
