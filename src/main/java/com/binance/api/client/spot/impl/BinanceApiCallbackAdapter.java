package com.binance.api.client.spot.impl;

import static com.binance.api.client.BinanceAPIServiceGenerator.getBinanceAPIError;

import java.io.IOException;

import com.binance.api.client.exception.BinanceAPIException;
import com.binance.api.client.spot.BinanceAPICallback;
import com.binance.api.client.spot.BinanceAPIError;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * An adapter/wrapper which transforms a Callback from Retrofit into a BinanceApiCallback which is exposed to the client.
 */
public class BinanceApiCallbackAdapter<T> implements Callback<T>
{
	private final BinanceAPICallback<T> callback;

	public BinanceApiCallbackAdapter(BinanceAPICallback<T> callback)
	{
		this.callback = callback;
	}


	@Override
	public void onResponse(Call<T> call, Response<T> response)
	{
		if (response.isSuccessful())
		{
			callback.onResponse( response.body() );
		}
		else
		{
			if (response.code() == 504)
			{
				// HTTP 504 return code is used when the API successfully sent the message but not get a
				// response within the timeout period.
				// It is important to NOT treat this as a failure; the execution status is UNKNOWN and could
				// have been a success.
				return;
			}
			try
			{
				BinanceAPIError apiError = getBinanceAPIError( response );
				onFailure( call, new BinanceAPIException( apiError ) );
			}
			catch (IOException e)
			{
				onFailure( call, new BinanceAPIException( e ) );
			}
		}
	}


	@Override
	public void onFailure(Call<T> call, Throwable throwable)
	{
		if (throwable instanceof BinanceAPIException)
		{
			callback.onFailure( throwable );
		}
		else
		{
			callback.onFailure( new BinanceAPIException( throwable ) );
		}
	}
}
