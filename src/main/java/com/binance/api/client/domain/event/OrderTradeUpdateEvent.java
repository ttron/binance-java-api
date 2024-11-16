package com.binance.api.client.domain.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.ExecutionType;
import com.binance.api.client.domain.OrderRejectReason;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderStatus;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Order or trade report update event.
 * <p>
 * This event is embedded as part of a user data update event.
 *
 * @see UserDataUpdateEvent
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderTradeUpdateEvent
{
	/**
	 * Accumulated quantity of filled trades on this order.
	 */
	@JsonProperty("z")
	private String accumulatedQuantity;

	/**
	 * Commission.
	 */
	@JsonProperty("n")
	private String commission;

	/**
	 * Asset on which commission is taken
	 */
	@JsonProperty("N")
	private String commissionAsset;

	/**
	 * Cumulative quote asset transacted quantity.
	 */
	@JsonProperty("Z")
	private String cumulativeQuoteQty;

	@JsonProperty("E")
	private Long eventTime;

	@JsonProperty("e")
	private String eventType;

	/**
	 * Type of execution.
	 */
	@JsonProperty("x")
	private ExecutionType executionType;

	/**
	 * Last quote asset transacted quantity (i.e. lastPrice * lastQty).
	 */
	@JsonProperty("Y")
	private String lastQuoteQty;

	@JsonProperty("c")
	private String newClientOrderId;

	/**
	 * Order creation time.
	 */
	@JsonProperty("O")
	private Long orderCreationTime;

	/**
	 * Order id.
	 */
	@JsonProperty("i")
	private Long orderId;

	/**
	 * Reason why the order was rejected.
	 */
	@JsonProperty("r")
	private OrderRejectReason orderRejectReason;

	/**
	 * Status of the order.
	 */
	@JsonProperty("X")
	private OrderStatus orderStatus;

	/**
	 * Order/trade time.
	 */
	@JsonProperty("T")
	private Long orderTradeTime;

	@JsonProperty("C")
	private String originalClientOrderId;

	/**
	 * Original quantity in the order.
	 */
	@JsonProperty("q")
	private String originalQuantity;

	/**
	 * Price.
	 */
	@JsonProperty("p")
	private String price;

	/**
	 * Price of last filled trade.
	 */
	@JsonProperty("L")
	private String priceOfLastFilledTrade;

	/**
	 * Quantity of the last filled trade.
	 */
	@JsonProperty("l")
	private String quantityLastFilledTrade;

	/**
	 * Quote Order Qty.
	 */
	@JsonProperty("Q")
	private String quoteOrderQty;

	/**
	 * Buy/Sell order side.
	 */
	@JsonProperty("S")
	private OrderSide side;

	@JsonProperty("s")
	private String symbol;

	/**
	 * Time in force to indicate how long will the order remain active.
	 */
	@JsonProperty("f")
	private TimeInForce timeInForce;

	/**
	 * Trade id.
	 */
	@JsonProperty("t")
	private Long tradeId;

	/**
	 * Type of order.
	 */
	@JsonProperty("o")
	private OrderType type;

	public String getAccumulatedQuantity()
	{
		return accumulatedQuantity;
	}


	public String getCommission()
	{
		return commission;
	}


	public String getCommissionAsset()
	{
		return commissionAsset;
	}


	public String getCumulativeQuoteQty()
	{
		return cumulativeQuoteQty;
	}


	public Long getEventTime()
	{
		return eventTime;
	}


	public String getEventType()
	{
		return eventType;
	}


	public ExecutionType getExecutionType()
	{
		return executionType;
	}


	public String getLastQuoteQty()
	{
		return lastQuoteQty;
	}


	public String getNewClientOrderId()
	{
		return newClientOrderId;
	}


	public Long getOrderCreationTime()
	{
		return orderCreationTime;
	}


	public Long getOrderId()
	{
		return orderId;
	}


	public OrderRejectReason getOrderRejectReason()
	{
		return orderRejectReason;
	}


	public OrderStatus getOrderStatus()
	{
		return orderStatus;
	}


	public Long getOrderTradeTime()
	{
		return orderTradeTime;
	}


	public String getOriginalClientOrderId()
	{
		return originalClientOrderId;
	}


	public String getOriginalQuantity()
	{
		return originalQuantity;
	}


	public String getPrice()
	{
		return price;
	}


	public String getPriceOfLastFilledTrade()
	{
		return priceOfLastFilledTrade;
	}


	public String getQuantityLastFilledTrade()
	{
		return quantityLastFilledTrade;
	}


	public String getQuoteOrderQty()
	{
		return quoteOrderQty;
	}


	public OrderSide getSide()
	{
		return side;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public TimeInForce getTimeInForce()
	{
		return timeInForce;
	}


	public Long getTradeId()
	{
		return tradeId;
	}


	public OrderType getType()
	{
		return type;
	}


	public void setAccumulatedQuantity(String accumulatedQuantity)
	{
		this.accumulatedQuantity = accumulatedQuantity;
	}


	public void setCommission(String commission)
	{
		this.commission = commission;
	}


	public void setCommissionAsset(String commissionAsset)
	{
		this.commissionAsset = commissionAsset;
	}


	public void setCumulativeQuoteQty(String cumulativeQuoteQty)
	{
		this.cumulativeQuoteQty = cumulativeQuoteQty;
	}


	public void setEventTime(Long eventTime)
	{
		this.eventTime = eventTime;
	}


	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}


	public void setExecutionType(ExecutionType executionType)
	{
		this.executionType = executionType;
	}


	public void setLastQuoteQty(String lastQuoteQty)
	{
		this.lastQuoteQty = lastQuoteQty;
	}


	public void setNewClientOrderId(String newClientOrderId)
	{
		this.newClientOrderId = newClientOrderId;
	}


	public void setOrderCreationTime(Long orderCreationTime)
	{
		this.orderCreationTime = orderCreationTime;
	}


	public void setOrderId(Long orderId)
	{
		this.orderId = orderId;
	}


	public void setOrderRejectReason(OrderRejectReason orderRejectReason)
	{
		this.orderRejectReason = orderRejectReason;
	}


	public void setOrderStatus(OrderStatus orderStatus)
	{
		this.orderStatus = orderStatus;
	}


	public void setOrderTradeTime(Long orderTradeTime)
	{
		this.orderTradeTime = orderTradeTime;
	}


	public void setOriginalClientOrderId(String originalClientOrderId)
	{
		this.originalClientOrderId = originalClientOrderId;
	}


	public void setOriginalQuantity(String originalQuantity)
	{
		this.originalQuantity = originalQuantity;
	}


	public void setPrice(String price)
	{
		this.price = price;
	}


	public void setPriceOfLastFilledTrade(String priceOfLastFilledTrade)
	{
		this.priceOfLastFilledTrade = priceOfLastFilledTrade;
	}


	public void setQuantityLastFilledTrade(String quantityLastFilledTrade)
	{
		this.quantityLastFilledTrade = quantityLastFilledTrade;
	}


	public void setQuoteOrderQty(String quoteOrderQty)
	{
		this.quoteOrderQty = quoteOrderQty;
	}


	public void setSide(OrderSide side)
	{
		this.side = side;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setTimeInForce(TimeInForce timeInForce)
	{
		this.timeInForce = timeInForce;
	}


	public void setTradeId(Long tradeId)
	{
		this.tradeId = tradeId;
	}


	public void setType(OrderType type)
	{
		this.type = type;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "eventType", eventType )
				.append( "eventTime", eventTime ).append( "symbol", symbol ).append( "newClientOrderId", newClientOrderId )
				.append( "originalClientOrderId", originalClientOrderId ).append( "side", side ).append( "type", type )
				.append( "timeInForce", timeInForce ).append( "originalQuantity", originalQuantity ).append( "price", price )
				.append( "executionType", executionType ).append( "orderStatus", orderStatus )
				.append( "orderRejectReason", orderRejectReason ).append( "orderId", orderId )
				.append( "quantityLastFilledTrade", quantityLastFilledTrade ).append( "accumulatedQuantity", accumulatedQuantity )
				.append( "priceOfLastFilledTrade", priceOfLastFilledTrade ).append( "commission", commission )
				.append( "commissionAsset", commissionAsset ).append( "orderTradeTime", orderTradeTime )
				.append( "tradeId", tradeId ).append( "orderCreationTime", orderCreationTime )
				.append( "cumulativeQuoteQty", cumulativeQuoteQty ).append( "lastQuoteQty", lastQuoteQty )
				.append( "quoteOrderQty", quoteOrderQty ).toString();
	}
}
