package com.binance.api.client.domain.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.market.AggTrade;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * An aggregated trade event for a symbol.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AggTradeEvent extends AggTrade
{
	@JsonProperty("e")
	private String eventType;

	@JsonProperty("s")
	private String symbol;

	@JsonProperty("E")
	private long timestamp;


	public String getEventType()
	{
		return eventType;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public long getTimestamp()
	{
		return timestamp;
	}


	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setTimestamp(long eventTime)
	{
		this.timestamp = eventTime;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceApiConstants.TO_STRING_BUILDER_STYLE ).append( "eventType", eventType )
				.append( "eventTime", timestamp ).append( "symbol", symbol ).append( "aggTrade", super.toString() ).toString();
	}
}
