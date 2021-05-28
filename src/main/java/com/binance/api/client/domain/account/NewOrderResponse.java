package com.binance.api.client.domain.account;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderStatus;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Response returned when placing a new order on the system.
 * @see NewOrder for the request
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrderResponse
{

	// {
	// "symbol": "BTCUSDT",
	// "orderId": 28,
	// "orderListId": -1, //Unless OCO, value will be -1
	// "clientOrderId": "6gCrw2kRUAF9CvJDGP16IP",
	// "transactTime": 1507725176595,
	// "price": "0.00000000",
	// "origQty": "10.00000000",
	// "executedQty": "10.00000000",
	// "cummulativeQuoteQty": "10.00000000",
	// "status": "FILLED",
	// "timeInForce": "GTC",
	// "type": "MARKET",
	// "side": "SELL"
	// }

	/**
	 * This will be either a generated one, or the newClientOrderId parameter
	 * which was passed when creating the new order.
	 */
	private String clientOrderId;

	private String cummulativeQuoteQty;

	private String executedQty;

	// @JsonSetter(nulls = Nulls.AS_EMPTY)
	private List<Trade> fills;

	/**
	 * Order id.
	 */
	private Long orderId;

	private String origQty;

	private String price;

	private OrderSide side;

	private OrderStatus status;

	/**
	 * Order symbol.
	 */
	private String symbol;

	private TimeInForce timeInForce;

	/**
	 * Transact time for this order.
	 */
	private Long transactTime;

	private OrderType type;

	public String getClientOrderId()
	{
		return clientOrderId;
	}


	public String getCummulativeQuoteQty()
	{
		return cummulativeQuoteQty;
	}


	public String getExecutedQty()
	{
		return executedQty;
	}


	public List<Trade> getFills()
	{
		return fills;
	}


	public Long getOrderId()
	{
		return orderId;
	}


	public String getOrigQty()
	{
		return origQty;
	}


	public String getPrice()
	{
		return price;
	}


	public OrderSide getSide()
	{
		return side;
	}


	public OrderStatus getStatus()
	{
		return status;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public TimeInForce getTimeInForce()
	{
		return timeInForce;
	}


	public Long getTransactTime()
	{
		return transactTime;
	}


	public OrderType getType()
	{
		return type;
	}


	public void setClientOrderId(String clientOrderId)
	{
		this.clientOrderId = clientOrderId;
	}


	public void setCummulativeQuoteQty(String cummulativeQuoteQty)
	{
		this.cummulativeQuoteQty = cummulativeQuoteQty;
	}


	public void setExecutedQty(String executedQty)
	{
		this.executedQty = executedQty;
	}


	public void setFills(List<Trade> fills)
	{
		this.fills = fills;
	}


	public void setOrderId(Long orderId)
	{
		this.orderId = orderId;
	}


	public void setOrigQty(String origQty)
	{
		this.origQty = origQty;
	}


	public void setPrice(String price)
	{
		this.price = price;
	}


	public void setSide(OrderSide side)
	{
		this.side = side;
	}


	public void setStatus(OrderStatus status)
	{
		this.status = status;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setTimeInForce(TimeInForce timeInForce)
	{
		this.timeInForce = timeInForce;
	}


	public void setTransactTime(Long transactTime)
	{
		this.transactTime = transactTime;
	}


	public void setType(OrderType type)
	{
		this.type = type;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceApiConstants.TO_STRING_BUILDER_STYLE ).append( "symbol", symbol )
				.append( "orderId", orderId ).append( "clientOrderId", clientOrderId ).append( "transactTime", transactTime )
				.append( "price", price ).append( "origQty", origQty ).append( "executedQty", executedQty )
				.append( "status", status ).append( "timeInForce", timeInForce ).append( "type", type ).append( "side", side )
				.append( "fills", Optional.ofNullable( fills ).orElse( Collections.emptyList() ).stream().map( Object::toString )
						.collect( Collectors.joining( ", " ) ) )
				.toString();
	}
}
