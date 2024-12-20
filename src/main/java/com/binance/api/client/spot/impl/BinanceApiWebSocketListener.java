package com.binance.api.client.spot.impl;

import java.io.IOException;

import com.binance.api.client.exception.BinanceAPIException;
import com.binance.api.client.spot.BinanceAPICallback;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectReader;

import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;

/**
 * Binance API WebSocket listener.
 */
public class BinanceApiWebSocketListener<T> extends WebSocketListener
{
	private BinanceAPICallback<T> callback;

	private static final ObjectMapper mapper = new ObjectMapper();

	private final ObjectReader objectReader;

	private boolean closing = false;

	public BinanceApiWebSocketListener(BinanceAPICallback<T> callback, Class<T> eventClass)
	{
		this.callback = callback;
		this.objectReader = mapper.readerFor( eventClass );
	}


	public BinanceApiWebSocketListener(BinanceAPICallback<T> callback, TypeReference<T> eventTypeReference)
	{
		this.callback = callback;
		this.objectReader = mapper.readerFor( eventTypeReference );
	}


	@Override
	public void onMessage(WebSocket webSocket, String text)
	{
		try
		{
			T event = objectReader.readValue( text );
			callback.onResponse( event );
		}
		catch (IOException e)
		{
			throw new BinanceAPIException( e );
		}
	}


	@Override
	public void onClosing(final WebSocket webSocket, final int code, final String reason)
	{
		closing = true;
	}


	@Override
	public void onFailure(WebSocket webSocket, Throwable t, Response response)
	{
		if (!closing)
		{
			callback.onFailure( t );
		}
	}
}
