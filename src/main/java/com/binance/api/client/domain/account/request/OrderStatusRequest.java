package com.binance.api.client.domain.account.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;

/**
 * A specialized order request with additional filters.
 */
public class OrderStatusRequest extends OrderRequest
{

	private Long orderId;

	private String origClientOrderId;

	public OrderStatusRequest(String symbol, Long orderId)
	{
		super( symbol );
		this.orderId = orderId;
	}


	public OrderStatusRequest(String symbol, String origClientOrderId)
	{
		super( symbol );
		this.origClientOrderId = origClientOrderId;
	}


	public Long getOrderId()
	{
		return orderId;
	}


	public String getOrigClientOrderId()
	{
		return origClientOrderId;
	}


	public OrderStatusRequest orderId(Long orderId)
	{
		this.orderId = orderId;
		return this;
	}


	public OrderStatusRequest origClientOrderId(String origClientOrderId)
	{
		this.origClientOrderId = origClientOrderId;
		return this;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "orderId", orderId )
				.append( "origClientOrderId", origClientOrderId ).toString();
	}
}
