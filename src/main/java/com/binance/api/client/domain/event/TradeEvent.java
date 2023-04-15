package com.binance.api.client.domain.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An single trade event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TradeEvent
{
	@JsonProperty("a")
	private long askOrderId;

	@JsonProperty("b")
	private long bidOrderId;

	@JsonProperty("e")
	private String eventType;

	@JsonProperty("m")
	private boolean isBuyerMaker;

	@JsonProperty("p")
	private String price;

	@JsonProperty("q")
	private String quantity;

	@JsonProperty("s")
	private String symbol;

	@JsonProperty("E")
	private long timestamp;

	@JsonProperty("t")
	private long tradeId;

	@JsonProperty("T")
	private long tradeTimestamp;


	public String getPrice()
	{
		return price;
	}


	public String getQuantity()
	{
		return quantity;
	}


	public long getTradeTime()
	{
		return timestamp;
	}


	public boolean isBuyerMaker()
	{
		return isBuyerMaker;
	}


	public void setBuyerMaker(boolean buyerMaker)
	{
		isBuyerMaker = buyerMaker;
	}


	public void setPrice(String price)
	{
		this.price = price;
	}


	public void setQuantity(String quantity)
	{
		this.quantity = quantity;
	}


	public void setTradeTime(long tradeTime)
	{
		this.timestamp = tradeTime;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "eventType", eventType )
				.append( "millis", timestamp ).append( "symbol", symbol ).append( "price", price ).append( "quantity", quantity )
				.append( "askOrderId", askOrderId ).append( "bidOrderId", bidOrderId ).append( "tradeTime", tradeTimestamp )
				.append( "isBuyerMaker", isBuyerMaker ).toString();
	}
}
