package com.binance.api.client.domain.market;

import static cn.ttron.stock.metadata.StockConstants.ID_TYPE_AKS_SELLING;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import cn.ttron.stock.metadata.Order;

/**
 * An order book entry consisting of price and quantity.
 */
@JsonDeserialize(using = OrderBookEntryDeserializer.class)
@JsonSerialize(using = OrderBookEntrySerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class OrderBookEntry extends Order
{

	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceApiConstants.TO_STRING_BUILDER_STYLE ).append( "millis", getTimestamp() )
				.append( "type", (getTypeId() == ID_TYPE_AKS_SELLING) ? "ask/sell" : "bid/buy" ).append( "price", getPrice() )
				.append( "quantity", getVolume() ).toString();
	}
}
