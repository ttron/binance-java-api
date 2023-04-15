package com.binance.api.client.domain.account;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.OrderStatus;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Response object returned when an order is canceled.
 * [{"symbol":"BTCUSDT","origClientOrderId":"7069B60BD9C7470B96C7B563A884B301","orderId":20807274889,
 * "orderListId":-1,"clientOrderId":"EiCoc9BdPWT3Vt9NO3abey","price":"28000.00000000","origQty":"0.00170000","executedQty":"0.00000000",
 * "cummulativeQuoteQty":"0.00000000","status":"CANCELED","timeInForce":"GTC","type":"LIMIT","side":"BUY","selfTradePreventionMode":"NONE"}]
 * @see CancelOrderRequest for the request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CancelOrderResponse
{
	private String clientOrderId;

	@JsonProperty("executedQty")
	private String executedQty;

	@JsonProperty("orderId")
	private String orderId;

	@JsonProperty("origClientOrderId")
	private String origClientOrderId;

	@JsonProperty("status")
	private OrderStatus status;

	@JsonProperty("symbol")
	private String symbol;

	public String getClientOrderId()
	{
		return clientOrderId;
	}


	public String getExecutedQty()
	{
		return executedQty;
	}


	public String getOrderId()
	{
		return orderId;
	}


	public String getOrigClientOrderId()
	{
		return origClientOrderId;
	}


	public OrderStatus getStatus()
	{
		return status;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public CancelOrderResponse setClientOrderId(String clientOrderId)
	{
		this.clientOrderId = clientOrderId;
		return this;
	}


	public CancelOrderResponse setOrderId(String orderId)
	{
		this.orderId = orderId;
		return this;
	}


	public CancelOrderResponse setOrigClientOrderId(String origClientOrderId)
	{
		this.origClientOrderId = origClientOrderId;
		return this;
	}


	public CancelOrderResponse setSymbol(String symbol)
	{
		this.symbol = symbol;
		return this;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "symbol", symbol )
				.append( "origClientOrderId", origClientOrderId ).append( "orderId", orderId )
				.append( "clientOrderId", clientOrderId ).toString();
	}
}
