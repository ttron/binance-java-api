package com.binance.api.client.domain.account;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.TimeInForce;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * A trade order to enter or exit a position.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class NewOrder
{
	/**
	 * Places a LIMIT buy order for the given <code>quantity</code> and <code>price</code>.
	 * @param symbol
	 * @param timeInForce
	 * @param quantity
	 * @param price
	 * @return a new order which is pre-configured with LIMIT as the order type and BUY as the order side.
	 */
	public static NewOrder limitBuy(String symbol, TimeInForce timeInForce, String quantity, String price)
	{
		return new NewOrder( symbol, OrderSide.BUY, OrderType.LIMIT, timeInForce, quantity, price );
	}


	/**
	 * Places a LIMIT sell order for the given <code>quantity</code> and <code>price</code>.
	 *
	 * @return a new order which is pre-configured with LIMIT as the order type and SELL as the order side.
	 */
	public static NewOrder limitSell(String symbol, TimeInForce timeInForce, String quantity, String price)
	{
		return new NewOrder( symbol, OrderSide.SELL, OrderType.LIMIT, timeInForce, quantity, price );
	}


	/**
	 * Places a MARKET buy order for the given <code>quantity</code>.
	 *
	 * @return a new order which is pre-configured with MARKET as the order type and BUY as the order side.
	 */
	public static NewOrder marketBuy(String symbol, String quantity)
	{
		return new NewOrder( symbol, OrderSide.BUY, OrderType.MARKET, null, quantity );
	}


	public static NewOrder marketBuy(String unid, String symbol, String quantity)
	{
		return new NewOrder( symbol, OrderSide.BUY, OrderType.MARKET, null, quantity ).newClientOrderId( unid );
	}


	public static NewOrder marketBuyQuote(String unid, String symbol, String quoteQuantity)
	{
		return new NewOrder( symbol, OrderSide.BUY, null, quoteQuantity ).newClientOrderId( unid );
	}


	/**
	 * Places a MARKET sell order for the given <code>quantity</code>.
	 *
	 * @return a new order which is pre-configured with MARKET as the order type and SELL as the order side.
	 */
	public static NewOrder marketSell(String symbol, String quantity)
	{
		return new NewOrder( symbol, OrderSide.SELL, OrderType.MARKET, null, quantity );
	}


	public static NewOrder marketSell(String unid, String symbol, String quantity)
	{
		return new NewOrder( symbol, OrderSide.SELL, OrderType.MARKET, null, quantity ).newClientOrderId( unid );
	}

	/**
	 * Used with iceberg orders.
	 */
	private String icebergQty;

	/**
	 * A unique id for the order. Automatically generated if not sent.
	 */
	protected String newClientOrderId;

	/**
	 * Set the response JSON. ACK, RESULT, or FULL; default: RESULT.
	 */
	private NewOrderResponseType newOrderRespType;

	/**
	 * Price.
	 */
	private String price;

	/**
	 * Quantity.
	 */
	private String quantity;

	/**
	 * Quote quantity.
	 */
	private String quoteOrderQty;

	/**
	 * Receiving window.
	 */
	private Long recvWindow;

	/**
	 * Buy/Sell order side.
	 */
	private OrderSide side;

	/**
	 * Used with stop orders.
	 */
	private String stopPrice;

	/**
	 * Symbol to place the order on.
	 */
	private String symbol;

	/**
	 * Time in force to indicate how long will the order remain active.
	 */
	private TimeInForce timeInForce;

	/**
	 * Order timestamp.
	 */
	private long timestamp;

	/**
	 * Type of order.
	 */
	private OrderType type;

	/**
	 * Creates a new order with all required parameters.
	 */
	public NewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, String quantity)
	{
		this.symbol = symbol;
		this.side = side;
		this.type = type;
		this.timeInForce = timeInForce;
		this.quantity = quantity;
		this.newOrderRespType = NewOrderResponseType.RESULT;
		this.timestamp = System.currentTimeMillis();
		this.recvWindow = BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW;
	}


	/**
	 * Creates a new order with all required parameters plus price, which is optional for MARKET orders.
	 */
	public NewOrder(String symbol, OrderSide side, OrderType type, TimeInForce timeInForce, String quantity, String price)
	{
		this( symbol, side, type, timeInForce, quantity );
		this.price = price;
	}


	public NewOrder(String symbol, OrderSide side, String quantity, String quoteQuantity)
	{
		this.symbol = symbol;
		this.side = side;
		this.type = OrderType.MARKET;
		this.quantity = quantity;
		this.quantity = quoteQuantity;
		this.newOrderRespType = NewOrderResponseType.RESULT;
		this.timestamp = System.currentTimeMillis();
		this.recvWindow = BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW;
	}


	public String getIcebergQty()
	{
		return icebergQty;
	}


	public String getNewClientOrderId()
	{
		return newClientOrderId;
	}


	public NewOrderResponseType getNewOrderRespType()
	{
		return newOrderRespType;
	}


	public String getPrice()
	{
		return price;
	}


	public String getQuantity()
	{
		return quantity;
	}


	public String getQuoteOrderQty()
	{
		return quoteOrderQty;
	}


	public Long getRecvWindow()
	{
		return recvWindow;
	}


	public OrderSide getSide()
	{
		return side;
	}


	public String getStopPrice()
	{
		return stopPrice;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public TimeInForce getTimeInForce()
	{
		return timeInForce;
	}


	public long getTimestamp()
	{
		return timestamp;
	}


	public OrderType getType()
	{
		return type;
	}


	public NewOrder icebergQty(String icebergQty)
	{
		this.icebergQty = icebergQty;
		return this;
	}


	public NewOrder newClientOrderId(String newClientOrderId)
	{
		this.newClientOrderId = newClientOrderId;
		return this;
	}


	public NewOrder newOrderRespType(NewOrderResponseType newOrderRespType)
	{
		this.newOrderRespType = newOrderRespType;
		return this;
	}


	public NewOrder price(String price)
	{
		this.price = price;
		return this;
	}


	public NewOrder quantity(String quantity)
	{
		this.quantity = quantity;
		return this;
	}


	public NewOrder quoteOrderQty(String quoteOrderQty)
	{
		this.quoteOrderQty = quoteOrderQty;
		return this;
	}


	public NewOrder recvWindow(Long recvWindow)
	{
		this.recvWindow = recvWindow;
		return this;
	}


	public NewOrder side(OrderSide side)
	{
		this.side = side;
		return this;
	}


	public NewOrder stopPrice(String stopPrice)
	{
		this.stopPrice = stopPrice;
		return this;
	}


	public NewOrder symbol(String symbol)
	{
		this.symbol = symbol;
		return this;
	}


	public NewOrder timeInForce(TimeInForce timeInForce)
	{
		this.timeInForce = timeInForce;
		return this;
	}


	public NewOrder timestamp(long timestamp)
	{
		this.timestamp = timestamp;
		return this;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "symbol", symbol )
				.append( "side", side ).append( "type", type ).append( "quantity", quantity )
				.append( "quoteOrderQty", quoteOrderQty ).append( "price", price ).append( "stopPrice", stopPrice )
				.append( "newClientOrderId", newClientOrderId ).append( "timestamp", timestamp )
				.append( "icebergQty", icebergQty ).append( "newOrderRespType", newOrderRespType )
				.append( "recvWindow", recvWindow ).append( "timeInForce", timeInForce ).toString();
	}


	public NewOrder type(OrderType type)
	{
		this.type = type;
		return this;
	}
}
