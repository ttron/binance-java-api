/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2025 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.derivative;

import com.binance.api.client.domain.general.SymbolInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * @Ttron May 26, 2026
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DerivativeSymbolInfo extends SymbolInfo
{
	// "symbol": "BLZUSDT",
	// "pair": "BLZUSDT",
	// "contractType": "PERPETUAL",
	// "deliveryDate": 4133404800000,
	// "onboardDate": 1598252400000,
	// "status": "TRADING",
	// "maintMarginPercent": "2.5000", // ignore
	// "requiredMarginPercent": "5.0000", // ignore
	// "baseAsset": "BLZ",
	// "quoteAsset": "USDT",
	// "marginAsset": "USDT",
	// "pricePrecision": 5, // please do not use it as tickSize
	// "quantityPrecision": 0, // please do not use it as stepSize
	// "baseAssetPrecision": 8,
	// "quotePrecision": 8,
	// "underlyingType": "COIN",
	// "underlyingSubType": ["STORAGE"],
	// "settlePlan": 0,
	// "triggerProtect": "0.15", // threshold for algo order with "priceProtect"
	// "liquidationFee": "0.010000", // liquidation fee rate
	// "marketTakeBound": "0.30", // the max price difference rate( from mark price) a market order can make

	private String contractType, underlyingType;

	private long deliveryDate, onboardDate;

	private double liquidationFee, marketTakeBound;

	private double maintMarginPercent, requiredMarginPercent, triggerProtect;

	private String marginAsset;

	private String pair;

	private int pricePrecision;

	private int settlePlan;

	/**
	 * @return TRADIFI_PERPETUAL or PERPETUAL
	 */
	public String getContractType()
	{
		return contractType;
	}


	public long getDeliveryDate()
	{
		return deliveryDate;
	}


	public double getLiquidationFee()
	{
		return liquidationFee;
	}


	public double getMaintMarginPercent()
	{
		return maintMarginPercent;
	}


	public String getMarginAsset()
	{
		return marginAsset;
	}


	public double getMarketTakeBound()
	{
		return marketTakeBound;
	}


	public long getOnboardDate()
	{
		return onboardDate;
	}


	public String getPair()
	{
		return pair;
	}


	public int getPricePrecision()
	{
		return pricePrecision;
	}


	public double getRequiredMarginPercent()
	{
		return requiredMarginPercent;
	}


	public int getSettlePlan()
	{
		return settlePlan;
	}


	public double getTriggerProtect()
	{
		return triggerProtect;
	}


	public String getUnderlyingType()
	{
		return underlyingType;
	}


	public void setContractType(String contractType)
	{
		this.contractType = contractType;
	}


	public void setDeliveryDate(long deliveryDate)
	{
		this.deliveryDate = deliveryDate;
	}


	public void setLiquidationFee(double liquidationFee)
	{
		this.liquidationFee = liquidationFee;
	}


	public void setMaintMarginPercent(double maintMarginPercent)
	{
		this.maintMarginPercent = maintMarginPercent;
	}


	public void setMarginAsset(String marginAsset)
	{
		this.marginAsset = marginAsset;
	}


	public void setMarketTakeBound(double marketTakeBound)
	{
		this.marketTakeBound = marketTakeBound;
	}


	public void setOnboardDate(long onboardDate)
	{
		this.onboardDate = onboardDate;
	}


	public void setPair(String pair)
	{
		this.pair = pair;
	}


	public void setPricePrecision(int pricePrecision)
	{
		this.pricePrecision = pricePrecision;
	}


	public void setRequiredMarginPercent(double requiredMarginPercent)
	{
		this.requiredMarginPercent = requiredMarginPercent;
	}


	public void setSettlePlan(int settlePlan)
	{
		this.settlePlan = settlePlan;
	}


	public void setTriggerProtect(double triggerProtect)
	{
		this.triggerProtect = triggerProtect;
	}


	public void setUnderlyingType(String underlyingType)
	{
		this.underlyingType = underlyingType;
	}
}
