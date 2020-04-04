package com.binance.api.client.domain.event;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.market.OrderBookEntry;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Depth delta event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepthEvent
{
	/**
	 * Ask depth delta.
	 */
	@JsonProperty("a")
	private List<OrderBookEntry> asks;

	/**
	 * Bid depth delta.
	 */
	@JsonProperty("b")
	private List<OrderBookEntry> bids;

	@JsonProperty("e")
	private String eventType;

	/**
	 * updateId to sync up with updateid in /api/v1/depth
	 */
	@JsonProperty("u")
	private long finalUpdateId;

	@JsonProperty("U")
	private long firstUpdateId;

	@JsonProperty("s")
	private String symbol;

	@JsonProperty("E")
	private long timestamp;


	public List<OrderBookEntry> getAsks()
	{
		return asks;
	}


	public List<OrderBookEntry> getBids()
	{
		return bids;
	}


	public String getEventType()
	{
		return eventType;
	}


	public long getFinalUpdateId()
	{
		return finalUpdateId;
	}


	public long getFirstUpdateId()
	{
		return firstUpdateId;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public long getTimestamp()
	{
		return timestamp;
	}


	/**
	 * @deprecated Use {@link #getFinalUpdateId}
	 */
	@Deprecated
	public long getUpdateId()
	{
		return finalUpdateId;
	}


	public void setAsks(List<OrderBookEntry> asks)
	{
		this.asks = asks;
	}


	public void setBids(List<OrderBookEntry> bids)
	{
		this.bids = bids;
	}


	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}


	public void setFinalUpdateId(long finalUpdateId)
	{
		this.finalUpdateId = finalUpdateId;
	}


	public void setFirstUpdateId(final long firstUpdateId)
	{
		this.firstUpdateId = firstUpdateId;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setTimestamp(long timestamp)
	{
		this.timestamp = timestamp;
	}


	/**
	 * @deprecated Use {@link #setFinalUpdateId}
	 */
	@Deprecated
	public void setUpdateId(long updateId)
	{
		this.finalUpdateId = updateId;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceApiConstants.TO_STRING_BUILDER_STYLE ).append( "eventType", eventType )
				.append( "millis", timestamp ).append( "symbol", symbol )
				.append( "U-u", (finalUpdateId - firstUpdateId) + " (" + firstUpdateId + "->" + finalUpdateId + ")" ).toString();
		// .append( "bids", bids ).append( "asks", asks ).toString();
	}
}
