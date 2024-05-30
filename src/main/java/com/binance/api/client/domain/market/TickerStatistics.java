package com.binance.api.client.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * 24 hour price change statistics for a ticker.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerStatistics
{
	/**
	 * Ask price.
	 */
	private String askPrice;

	/**
	 * Bid price.
	 */
	private String bidPrice;

	/**
	 * Close time.
	 */
	private long closeTime;

	/**
	 * Total number of trades during the last 24 hours.
	 */
	private long count;

	/**
	 * First trade id.
	 */
	private long firstId;

	/**
	 * Highest price during the past 24 hours.
	 */
	private String highPrice;

	/**
	 * Last trade id.
	 */
	private long lastId;

	/**
	 * Last price.
	 */
	private String lastPrice;

	/**
	 * Lowest price during the past 24 hours.
	 */
	private String lowPrice;

	/**
	 * Open price 24 hours ago.
	 */
	private String openPrice;

	/**
	 * Open time.
	 */
	private long openTime;

	/**
	 * Previous close price.
	 */
	private String prevClosePrice;

	/**
	 * Price change during the last 24 hours.
	 */
	private String priceChange;

	/**
	 * Price change, in percentage, during the last 24 hours.
	 */
	private String priceChangePercent;


	private String quoteVolume;

	/**
	 * Ticker symbol.
	 */
	private String symbol;

	/**
	 * Total volume during the past 24 hours.
	 */
	private String volume;

	/**
	 * Weighted average price.
	 */
	private String weightedAvgPrice;

	public String getAskPrice()
	{
		return askPrice;
	}

	public String getBidPrice()
	{
		return bidPrice;
	}

	public long getCloseTime()
	{
		return closeTime;
	}


	public long getCount()
	{
		return count;
	}


	public long getFirstId()
	{
		return firstId;
	}


	public String getHighPrice()
	{
		return highPrice;
	}


	public long getLastId()
	{
		return lastId;
	}


	public String getLastPrice()
	{
		return lastPrice;
	}


	public String getLowPrice()
	{
		return lowPrice;
	}


	public String getOpenPrice()
	{
		return openPrice;
	}


	public long getOpenTime()
	{
		return openTime;
	}


	public String getPrevClosePrice()
	{
		return prevClosePrice;
	}


	public String getPriceChange()
	{
		return priceChange;
	}


	public String getPriceChangePercent()
	{
		return priceChangePercent;
	}


	public String getQuoteVolume()
	{
		return quoteVolume;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public String getVolume()
	{
		return volume;
	}


	public String getWeightedAvgPrice()
	{
		return weightedAvgPrice;
	}


	public void setAskPrice(String askPrice)
	{
		this.askPrice = askPrice;
	}


	public void setBidPrice(String bidPrice)
	{
		this.bidPrice = bidPrice;
	}


	public void setCloseTime(long closeTime)
	{
		this.closeTime = closeTime;
	}


	public void setCount(long count)
	{
		this.count = count;
	}


	public void setFirstId(long firstId)
	{
		this.firstId = firstId;
	}


	public void setHighPrice(String highPrice)
	{
		this.highPrice = highPrice;
	}


	public void setLastId(long lastId)
	{
		this.lastId = lastId;
	}


	public void setLastPrice(String lastPrice)
	{
		this.lastPrice = lastPrice;
	}


	public void setLowPrice(String lowPrice)
	{
		this.lowPrice = lowPrice;
	}


	public void setOpenPrice(String openPrice)
	{
		this.openPrice = openPrice;
	}


	public void setOpenTime(long openTime)
	{
		this.openTime = openTime;
	}


	public void setPrevClosePrice(String prevClosePrice)
	{
		this.prevClosePrice = prevClosePrice;
	}


	public void setPriceChange(String priceChange)
	{
		this.priceChange = priceChange;
	}


	public void setPriceChangePercent(String priceChangePercent)
	{
		this.priceChangePercent = priceChangePercent;
	}


	public void setQuoteVolume(String quoteVolume)
	{
		this.quoteVolume = quoteVolume;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setVolume(String volume)
	{
		this.volume = volume;
	}


	public void setWeightedAvgPrice(String weightedAvgPrice)
	{
		this.weightedAvgPrice = weightedAvgPrice;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "symbol", symbol )
				.append( "priceChange", priceChange ).append( "priceChangePercent", priceChangePercent )
				.append( "weightedAvgPrice", weightedAvgPrice ).append( "prevClosePrice", prevClosePrice )
				.append( "lastPrice", lastPrice ).append( "bidPrice", bidPrice ).append( "askPrice", askPrice )
				.append( "openPrice", openPrice ).append( "highPrice", highPrice ).append( "lowPrice", lowPrice )
				.append( "volume", volume ).append( "openTime", openTime ).append( "closeTime", closeTime )
				.append( "firstId", firstId ).append( "lastId", lastId ).append( "count", count ).toString();
	}
}
