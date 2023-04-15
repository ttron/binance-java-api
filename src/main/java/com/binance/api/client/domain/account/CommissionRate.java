/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2021 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.domain.account;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Ttron Apr. 15, 2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommissionRate
{
	@JsonProperty("buyer")
	private double buyerRate;

	@JsonProperty("maker")
	private double makerRate;

	@JsonProperty("seller")
	private double sellerRate;

	@JsonProperty("taker")
	private double takerRate;

	public double getBuyerRate()
	{
		return buyerRate;
	}


	public double getMakerRate()
	{
		return makerRate;
	}


	public double getSellerRate()
	{
		return sellerRate;
	}


	public double getTakerRate()
	{
		return takerRate;
	}


	public void setBuyerRate(double buyerRate)
	{
		this.buyerRate = buyerRate;
	}


	public void setMakerRate(double makerRate)
	{
		this.makerRate = makerRate;
	}


	public void setSellerRate(double sellerRate)
	{
		this.sellerRate = sellerRate;
	}


	public void setTakerRate(double takerRate)
	{
		this.takerRate = takerRate;
	}
}
