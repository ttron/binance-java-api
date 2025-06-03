package com.binance.api.client.domain.general;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.exception.BinanceAPIException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Current exchange trading rules and symbol information.
 * https://github.com/binance-exchange/binance-official-api-docs/blob/master/rest-api.md
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class ExchangeInfo
{
	private List<RateLimit> rateLimits;

	private Long serverTime;

	// private List<String> exchangeFilters;

	private List<SmartOrderRouting> sors;

	private List<SymbolInfo> symbols;

	private String timezone;

	public List<RateLimit> getRateLimits()
	{
		return rateLimits;
	}


	public Long getServerTime()
	{
		return serverTime;
	}


	public SmartOrderRouting getSmartOrderRouting(String baseAsset)
	{
		return sors.stream().filter( sor -> sor.getBaseAsset().equals( baseAsset ) ).findFirst()
				.orElseThrow( () -> new BinanceAPIException( "Unable to obtain information for symbol " + baseAsset ) );
	}


	public List<SmartOrderRouting> getSors()
	{
		return sors;
	}


	/**
	 * @param symbol the symbol to obtain information for (e.g. ETHBTC)
	 * @return symbol exchange information
	 */
	public SymbolInfo getSymbolInfo(String symbol)
	{
		return symbols.stream().filter( symbolInfo -> symbolInfo.getSymbol().equals( symbol ) ).findFirst()
				.orElseThrow( () -> new BinanceAPIException( "Unable to obtain information for symbol " + symbol ) );
	}


	public List<SymbolInfo> getSymbols()
	{
		return symbols;
	}


	public String getTimezone()
	{
		return timezone;
	}


	public void setRateLimits(List<RateLimit> rateLimits)
	{
		this.rateLimits = rateLimits;
	}


	public void setServerTime(Long serverTime)
	{
		this.serverTime = serverTime;
	}


	public void setSors(List<SmartOrderRouting> sors)
	{
		this.sors = sors;
	}


	public void setSymbols(List<SymbolInfo> symbols)
	{
		this.symbols = symbols;
	}


	public void setTimezone(String timezone)
	{
		this.timezone = timezone;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "timezone", timezone )
				.append( "serverTime", serverTime ).append( "rateLimits", rateLimits ).append( "symbols", symbols ).toString();
	}
}
