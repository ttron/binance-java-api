package com.binance.api.client.config;

/**
 * Configuration used for Binance operations.
 */
public class BinanceAPIConfig
{
	/**
	 * Base domain for URLs.
	 */
	private static String BASE_DOMAIN = "binance.com";

	/**
	 * Asset info base URL.
	 */
	public static String getAssetInfoApiBaseUrl()
	{
		return String.format( "https://%s/", getBaseDomain() );
	}


	/**
	 * Get the URL base domain name (e.g., binance.com).
	 *
	 * @return The base domain for URLs
	 */
	public static String getBaseDomain()
	{
		return BASE_DOMAIN;
	}


	/**
	 * Future REST API base URL.
	 */
	public static String getFutureBaseUrl()
	{
		return String.format( "https://fapi.%s", getBaseDomain() );
	}


	/**
	 * Spot REST API base URL.
	 */
	public static String getSpotBaseUrl()
	{
		return String.format( "https://api.%s", getBaseDomain() );
	}


	/**
	 * Streaming API base URL.
	 */
	public static String getStreamApiBaseUrl()
	{
		return String.format( "wss://stream.%s:9443/ws", getBaseDomain() );
	}


	/**
	 * Testnet Spot REST API base URL.
	 */
	public static String getTestnetSpotBaseUrl()
	{
		return "https://testnet.binance.vision";
	}


	/**
	 * Set the URL base domain name (e.g., binance.com).
	 *
	 * @param baseDomain Base domain name
	 */
	public static void setBaseDomain(final String baseDomain)
	{
		BASE_DOMAIN = baseDomain;
	}
}
