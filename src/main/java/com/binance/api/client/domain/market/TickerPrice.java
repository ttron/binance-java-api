package com.binance.api.client.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.SymbolRR;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Wraps a symbol and its corresponding latest price.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class TickerPrice extends SymbolRR
{

	/**
	 * Latest price.
	 */
	private String price;

	public String getPrice()
	{
		return price;
	}


	public void setPrice(String price)
	{
		this.price = price;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "symbol", symbol )
				.append( "price", price ).toString();
	}
}
