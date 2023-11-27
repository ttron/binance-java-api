package com.binance.api.client.domain.market;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

import xyz.tsst.billions.crypto.CYYOrder;

/**
 * An order book entry consisting of price and quantity.
 */
@JsonDeserialize(using = OrderBookEntryDeserializer.class)
@JsonSerialize(using = OrderBookEntrySerializer.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class BinanceOrder extends CYYOrder
{
	@Override
	public String toString()
	{
		// return new ToStringBuilder( this, BinanceApiConstants.TO_STRING_BUILDER_STYLE ).append( "millis",
		// getTimestamp() )
		// .append( "type", (getDirectionId() == ID_DIRECTION_AKS_SELLING) ? "ask/sell" : "bid/buy" ).append(
		// "price", getPrice() )
		// .append( "quantity", getAmount() ).toString();

		return "BinanceOrder [currencyPair=" + (getCurrencyPair() != null ? getCurrencyPair().getCode() : "null")
				+ ", orderNumber=" + getExchangeOrderId() + ", fee rate=" + getFeeRate()
				+ (getIdDirection() == 0 ? ", sell " : ", buy ") + getAmount() + " @ " + getPrice() + "]";
	}
}
