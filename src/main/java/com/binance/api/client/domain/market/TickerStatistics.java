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
	private double askPrice;

	/**
	 * Bid price.
	 */
	private double bidPrice;

	/**
	 * Close time.
	 */
	private long closeTime;

	/**
	 * Total number of trades during the last 24 hours.
	 */
	private int count;

	/**
	 * First trade id.
	 */
	private long firstId;

	/**
	 * Highest price during the past 24 hours.
	 */
	private double highPrice;

	/**
	 * Last trade id.
	 */
	private long lastId;

	/**
	 * Last price.
	 */
	private double lastPrice;

	/**
	 * Lowest price during the past 24 hours.
	 */
	private double lowPrice;

	/**
	 * Open price 24 hours ago.
	 */
	private double openPrice;

	/**
	 * Open time.
	 */
	private long openTime;

	/**
	 * Previous close price.
	 */
	private double prevClosePrice;

	/**
	 * Price change during the last 24 hours.
	 */
	private double priceChange;

	/**
	 * Price change, in percentage, during the last 24 hours.
	 */
	private double priceChangePercent;

	private double quoteVolume;

	/**
	 * Ticker symbol.
	 */
	private String symbol;

	/**
	 * Total volume during the past 24 hours.
	 */
	private double volume;

	/**
	 * Weighted average price.
	 */
	private double weightedAvgPrice;

	public double getAskPrice()
	{
		return askPrice;
	}


	public double getBidPrice()
	{
		return bidPrice;
	}


	public long getCloseTime()
	{
		return closeTime;
	}


	public int getCount()
	{
		return count;
	}


	public long getFirstId()
	{
		return firstId;
	}


	public double getHighPrice()
	{
		return highPrice;
	}


	public long getLastId()
	{
		return lastId;
	}


	public double getLastPrice()
	{
		return lastPrice;
	}


	public double getLowPrice()
	{
		return lowPrice;
	}


	public double getOpenPrice()
	{
		return openPrice;
	}


	public long getOpenTime()
	{
		return openTime;
	}


	public double getPrevClosePrice()
	{
		return prevClosePrice;
	}


	public double getPriceChange()
	{
		return priceChange;
	}


	public double getPriceChangePercent()
	{
		return priceChangePercent;
	}


	public double getQuoteVolume()
	{
		return quoteVolume;
	}


	public String getSymbol()
	{
		return symbol;
	}


	public double getVolume()
	{
		return volume;
	}


	public double getWeightedAvgPrice()
	{
		return weightedAvgPrice;
	}


	public void setAskPrice(double askPrice)
	{
		this.askPrice = askPrice;
	}


	public void setBidPrice(double bidPrice)
	{
		this.bidPrice = bidPrice;
	}


	public void setCloseTime(long closeTime)
	{
		this.closeTime = closeTime;
	}


	public void setCount(int count)
	{
		this.count = count;
	}


	public void setFirstId(long firstId)
	{
		this.firstId = firstId;
	}


	public void setHighPrice(double highPrice)
	{
		this.highPrice = highPrice;
	}


	public void setLastId(long lastId)
	{
		this.lastId = lastId;
	}


	public void setLastPrice(double lastPrice)
	{
		this.lastPrice = lastPrice;
	}


	public void setLowPrice(double lowPrice)
	{
		this.lowPrice = lowPrice;
	}


	public void setOpenPrice(double openPrice)
	{
		this.openPrice = openPrice;
	}


	public void setOpenTime(long openTime)
	{
		this.openTime = openTime;
	}


	public void setPrevClosePrice(double prevClosePrice)
	{
		this.prevClosePrice = prevClosePrice;
	}


	public void setPriceChange(double priceChange)
	{
		this.priceChange = priceChange;
	}


	public void setPriceChangePercent(double priceChangePercent)
	{
		this.priceChangePercent = priceChangePercent;
	}


	public void setQuoteVolume(double quoteVolume)
	{
		this.quoteVolume = quoteVolume;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	public void setVolume(double volume)
	{
		this.volume = volume;
	}


	public void setWeightedAvgPrice(double weightedAvgPrice)
	{
		this.weightedAvgPrice = weightedAvgPrice;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "symbol", symbol )
				.append( "DIFF", priceChange ).append( "DIFF_PRNT", priceChangePercent )
				.append( "weightedAvgPrice", weightedAvgPrice ).append( "prevClosePrice", prevClosePrice )
				.append( "lastPrice", lastPrice ).append( "bidPrice", bidPrice ).append( "askPrice", askPrice )
				.append( "openPrice", openPrice ).append( "highPrice", highPrice ).append( "lowPrice", lowPrice )
				.append( "VOL", volume ).append( "VOL_Q", quoteVolume ).append( "openTime", openTime )
				.append( "closeTime", closeTime ).append( "firstId", firstId ).append( "lastId", lastId ).append( "count", count )
				.toString();
	}
}
