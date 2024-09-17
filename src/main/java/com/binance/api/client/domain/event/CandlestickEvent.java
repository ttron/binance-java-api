package com.binance.api.client.domain.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * An interval candlestick for a symbol providing informations on price that can be used to produce candlestick charts.
 */
@JsonDeserialize(using = CandlestickEventDeserializer.class)
@JsonSerialize(using = CandlestickEventSerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CandlestickEvent
{
	private Double close;

	private Long closeTime;

	private long eventTime;

	private String eventType;

	private Long firstTradeId;

	private Double high;

	private String intervalId;

	private Boolean isBarFinal;

	private Long lastTradeId;

	private Double low;

	private Long numberOfTrades;

	private Double open;

	private Long openTime;

	private Double quoteAssetVolume;

	private String symbol;

	private Double takerBuyBaseAssetVolume;

	private Double takerBuyQuoteAssetVolume;

	private Double volume;

	public Boolean getBarFinal()
	{
		return isBarFinal;
	}


	public Double getClose()
	{
		return close;
	}


	public Long getCloseTime()
	{
		return closeTime;
	}


	public long getEventTime()
	{
		return eventTime;
	}


	public String getEventType()
	{
		return eventType;
	}


	public Long getFirstTradeId()
	{
		return firstTradeId;
	}


	public Double getHigh()
	{
		return high;
	}


	public String getIntervalId()
	{
		return intervalId;
	}


	public Long getLastTradeId()
	{
		return lastTradeId;
	}


	public Double getLow()
	{
		return low;
	}


	public Long getNumberOfTrades()
	{
		return numberOfTrades;
	}


	public Double getOpen()
	{
		return open;
	}


	public Long getOpenTime()
	{
		return openTime;
	}


	public Double getQuoteAssetVolume()
	{
		return quoteAssetVolume;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public Double getTakerBuyBaseAssetVolume()
	{
		return takerBuyBaseAssetVolume;
	}


	public Double getTakerBuyQuoteAssetVolume()
	{
		return takerBuyQuoteAssetVolume;
	}


	public Double getVolume()
	{
		return volume;
	}


	public void setBarFinal(Boolean barFinal)
	{
		isBarFinal = barFinal;
	}


	public void setClose(Double close)
	{
		this.close = close;
	}


	public void setCloseTime(Long closeTime)
	{
		this.closeTime = closeTime;
	}


	public void setEventTime(long eventTime)
	{
		this.eventTime = eventTime;
	}


	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}


	public void setFirstTradeId(Long firstTradeId)
	{
		this.firstTradeId = firstTradeId;
	}


	public void setHigh(Double high)
	{
		this.high = high;
	}


	public void setIntervalId(String intervalId)
	{
		this.intervalId = intervalId;
	}


	public void setLastTradeId(Long lastTradeId)
	{
		this.lastTradeId = lastTradeId;
	}


	public void setLow(Double low)
	{
		this.low = low;
	}


	public void setNumberOfTrades(Long numberOfTrades)
	{
		this.numberOfTrades = numberOfTrades;
	}


	public void setOpen(Double open)
	{
		this.open = open;
	}


	public void setOpenTime(Long openTime)
	{
		this.openTime = openTime;
	}


	public void setQuoteAssetVolume(Double quoteAssetVolume)
	{
		this.quoteAssetVolume = quoteAssetVolume;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setTakerBuyBaseAssetVolume(Double takerBuyBaseAssetVolume)
	{
		this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
	}


	public void setTakerBuyQuoteAssetVolume(Double takerBuyQuoteAssetVolume)
	{
		this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
	}


	public void setVolume(Double volume)
	{
		this.volume = volume;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "eventType", eventType )
				.append( "eventTime", eventTime ).append( "symbol", symbol ).append( "openTime", openTime ).append( "open", open )
				.append( "high", high ).append( "low", low ).append( "close", close ).append( "volume", volume )
				.append( "closeTime", closeTime ).append( "intervalId", intervalId ).append( "firstTradeId", firstTradeId )
				.append( "lastTradeId", lastTradeId ).append( "quoteAssetVolume", quoteAssetVolume )
				.append( "numberOfTrades", numberOfTrades ).append( "takerBuyBaseAssetVolume", takerBuyBaseAssetVolume )
				.append( "takerBuyQuoteAssetVolume", takerBuyQuoteAssetVolume ).append( "isBarFinal", isBarFinal ).toString();
	}
}
