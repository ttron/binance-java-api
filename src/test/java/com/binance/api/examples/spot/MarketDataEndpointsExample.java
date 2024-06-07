package com.binance.api.examples.spot;

import java.util.List;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;
import com.binance.api.client.exception.BinanceAPIException;
import com.binance.api.client.spot.IBinanceSpotAPIRestClient;

/**
 * Examples on how to get market data information such as the latest price of a symbol, etc.
 */
public class MarketDataEndpointsExample
{

	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance();
		IBinanceSpotAPIRestClient client = factory.newSpotRestClient();

		// Getting depth of a symbol
		OrderBook orderBook = client.getOrderBook( "NEOETH", 10 );
		System.out.println( orderBook.getAsks() );

		// Getting latest price of a symbol
		TickerStatistics tickerStatistics = client.get24HPriceStatistics( "NEOETH" );
		System.out.println( tickerStatistics );

		// Getting all latest prices
		List<TickerPrice> allPrices = client.getAllPrices();
		System.out.println( allPrices );

		// Getting agg trades
		List<AggTrade> aggTrades = client.getAggTrades( "NEOETH" );
		System.out.println( aggTrades );

		// Weekly candlestick bars for a symbol
		List<Candlestick> candlesticks = client.getCandlestickBars( "NEOETH", CandlestickInterval.WEEKLY );
		System.out.println( candlesticks );

		// Getting all book tickers
		List<BookTicker> allBookTickers = client.getBookTickers();
		System.out.println( allBookTickers );

		// Exception handling
		try
		{
			client.getOrderBook( "UNKNOWN", 10 );
		}
		catch (BinanceAPIException e)
		{
			System.out.println( e.getError().getCode() ); // -1121
			System.out.println( e.getError().getMsg() ); // Invalid symbol
		}
	}
}
