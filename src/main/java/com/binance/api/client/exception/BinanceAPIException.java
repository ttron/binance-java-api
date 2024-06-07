package com.binance.api.client.exception;

import com.binance.api.client.spot.BinanceAPIError;

/**
 * An exception which can occur while invoking methods of the Binance API.
 */
public class BinanceAPIException extends RuntimeException
{
	private static final long serialVersionUID = 3788669840036201041L;

	/**
	   * Error response object returned by Binance API.
	   */
	private BinanceAPIError error;

	/**
	 * Instantiates a new binance api exception.
	 *
	 * @param error an error response object
	 */
	public BinanceAPIException(BinanceAPIError error)
	{
		this.error = error;
	}


	/**
	 * Instantiates a new binance api exception.
	 */
	public BinanceAPIException()
	{
		super();
	}


	/**
	 * Instantiates a new binance api exception.
	 *
	 * @param message the message
	 */
	public BinanceAPIException(String message)
	{
		super( message );
	}


	/**
	 * Instantiates a new binance api exception.
	 *
	 * @param cause the cause
	 */
	public BinanceAPIException(Throwable cause)
	{
		super( cause );
	}


	/**
	 * Instantiates a new binance api exception.
	 *
	 * @param message the message
	 * @param cause the cause
	 */
	public BinanceAPIException(String message, Throwable cause)
	{
		super( message, cause );
	}


	/**
	 * @return the response error object from Binance API, or null if no response object was returned (e.g. server returned 500).
	 */
	public BinanceAPIError getError()
	{
		return error;
	}


	@Override
	public String getMessage()
	{
		if (error != null)
		{
			return error.getMsg();
		}
		return super.getMessage();
	}
}
