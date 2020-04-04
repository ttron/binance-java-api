package com.binance.api.client.domain.market;

import static cn.ttron.stock.metadata.StockConstants.ID_TYPE_AKS_SELLING;
import static cn.ttron.stock.metadata.StockConstants.ID_TYPE_BID_BUYING;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Custom deserializer for an OrderBookEntry, since the API returns an array in the format [ price, qty, [] ].
 */
public class OrderBookEntryDeserializer extends JsonDeserializer<OrderBookEntry>
{
	@Override
	public OrderBookEntry deserialize(JsonParser jp, DeserializationContext ctx) throws IOException
	{
		ObjectCodec oc = jp.getCodec();
		// System.out.println( jp.getParsingContext().pathAsPointer() );
		// System.out.println( jp.getParsingContext().getParent().pathAsPointer() );
		String path = jp.getParsingContext().pathAsPointer().toString();
		JsonNode node = oc.readTree( jp );
		OrderBookEntry orderBookEntry = new OrderBookEntry();
		if (node != null)
		{
			orderBookEntry.setTimestamp( System.currentTimeMillis() );
			if (path.contains( "ask" ))
				orderBookEntry.setTypeId( ID_TYPE_AKS_SELLING );
			else
				orderBookEntry.setTypeId( ID_TYPE_BID_BUYING );
			final double price = node.get( 0 ).asDouble();
			final double quantity = node.get( 1 ).asDouble();
			orderBookEntry.setPrice( price );
			orderBookEntry.setVolume( quantity );
		}
		return orderBookEntry;
	}
}
