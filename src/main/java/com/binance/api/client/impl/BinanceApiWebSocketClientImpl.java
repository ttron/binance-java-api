package com.binance.api.client.impl;

import java.io.Closeable;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.binance.api.client.BinanceApiCallback;
import com.binance.api.client.BinanceApiWebSocketClient;
import com.binance.api.client.constant.BinanceApiConstants;
import com.binance.api.client.domain.event.AggTradeEvent;
import com.binance.api.client.domain.event.MarketTickersEvent;
import com.binance.api.client.domain.event.CandlestickEvent;
import com.binance.api.client.domain.event.DepthEvent;
import com.binance.api.client.domain.event.TradeEvent;
import com.binance.api.client.domain.event.UserDataUpdateEvent;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.fasterxml.jackson.core.type.TypeReference;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.WebSocket;

/**
 * Binance API WebSocket client implementation using OkHttp.
 */
public class BinanceApiWebSocketClientImpl implements BinanceApiWebSocketClient, Closeable
{
	private final OkHttpClient client;


	public BinanceApiWebSocketClientImpl(OkHttpClient client)
	{
		this.client = client;
	}


	/**
	 * @deprecated This method is no longer functional. Please use the returned {@link Closeable} from any of the other methods to close the web socket.
	 */
	@Deprecated
	@Override
	public void close()
	{
	}


	private Closeable createNewWebSocket(String channel, BinanceApiWebSocketListener<?> listener)
	{
		String streamingUrl = String.format( "%s/%s", BinanceApiConstants.WS_API_BASE_URL, channel );
		Request request = new Request.Builder().url( streamingUrl ).build();
		final WebSocket webSocket = client.newWebSocket( request, listener );
		return () -> {
			final int code = 1000;
			listener.onClosing( webSocket, code, null );
			webSocket.close( code, null );
			listener.onClosed( webSocket, code, null );
		};
	}


	@Override
	public Closeable onAggTradeEvent(String symbols, BinanceApiCallback<AggTradeEvent> callback)
	{
		final String channel = Arrays.stream( symbols.split( "," ) ).map( String::trim )
				.map( s -> String.format( "%s@aggTrade", s ) ).collect( Collectors.joining( "/" ) );
		return createNewWebSocket( channel, new BinanceApiWebSocketListener<>( callback, AggTradeEvent.class ) );
	}


	@Override
	public Closeable onAllMarketTickersEvent(BinanceApiCallback<List<MarketTickersEvent>> callback)
	{
		final String channel = "!ticker@arr";
		return createNewWebSocket( channel,
				new BinanceApiWebSocketListener<>( callback, new TypeReference<List<MarketTickersEvent>>()
				{
				} ) );
	}


	@Override
	public Closeable onCandlestickEvent(String symbols, CandlestickInterval interval,
			BinanceApiCallback<CandlestickEvent> callback)
	{
		final String channel = Arrays.stream( symbols.split( "," ) ).map( String::trim )
				.map( s -> String.format( "%s@kline_%s", s, interval.getIntervalId() ) ).collect( Collectors.joining( "/" ) );
		return createNewWebSocket( channel, new BinanceApiWebSocketListener<>( callback, CandlestickEvent.class ) );
	}


	@Override
	public Closeable onDepthEvent(String symbols, BinanceApiCallback<DepthEvent> callback)
	{
		final String channel = Arrays.stream( symbols.split( "," ) ).map( String::trim )
				.map( s -> String.format( "%s@depth", s ) ).collect( Collectors.joining( "/" ) );
		return createNewWebSocket( channel, new BinanceApiWebSocketListener<>( callback, DepthEvent.class ) );
	}


	@Override
	public Closeable onSingleTickerEvent(String symbol, BinanceApiCallback<MarketTickersEvent> callback)
	{
		final String channel = symbol + "@ticker";
		return createNewWebSocket( channel, new BinanceApiWebSocketListener<>( callback, MarketTickersEvent.class ) );
	}


	/*
	 * (non-Javadoc)
	 * @see com.binance.api.client.BinanceApiWebSocketClient#onSingleTradeEvent(java.lang.String,
	 * com.binance.api.client.BinanceApiCallback)
	 */
	@Override
	public Closeable onSingleTradeEvent(String symbols, BinanceApiCallback<TradeEvent> callback)
	{
		final String channel = Arrays.stream( symbols.split( "," ) ).map( String::trim )
				.map( s -> String.format( "%s@trade", s ) ).collect( Collectors.joining( "/" ) );
		return createNewWebSocket( channel, new BinanceApiWebSocketListener<>( callback, TradeEvent.class ) );
	}


	@Override
	public Closeable onUserDataUpdateEvent(String listenKey, BinanceApiCallback<UserDataUpdateEvent> callback)
	{
		return createNewWebSocket( listenKey, new BinanceApiWebSocketListener<>( callback, UserDataUpdateEvent.class ) );
	}
}
