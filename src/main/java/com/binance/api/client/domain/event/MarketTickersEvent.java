package com.binance.api.client.domain.event;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarketTickersEvent
{
	@JsonProperty("e")
	private String eventType;

	@JsonProperty("E")
	private long timestamp;

	@JsonProperty("s")
	private String symbol;

	/**
	 * 24小时价格变化
	 */
	@JsonProperty("p")
	private String priceChange;

	/**
	 * 24小时价格变化（百分比）
	 */
	@JsonProperty("P")
	private String priceChangePercent;

	/**
	 * 平均价格
	 */
	@JsonProperty("w")
	private String weightedAveragePrice;

	/**
	 * 整整24小时之前，向前数的最后一次成交价格
	 */
	@JsonProperty("x")
	private String previousDaysClosePrice;

	/**
	 * 最新成交价格
	 */
	@JsonProperty("c")
	private String currentDaysClosePrice;

	/**
	 * 最新成交交易的成交量
	 */
	@JsonProperty("Q")
	private String closeTradesQuantity;

	/**
	 * 目前最高买单价
	 */
	@JsonProperty("b")
	private String bestBidPrice;

	/**
	 * 目前最高买单价的挂单量
	 */
	@JsonProperty("B")
	private String bestBidQuantity;

	/**
	 * 目前最低卖单价
	 */
	@JsonProperty("a")
	private String bestAskPrice;

	/**
	 * 目前最低卖单价的挂单量
	 */
	@JsonProperty("A")
	private String bestAskQuantity;

	/**
	 * 整整24小时前，向后数的第一次成交价格
	 */
	@JsonProperty("o")
	private String openPrice;

	/**
	 * 24小时内最高成交价
	 */
	@JsonProperty("h")
	private String highPrice;

	/**
	 * 24小时内最低成交加
	 */
	@JsonProperty("l")
	private String lowPrice;

	/**
	 * 24小时内成交量
	 */
	@JsonProperty("v")
	private String totalTradedBaseAssetVolume;

	/**
	 * 4小时内成交额
	 */
	@JsonProperty("q")
	private String totalTradedQuoteAssetVolume;

	/**
	 * 统计开始时间,单位毫秒,为当前时间-‭86,400,000‬(24*3600*1000)
	 */
	@JsonProperty("O")
	private long statisticesOpenTime;

	/**
	 * 统计关闭时间,单位毫秒,为当前时间
	 */
	@JsonProperty("C")
	private long statisticesCloseTime;

	/**
	 * 24小时内第一笔成交交易ID
	 */
	@JsonProperty("F")
	private long firstTradeId;

	/**
	 * 24小时内最后一笔成交交易ID
	 */
	@JsonProperty("L")
	private long lastTradeId;

	/**
	 * 24小时内成交笔数
	 */
	@JsonProperty("n")
	private long totalNumberOfTrades;


	public String getEventType()
	{
		return eventType;
	}


	public void setEventType(String eventType)
	{
		this.eventType = eventType;
	}


	public long getTimestamp()
	{
		return timestamp;
	}


	public void setTimestamp(long timestamp)
	{
		this.timestamp = timestamp;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public String getPriceChange()
	{
		return priceChange;
	}


	public void setPriceChange(String priceChange)
	{
		this.priceChange = priceChange;
	}


	public String getPriceChangePercent()
	{
		return priceChangePercent;
	}


	public void setPriceChangePercent(String priceChangePercent)
	{
		this.priceChangePercent = priceChangePercent;
	}


	public String getWeightedAveragePrice()
	{
		return weightedAveragePrice;
	}


	public void setWeightedAveragePrice(String weightedAveragePrice)
	{
		this.weightedAveragePrice = weightedAveragePrice;
	}


	public String getPreviousDaysClosePrice()
	{
		return previousDaysClosePrice;
	}


	public void setPreviousDaysClosePrice(String previousDaysClosePrice)
	{
		this.previousDaysClosePrice = previousDaysClosePrice;
	}


	public String getCurrentDaysClosePrice()
	{
		return currentDaysClosePrice;
	}


	public void setCurrentDaysClosePrice(String currentDaysClosePrice)
	{
		this.currentDaysClosePrice = currentDaysClosePrice;
	}


	public String getCloseTradesQuantity()
	{
		return closeTradesQuantity;
	}


	public void setCloseTradesQuantity(String closeTradesQuantity)
	{
		this.closeTradesQuantity = closeTradesQuantity;
	}


	public String getBestBidPrice()
	{
		return bestBidPrice;
	}


	public void setBestBidPrice(String bestBidPrice)
	{
		this.bestBidPrice = bestBidPrice;
	}


	public String getBestBidQuantity()
	{
		return bestBidQuantity;
	}


	public void setBestBidQuantity(String bestBidQuantity)
	{
		this.bestBidQuantity = bestBidQuantity;
	}


	public String getBestAskPrice()
	{
		return bestAskPrice;
	}


	public void setBestAskPrice(String bestAskPrice)
	{
		this.bestAskPrice = bestAskPrice;
	}


	public String getBestAskQuantity()
	{
		return bestAskQuantity;
	}


	public void setBestAskQuantity(String bestAskQuantity)
	{
		this.bestAskQuantity = bestAskQuantity;
	}


	public String getOpenPrice()
	{
		return openPrice;
	}


	public void setOpenPrice(String openPrice)
	{
		this.openPrice = openPrice;
	}


	public String getHighPrice()
	{
		return highPrice;
	}


	public void setHighPrice(String highPrice)
	{
		this.highPrice = highPrice;
	}


	public String getLowPrice()
	{
		return lowPrice;
	}


	public void setLowPrice(String lowPrice)
	{
		this.lowPrice = lowPrice;
	}


	public String getTotalTradedBaseAssetVolume()
	{
		return totalTradedBaseAssetVolume;
	}


	public void setTotalTradedBaseAssetVolume(String totalTradedBaseAssetVolume)
	{
		this.totalTradedBaseAssetVolume = totalTradedBaseAssetVolume;
	}


	public String getTotalTradedQuoteAssetVolume()
	{
		return totalTradedQuoteAssetVolume;
	}


	public void setTotalTradedQuoteAssetVolume(String totalTradedQuoteAssetVolume)
	{
		this.totalTradedQuoteAssetVolume = totalTradedQuoteAssetVolume;
	}


	public long getStatisticesOpenTime()
	{
		return statisticesOpenTime;
	}


	public void setStatisticesOpenTime(long statisticesOpenTime)
	{
		this.statisticesOpenTime = statisticesOpenTime;
	}


	public long getStatisticesCloseTime()
	{
		return statisticesCloseTime;
	}


	public void setStatisticesCloseTime(long statisticesCloseTime)
	{
		this.statisticesCloseTime = statisticesCloseTime;
	}


	public long getFirstTradeId()
	{
		return firstTradeId;
	}


	public void setFirstTradeId(long firstTradeId)
	{
		this.firstTradeId = firstTradeId;
	}


	public long getLastTradeId()
	{
		return lastTradeId;
	}


	public void setLastTradeId(long lastTradeId)
	{
		this.lastTradeId = lastTradeId;
	}


	public long getTotalNumberOfTrades()
	{
		return totalNumberOfTrades;
	}


	public void setTotalNumberOfTrades(long totalNumberOfTrades)
	{
		this.totalNumberOfTrades = totalNumberOfTrades;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "eventType", eventType )
				.append( "eventTime", timestamp ).append( "symbol", symbol ).append( "priceChange", priceChange )
				.append( "priceChangePercent", priceChangePercent ).append( "weightedAveragePrice", weightedAveragePrice )
				.append( "previousDaysClosePrice", previousDaysClosePrice )
				.append( "currentDaysClosePrice", currentDaysClosePrice ).append( "closeTradesQuantity", closeTradesQuantity )
				.append( "bestBidPrice", bestBidPrice ).append( "bestBidQuantity", bestBidQuantity )
				.append( "bestAskPrice", bestAskPrice ).append( "bestAskQuantity", bestAskQuantity )
				.append( "openPrice", openPrice ).append( "highPrice", highPrice ).append( "lowPrice", lowPrice )
				.append( "totalTradedBaseAssetVolume", totalTradedBaseAssetVolume )
				.append( "totalTradedQuoteAssetVolume", totalTradedQuoteAssetVolume )
				.append( "statisticesOpenTime", statisticesOpenTime ).append( "statisticesCloseTime", statisticesCloseTime )
				.append( "firstTradeId", firstTradeId ).append( "lastTradeId", lastTradeId )
				.append( "totalNumberOfTrades", totalNumberOfTrades ).toString();
	}
}
