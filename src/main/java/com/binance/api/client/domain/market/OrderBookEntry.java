package com.binance.api.client.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * An order book entry consisting of price and quantity.
 */
@JsonDeserialize(using = OrderBookEntryDeserializer.class)
@JsonSerialize(using = OrderBookEntrySerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBookEntry
{
	private String price;

	private String qty;

	public String getPrice()
	{
		return price;
	}


	public void setPrice(String price)
	{
		this.price = price;
	}


	public String getQty()
	{
		return qty;
	}


	public void setQty(String qty)
	{
		this.qty = qty;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "price", price )
				.append( "qty", qty ).toString();
	}
}
