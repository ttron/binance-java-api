/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2021 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.domain.account;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Ttron Apr. 14, 2023
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelReplaceOrderResponse
{
	@JsonProperty("cancelResponse")
	private CancelOrderResponse cancelResponse;

	@JsonProperty("cancelResult")
	private String cancelResult;

	@JsonProperty("newOrderResponse")
	private NewOrderResponse newOrderResponse;

	@JsonProperty("newOrderResult")
	private String newOrderResult;

	/**
	 * @return the cancelResponse
	 */
	public CancelOrderResponse getCancelResponse()
	{
		return cancelResponse;
	}


	/**
	 * @return the cancelResult
	 */
	public String getCancelResult()
	{
		return cancelResult;
	}


	/**
	 * @return the newOrderResponse
	 */
	public NewOrderResponse getNewOrderResponse()
	{
		return newOrderResponse;
	}


	/**
	 * @return the newOrderResult
	 */
	public String getNewOrderResult()
	{
		return newOrderResult;
	}


	/**
	 * @param cancelResponse the cancelResponse to set
	 */
	public void setCancelResponse(CancelOrderResponse cancelResponse)
	{
		this.cancelResponse = cancelResponse;
	}


	/**
	 * @param cancelResult the cancelResult to set
	 */
	public void setCancelResult(String cancelResult)
	{
		this.cancelResult = cancelResult;
	}


	/**
	 * @param newOrderResponse the newOrderResponse to set
	 */
	public void setNewOrderResponse(NewOrderResponse newOrderResponse)
	{
		this.newOrderResponse = newOrderResponse;
	}


	/**
	 * @param newOrderResult the newOrderResult to set
	 */
	public void setNewOrderResult(String newOrderResult)
	{
		this.newOrderResult = newOrderResult;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "cancelResult", cancelResult )
				.append( "newOrderResult", newOrderResult ).append( "cancelResponse", cancelResponse )
				.append( "newOrderResponse", newOrderResponse ).toString();
	}
}
