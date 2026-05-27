package com.binance.api.client.domain.account.request;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.SymbolRR;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Base request parameters for order-related methods.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderRequest extends SymbolRR
{
	private Long recvWindow;

	private Long timestamp;

	public OrderRequest()
	{
		this.timestamp = System.currentTimeMillis();
		this.recvWindow = BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW;
	}


	public OrderRequest(String symbol)
	{
		this();
		this.symbol = symbol;
	}


	public Long getRecvWindow()
	{
		return recvWindow;
	}


	public Long getTimestamp()
	{
		return timestamp;
	}


	public OrderRequest recvWindow(Long recvWindow)
	{
		this.recvWindow = recvWindow;
		return this;
	}


	public OrderRequest timestamp(Long timestamp)
	{
		this.timestamp = timestamp;
		return this;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "symbol", symbol )
				.append( "recvWindow", recvWindow ).append( "timestamp", timestamp ).toString();
	}
}
