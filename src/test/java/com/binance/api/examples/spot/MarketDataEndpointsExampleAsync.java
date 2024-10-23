package com.binance.api.examples.spot;

import java.util.List;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.api.client.exception.BinanceAPIException;
import com.binance.api.client.spot.IBinanceSpotAPIAsyncRestClient;

/**
 * Examples on how to get market data information such as the latest price of a symbol, etc., in an async way.
 */
public class MarketDataEndpointsExampleAsync
{

	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance();
		IBinanceSpotAPIAsyncRestClient client = factory.newAsyncRestClient();

		// Getting depth of a symbol (async)
		client.getOrderBook( "NEOETH", 10, (OrderBook response) -> {
			System.out.println( response.getBids() );
		} );

		// Getting latest price of a symbol (async)
		client.get24HrPriceStatistics( "NEOETH", (TickerStatistics response) -> {
			System.out.println( response );
		} );

		// Getting all latest prices (async)
		client.getAllPrices( (List<TickerPrice> response) -> {
			System.out.println( response );
		} );

		// Getting agg trades (async)
		client.getAggTrades( "NEOETH", (List<AggTrade> response) -> System.out.println( response ) );

		// Weekly candlestick bars for a symbol
		client.getCandlestickBars( "NEOETH", CandlestickInterval.WEEKLY,
				(List<Candlestick> response) -> System.out.println( response ) );

		// Book tickers (async)
		client.getBookTickers( response -> System.out.println( response ) );

		// Exception handling
		try
		{
			client.getOrderBook( "UNKNOWN", 10, response -> System.out.println( response ) );
		}
		catch (BinanceAPIException e)
		{
			System.out.println( e.getError().getCode() ); // -1121
			System.out.println( e.getError().getMsg() ); // Invalid symbol
		}
	}
}
