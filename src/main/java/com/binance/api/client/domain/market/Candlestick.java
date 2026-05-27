package com.binance.api.client.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.SymbolOHLC;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

/**
 * Kline/Candlestick bars for a symbol. Klines are uniquely identified by their open time.
 */
@JsonFormat(shape = JsonFormat.Shape.ARRAY)
@JsonPropertyOrder()
@JsonIgnoreProperties(ignoreUnknown = true)
public class Candlestick extends SymbolOHLC
{
	// [
	// [
	// 1499040000000, // Kline open time
	// "0.01634790", // Open price
	// "0.80000000", // High price
	// "0.01575800", // Low price
	// "0.01577100", // Close price
	// "148976.11427815", // Volume
	// 1499644799999, // Kline Close time
	// "2434.19055334", // Quote asset volume
	// 308, // Number of trades
	// "1756.87402397", // Taker buy base asset volume
	// "28.46694368", // Taker buy quote asset volume
	// "0" // Unused field, ignore.
	// ]
	// ]

	private Long closeTime;

	private Long numberOfTrades;

	private Long openTime;

	private Double quoteAssetVolume;

	private Double takerBuyBaseAssetVolume;

	private Double takerBuyQuoteAssetVolume;

	public Long getCloseTime()
	{
		return closeTime;
	}


	public Long getNumberOfTrades()
	{
		return numberOfTrades;
	}


	public Long getOpenTime()
	{
		return openTime;
	}


	public Double getQuoteAssetVolume()
	{
		return quoteAssetVolume;
	}


	public Double getTakerBuyBaseAssetVolume()
	{
		return takerBuyBaseAssetVolume;
	}


	public Double getTakerBuyQuoteAssetVolume()
	{
		return takerBuyQuoteAssetVolume;
	}


	public void setCloseTime(Long closeTime)
	{
		this.closeTime = closeTime;
	}


	public void setNumberOfTrades(Long numberOfTrades)
	{
		this.numberOfTrades = numberOfTrades;
	}


	public void setOpenTime(Long openTime)
	{
		this.openTime = openTime;
	}


	public void setQuoteAssetVolume(Double quoteAssetVolume)
	{
		this.quoteAssetVolume = quoteAssetVolume;
	}


	public void setTakerBuyBaseAssetVolume(Double takerBuyBaseAssetVolume)
	{
		this.takerBuyBaseAssetVolume = takerBuyBaseAssetVolume;
	}


	public void setTakerBuyQuoteAssetVolume(Double takerBuyQuoteAssetVolume)
	{
		this.takerBuyQuoteAssetVolume = takerBuyQuoteAssetVolume;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "EPH_FROM", openTime )
				.append( "EPH_TO", closeTime ).append( "O", open ).append( "H", high ).append( "L", low ).append( "C", close )
				.append( "V_B", volume ).append( "V_Q", quoteAssetVolume ).append( "numberOfTrades", numberOfTrades )
				.append( "takerBuyV_B", takerBuyBaseAssetVolume ).append( "takerBuyV_Q", takerBuyQuoteAssetVolume ).toString();
	}
}
