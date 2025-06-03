package com.binance.api.client.domain.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerEvent
{
	@JsonProperty("a")
	private String bestAskPrice;

	@JsonProperty("A")
	private String bestAskQuantity;

	@JsonProperty("b")
	private String bestBidPrice;

	@JsonProperty("B")
	private String bestBidQuantity;

	@JsonProperty("Q")
	private String closeTradesQuantity;

	@JsonProperty("c")
	private String currentDaysClosePrice;

	@JsonProperty("E")
	private long eventTime;

	@JsonProperty("e")
	private String eventType;

	@JsonProperty("F")
	private long firstTradeId;

	@JsonProperty("h")
	private String highPrice;

	@JsonProperty("L")
	private long lastTradeId;

	@JsonProperty("l")
	private String lowPrice;

	@JsonProperty("o")
	private String openPrice;

	@JsonProperty("x")
	private String previousDaysClosePrice;

	@JsonProperty("p")
	private String priceChange;

	@JsonProperty("P")
	private String priceChangePercent;

	@JsonProperty("C")
	private long statisticsCloseTime;

	@JsonProperty("O")
	private long statisticsOpenTime;

	@JsonProperty("s")
	private String symbol;

	@JsonProperty("n")
	private long totalNumberOfTrades;

	@JsonProperty("v")
	private String totalTradedBaseAssetVolume;

	@JsonProperty("q")
	private String totalTradedQuoteAssetVolume;

	@JsonProperty("w")
	private String weightedAveragePrice;

	public String getBestAskPrice()
	{
		return bestAskPrice;
	}


	public String getBestAskQuantity()
	{
		return bestAskQuantity;
	}


	public String getBestBidPrice()
	{
		return bestBidPrice;
	}


	public String getBestBidQuantity()
	{
		return bestBidQuantity;
	}


	public String getCloseTradesQuantity()
	{
		return closeTradesQuantity;
	}


	public String getCurrentDaysClosePrice()
	{
		return currentDaysClosePrice;
	}


	public long getEventTime()
	{
		return eventTime;
	}


	public String getEventType()
	{
		return eventType;
	}


	public long getFirstTradeId()
	{
		return firstTradeId;
	}


	public String getHighPrice()
	{
		return highPrice;
	}


	public long getLastTradeId()
	{
		return lastTradeId;
	}


	public String getLowPrice()
	{
		return lowPrice;
	}


	public String getOpenPrice()
	{
		return openPrice;
	}


	public String getPreviousDaysClosePrice()
	{
		return previousDaysClosePrice;
	}


	public String getPriceChange()
	{
		return priceChange;
	}


	public String getPriceChangePercent()
	{
		return priceChangePercent;
	}


	public long getStatisticsCloseTime()
	{
		return statisticsCloseTime;
	}


	public long getStatisticsOpenTime()
	{
		return statisticsOpenTime;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public long getTotalNumberOfTrades()
	{
		return totalNumberOfTrades;
	}


	public String getTotalTradedBaseAssetVolume()
	{
		return totalTradedBaseAssetVolume;
	}


	public String getTotalTradedQuoteAssetVolume()
	{
		return totalTradedQuoteAssetVolume;
	}


	public String getWeightedAveragePrice()
	{
		return weightedAveragePrice;
	}


	public void setBestAskPrice(String bestAskPrice)
	{
		this.bestAskPrice = bestAskPrice;
	}


	public void setBestAskQuantity(String bestAskQuantity)
	{
		this.bestAskQuantity = bestAskQuantity;
	}


	public void setBestBidPrice(String bestBidPrice)
	{
		this.bestBidPrice = bestBidPrice;
	}


	public void setBestBidQuantity(String bestBidQuantity)
	{
		this.bestBidQuantity = bestBidQuantity;
	}


	public void setCloseTradesQuantity(String closeTradesQuantity)
	{
		this.closeTradesQuantity = closeTradesQuantity;
	}


	public void setCurrentDaysClosePrice(String currentDaysClosePrice)
	{
		this.currentDaysClosePrice = currentDaysClosePrice;
	}


	public void setEventTime(long eventTime)
	{
		this.eventTime = eventTime;
	}


	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}


	public void setFirstTradeId(long firstTradeId)
	{
		this.firstTradeId = firstTradeId;
	}


	public void setHighPrice(String highPrice)
	{
		this.highPrice = highPrice;
	}


	public void setLastTradeId(long lastTradeId)
	{
		this.lastTradeId = lastTradeId;
	}


	public void setLowPrice(String lowPrice)
	{
		this.lowPrice = lowPrice;
	}


	public void setOpenPrice(String openPrice)
	{
		this.openPrice = openPrice;
	}


	public void setPreviousDaysClosePrice(String previousDaysClosePrice)
	{
		this.previousDaysClosePrice = previousDaysClosePrice;
	}


	public void setPriceChange(String priceChange)
	{
		this.priceChange = priceChange;
	}


	public void setPriceChangePercent(String priceChangePercent)
	{
		this.priceChangePercent = priceChangePercent;
	}


	public void setStatisticsCloseTime(long statisticsCloseTime)
	{
		this.statisticsCloseTime = statisticsCloseTime;
	}


	public void setStatisticsOpenTime(long statisticsOpenTime)
	{
		this.statisticsOpenTime = statisticsOpenTime;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setTotalNumberOfTrades(long totalNumberOfTrades)
	{
		this.totalNumberOfTrades = totalNumberOfTrades;
	}


	public void setTotalTradedBaseAssetVolume(String totalTradedBaseAssetVolume)
	{
		this.totalTradedBaseAssetVolume = totalTradedBaseAssetVolume;
	}


	public void setTotalTradedQuoteAssetVolume(String totalTradedQuoteAssetVolume)
	{
		this.totalTradedQuoteAssetVolume = totalTradedQuoteAssetVolume;
	}


	public void setWeightedAveragePrice(String weightedAveragePrice)
	{
		this.weightedAveragePrice = weightedAveragePrice;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "eventType", eventType )
				.append( "eventTime", eventTime ).append( "symbol", symbol ).append( "priceChange", priceChange )
				.append( "priceChangePercent", priceChangePercent ).append( "weightedAveragePrice", weightedAveragePrice )
				.append( "previousDaysClosePrice", previousDaysClosePrice )
				.append( "currentDaysClosePrice", currentDaysClosePrice ).append( "closeTradesQuantity", closeTradesQuantity )
				.append( "bestBidPrice", bestBidPrice ).append( "bestBidQuantity", bestBidQuantity )
				.append( "bestAskPrice", bestAskPrice ).append( "bestAskQuantity", bestAskQuantity )
				.append( "openPrice", openPrice ).append( "highPrice", highPrice ).append( "lowPrice", lowPrice )
				.append( "totalTradedBaseAssetVolume", totalTradedBaseAssetVolume )
				.append( "totalTradedQuoteAssetVolume", totalTradedQuoteAssetVolume )
				.append( "statisticsOpenTime", statisticsOpenTime ).append( "statisticsCloseTime", statisticsCloseTime )
				.append( "firstTradeId", firstTradeId ).append( "lastTradeId", lastTradeId )
				.append( "totalNumberOfTrades", totalNumberOfTrades ).toString();
	}
}
