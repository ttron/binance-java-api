package com.binance.api.client.domain.market;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

/**
 * Custom serializer for an OrderBookEntry.
 */
public class OrderBookEntrySerializer extends JsonSerializer<OrderBookEntry>
{
	@Override
	public void serialize(OrderBookEntry orderBookEntry, JsonGenerator gen, SerializerProvider serializers) throws IOException
	{
		gen.writeStartArray();
		gen.writeNumber( orderBookEntry.getPrice() );
		gen.writeNumber( orderBookEntry.getVolume() );
		gen.writeEndArray();
	}
}
