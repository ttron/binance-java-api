package com.binance.api.client.domain.account.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;

/**
 * A specialized order request with additional filters.
 */
public class AllOrdersRequest extends OrderRequest
{

	private static final Integer DEFAULT_LIMIT = 500;

	private Integer limit;

	private Long orderId;

	public AllOrdersRequest(String symbol)
	{
		super( symbol );
		this.limit = DEFAULT_LIMIT;
	}


	public Integer getLimit()
	{
		return limit;
	}


	public Long getOrderId()
	{
		return orderId;
	}


	public AllOrdersRequest limit(Integer limit)
	{
		this.limit = limit;
		return this;
	}


	public AllOrdersRequest orderId(Long orderId)
	{
		this.orderId = orderId;
		return this;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "orderId", orderId )
				.append( "limit", limit ).toString();
	}
}
