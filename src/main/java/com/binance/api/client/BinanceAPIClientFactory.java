package com.binance.api.client;

import static com.binance.api.client.BinanceAPIServiceGenerator.getSharedClient;

import com.binance.api.client.derivative.IBinanceFutureAPIRestClient;
import com.binance.api.client.derivative.impl.BinanceFutureAPIRestClientImpl;
import com.binance.api.client.spot.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.spot.BinanceApiMarginRestClient;
import com.binance.api.client.spot.BinanceApiSwapRestClient;
import com.binance.api.client.spot.BinanceApiWebSocketClient;
import com.binance.api.client.spot.IBinanceSpotAPIAsyncRestClient;
import com.binance.api.client.spot.IBinanceSpotAPIRestClient;
import com.binance.api.client.spot.impl.BinanceApiAsyncMarginRestClientImpl;
import com.binance.api.client.spot.impl.BinanceApiMarginRestClientImpl;
import com.binance.api.client.spot.impl.BinanceApiSwapRestClientImpl;
import com.binance.api.client.spot.impl.BinanceApiWebSocketClientImpl;
import com.binance.api.client.spot.impl.BinanceSpotAPIAsyncRestClientImpl;
import com.binance.api.client.spot.impl.BinanceSpotAPIRestClientImpl;

/**
 * A factory for creating BinanceApi client objects.
 */
public class BinanceAPIClientFactory
{
	/**
	 * API Key
	 */
	private final String apiKey;

	/**
	 * Secret.
	 */
	private final String secret;

	/**
	 * Instantiates a new binance api client factory.
	 *
	 * @param apiKey the API key
	 * @param secret the Secret
	 */
	private BinanceAPIClientFactory(String apiKey, String secret)
	{
		this.apiKey = apiKey;
		this.secret = secret;
	}


	/**
	 * New instance.
	 *
	 * @param apiKey the API key
	 * @param secret the Secret
	 *
	 * @return the binance api client factory
	 */
	public static BinanceAPIClientFactory newInstance(String apiKey, String secret)
	{
		return new BinanceAPIClientFactory( apiKey, secret );
	}


	/**
	 * New instance without authentication.
	 *
	 * @return the binance api client factory
	 */
	public static BinanceAPIClientFactory newInstance()
	{
		return new BinanceAPIClientFactory( null, null );
	}


	/**
	 * Creates a new synchronous/blocking REST client.
	 */
	public IBinanceSpotAPIRestClient newSpotRestClient()
	{
		return new BinanceSpotAPIRestClientImpl( apiKey, secret );
	}


	public IBinanceFutureAPIRestClient newFutureRestClient()
	{
		return new BinanceFutureAPIRestClientImpl( apiKey, secret );
	}


	/**
	 * Creates a new asynchronous/non-blocking REST client.
	 */
	public IBinanceSpotAPIAsyncRestClient newAsyncRestClient()
	{
		return new BinanceSpotAPIAsyncRestClientImpl( apiKey, secret );
	}


	/**
	 * Creates a new asynchronous/non-blocking Margin REST client.
	 */
	public BinanceApiAsyncMarginRestClient newAsyncMarginRestClient()
	{
		return new BinanceApiAsyncMarginRestClientImpl( apiKey, secret );
	}


	/**
	 * Creates a new synchronous/blocking Margin REST client.
	 */
	public BinanceApiMarginRestClient newMarginRestClient()
	{
		return new BinanceApiMarginRestClientImpl( apiKey, secret );
	}


	/**
	 * Creates a new web socket client used for handling data streams.
	 */
	public BinanceApiWebSocketClient newWebSocketClient()
	{
		return new BinanceApiWebSocketClientImpl( getSharedClient() );
	}


	/**
	 * Creates a new synchronous/blocking Swap REST client.
	 */
	public BinanceApiSwapRestClient newSwapRestClient()
	{
		return new BinanceApiSwapRestClientImpl( apiKey, secret );
	}
}
