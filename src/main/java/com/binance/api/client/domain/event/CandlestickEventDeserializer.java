package com.binance.api.client.domain.event;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * Custom deserializer for a candlestick stream event, since the structure of the candlestick json differ from the one in the REST API.
 *
 * @see CandlestickEvent
 */
public class CandlestickEventDeserializer extends JsonDeserializer<CandlestickEvent>
{

	@Override
	public CandlestickEvent deserialize(JsonParser jp, DeserializationContext ctx) throws IOException
	{
		ObjectCodec oc = jp.getCodec();
		JsonNode node = oc.readTree( jp );

		CandlestickEvent candlestickEvent = new CandlestickEvent();

		// Parse header
		candlestickEvent.setEventType( node.get( "e" ).asText() );
		candlestickEvent.setEventTime( node.get( "E" ).asLong() );
		candlestickEvent.setSymbol( node.get( "s" ).asText() );

		// Parse candlestick data
		JsonNode candlestickNode = node.get( "k" );
		candlestickEvent.setOpenTime( candlestickNode.get( "t" ).asLong() );
		candlestickEvent.setCloseTime( candlestickNode.get( "T" ).asLong() );
		candlestickEvent.setIntervalId( candlestickNode.get( "i" ).asText() );
		candlestickEvent.setFirstTradeId( candlestickNode.get( "f" ).asLong() );
		candlestickEvent.setLastTradeId( candlestickNode.get( "L" ).asLong() );
		candlestickEvent.setOpen( candlestickNode.get( "o" ).asDouble() );
		candlestickEvent.setClose( candlestickNode.get( "c" ).asDouble() );
		candlestickEvent.setHigh( candlestickNode.get( "h" ).asDouble() );
		candlestickEvent.setLow( candlestickNode.get( "l" ).asDouble() );
		candlestickEvent.setVolume( candlestickNode.get( "v" ).asDouble() );
		candlestickEvent.setNumberOfTrades( candlestickNode.get( "n" ).asLong() );
		candlestickEvent.setBarFinal( candlestickNode.get( "x" ).asBoolean() );
		candlestickEvent.setQuoteAssetVolume( candlestickNode.get( "q" ).asDouble() );
		candlestickEvent.setTakerBuyBaseAssetVolume( candlestickNode.get( "V" ).asDouble() );
		candlestickEvent.setTakerBuyQuoteAssetVolume( candlestickNode.get( "Q" ).asDouble() );

		return candlestickEvent;
	}
}
