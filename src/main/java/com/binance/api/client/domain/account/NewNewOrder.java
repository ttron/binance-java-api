/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2021 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.domain.account;

import com.binance.api.client.domain.CancelReplaceMode;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;

/**
 * @Ttron Apr. 14, 2023
 */
public class NewNewOrder extends NewOrder
{

	private Long cancelOrderId;

	private String cancelOrigClientOrderId;

	private CancelReplaceMode mode;

	/**
	 * @param cancelOrderId 
	 * @param symbol
	 * @param side
	 * @param type
	 * @param timeInForce
	 * @param quantity
	 */
	public NewNewOrder(long cancelOrderId, String newClientOrderId, String symbol, OrderSide side, OrderType type,
			TimeInForce timeInForce, String quantity, String price)
	{
		super( symbol, side, type, timeInForce, quantity, price );
		this.cancelOrderId = cancelOrderId;
		this.newClientOrderId = newClientOrderId;
	}


	/**
	 * @return the cancelOrderId
	 */
	public Long getCancelOrderId()
	{
		return cancelOrderId;
	}


	/**
	 * @return the cancelOrigClientOrderId
	 */
	public String getCancelOrigClientOrderId()
	{
		return cancelOrigClientOrderId;
	}


	/**
	 * @return the mode
	 */
	public CancelReplaceMode getMode()
	{
		return mode;
	}


	/**
	 * @param cancelOrderId the cancelOrderId to set
	 */
	public void setCancelOrderId(Long cancelOrderId)
	{
		this.cancelOrderId = cancelOrderId;
	}


	/**
	 * @param cancelOrigClientOrderId the cancelOrigClientOrderId to set
	 */
	public void setCancelOrigClientOrderId(String cancelOrigClientOrderId)
	{
		this.cancelOrigClientOrderId = cancelOrigClientOrderId;
	}


	/**
	 * @param mode the mode to set
	 */
	public void setMode(CancelReplaceMode mode)
	{
		this.mode = mode;
	}
}
