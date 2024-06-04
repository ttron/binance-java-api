package com.binance.api.client;

import static com.binance.api.client.config.BinanceAPIConfig.getSpotBaseUrl;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.StringUtils;

import com.binance.api.client.exception.BinanceApiException;
import com.binance.api.client.security.AuthenticationInterceptor;
import com.binance.api.client.spot.BinanceApiError;

import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import retrofit2.Call;
import retrofit2.Converter;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Generates a Binance API implementation based on @see {@link BinanceSpotAPIService}.
 */
public class BinanceAPIServiceGenerator
{
	private static final Converter.Factory converterFactory = JacksonConverterFactory.create();

	@SuppressWarnings("unchecked")
	private static final Converter<ResponseBody, BinanceApiError> errorBodyConverter = (Converter<ResponseBody, BinanceApiError>) converterFactory
			.responseBodyConverter( BinanceApiError.class, new Annotation[0], null );

	private static final OkHttpClient sharedClient;

	static
	{
		// JUL to Log4j
		System.setProperty( "java.util.logging.manager", "org.apache.logging.log4j.jul.LogManager" );

		HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
		loggingInterceptor.redactHeader( "Authorization" );
		loggingInterceptor.redactHeader( "Cookie" );
		loggingInterceptor.setLevel( Level.BASIC );// set your desired log level

		Dispatcher dispatcher = new Dispatcher();
		dispatcher.setMaxRequestsPerHost( 500 );
		dispatcher.setMaxRequests( 500 );
		sharedClient = new OkHttpClient.Builder().addInterceptor( loggingInterceptor ).dispatcher( dispatcher )
				.pingInterval( 20, TimeUnit.SECONDS ).build();

		// sharedClient = new OkHttpClient.Builder().dispatcher( dispatcher ).pingInterval( 20,
		// TimeUnit.SECONDS ).build();
	}

	public static <S> S createService(Class<S> serviceClass)
	{
		return createService( serviceClass, getSpotBaseUrl(), null, null );
	}


	public static <S> S createService(Class<S> serviceClass, String apiKey, String secret)
	{
		return createService( serviceClass, getSpotBaseUrl(), apiKey, secret );
	}


	public static <S> S createService(Class<S> serviceClass, String uri, String apiKey, String secret)
	{
		Retrofit.Builder retrofitBuilder = new Retrofit.Builder().baseUrl( uri ).addConverterFactory( converterFactory );

		if (StringUtils.isEmpty( apiKey ) || StringUtils.isEmpty( secret ))
		{
			retrofitBuilder.client( sharedClient );
		}
		else
		{
			// `adaptedClient` will use its own interceptor, but share thread pool etc with the 'parent'
			// client
			AuthenticationInterceptor interceptor = new AuthenticationInterceptor( apiKey, secret );
			OkHttpClient adaptedClient = sharedClient.newBuilder().addInterceptor( interceptor ).build();
			retrofitBuilder.client( adaptedClient );
		}

		Retrofit retrofit = retrofitBuilder.build();
		return retrofit.create( serviceClass );
	}


	/**
	 * Execute a REST call and block until the response is received.
	 */
	public static <T> T executeSync(Call<T> call) throws BinanceApiException
	{
		try
		{
			Response<T> response = call.execute();
			if (response.isSuccessful())
			{
				return response.body();
			}
			else
			{
				BinanceApiError apiError = getBinanceApiError( response );
				throw new BinanceApiException( apiError );
			}
		}
		catch (IOException e)
		{
			throw new BinanceApiException( e );
		}
	}


	/**
	 * Extracts and converts the response error body into an object.
	 */
	public static BinanceApiError getBinanceApiError(Response<?> response) throws IOException, BinanceApiException
	{
		return errorBodyConverter.convert( response.errorBody() );
	}


	/**
	 * Returns the shared OkHttpClient instance.
	 */
	public static OkHttpClient getSharedClient()
	{
		return sharedClient;
	}
}
