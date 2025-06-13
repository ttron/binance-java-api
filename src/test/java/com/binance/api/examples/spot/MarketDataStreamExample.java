package com.binance.api.examples.spot;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.spot.IBinanceAPIWebSocketClient;

import java.io.IOException;

/**
 * Market data stream endpoints examples.
 *
 * It illustrates how to create a stream to obtain updates on market data such as executed trades.
 */
public class MarketDataStreamExample {

  public static void main(String[] args) throws InterruptedException, IOException {
    IBinanceAPIWebSocketClient client = BinanceAPIClientFactory.newInstance().newWebSocketClient();

    // Listen for aggregated trade events for ETH/BTC
    client.onAggTradeEvent("ethbtc", response -> System.out.println(response));

    // Listen for changes in the order book in ETH/BTC
    client.onDepthEvent("ethbtc", response -> System.out.println(response));

    // Obtain 1m candlesticks in real-time for ETH/BTC
    client.onCandlestickEvent("ethbtc", CandlestickInterval.ONE_MINUTE, response -> System.out.println(response));
  }
}
