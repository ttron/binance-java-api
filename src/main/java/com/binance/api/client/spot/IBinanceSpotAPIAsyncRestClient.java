package com.binance.api.client.spot;

import java.util.List;

import com.binance.api.client.domain.account.BinanceAccount;
import com.binance.api.client.domain.account.BinanceOrder;
import com.binance.api.client.domain.account.CancelOrderResponse;
import com.binance.api.client.domain.account.DepositAddress;
import com.binance.api.client.domain.account.DepositHistory;
import com.binance.api.client.domain.account.NewOrder;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.TradeHistoryItem;
import com.binance.api.client.domain.account.WithdrawHistory;
import com.binance.api.client.domain.account.WithdrawResult;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.domain.event.ListenKey;
import com.binance.api.client.domain.general.Asset;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;

/**
 * Binance API facade, supporting asynchronous/non-blocking access Binance's REST API.
 */
public interface IBinanceSpotAPIAsyncRestClient
{

	// General endpoints
	/**
	 * Test connectivity to the Rest API.
	 */
	void ping(BinanceAPICallback<Void> callback);


	/**
	 * Check server time.
	 */
	void getServerTime(BinanceAPICallback<ServerTime> callback);


	/**
	 * Current exchange trading rules and symbol information
	 */
	void getSpotExchangeInfo(BinanceAPICallback<ExchangeInfo> callback);


	/**
	 * ALL supported assets and whether or not they can be withdrawn.
	 */
	void getAllAssets(BinanceAPICallback<List<Asset>> callback);

	// Market Data endpoints


	/**
	 * Get order book of a symbol (asynchronous)
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 * @param limit depth of the order book (max 100)
	 * @param callback the callback that handles the response
	 */
	void getOrderBook(String symbol, Integer limit, BinanceAPICallback<OrderBook> callback);


	/**
	 * Get recent trades (up to last 500). Weight: 1
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 * @param limit of last trades (Default 500; max 1000.)
	 * @param callback the callback that handles the response
	 */
	void getTrades(String symbol, Integer limit, BinanceAPICallback<List<TradeHistoryItem>> callback);


	/**
	 * Get older trades. Weight: 5
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 * @param limit of last trades (Default 500; max 1000.)
	 * @param fromId TradeId to fetch from. Default gets most recent trades.
	 * @param callback the callback that handles the response
	 */
	void getHistoricalTrades(String symbol, Integer limit, Long fromId, BinanceAPICallback<List<TradeHistoryItem>> callback);


	/**
	 * Get compressed, aggregate trades. Trades that fill at the time, from the same order, with
	 * the same price will have the quantity aggregated.
	 *
	 * If both <code>startTime</code> and <code>endTime</code> are sent, <code>limit</code>should not
	 * be sent AND the distance between <code>startTime</code> and <code>endTime</code> must be less than 24 hours.
	 *
	 * @param symbol symbol to aggregate (mandatory)
	 * @param fromId ID to get aggregate trades from INCLUSIVE (optional)
	 * @param limit Default 500; max 1000 (optional)
	 * @param startTime Timestamp in ms to get aggregate trades from INCLUSIVE (optional).
	 * @param endTime Timestamp in ms to get aggregate trades until INCLUSIVE (optional).
	 * @param callback the callback that handles the response
	 * @return a list of aggregate trades for the given symbol
	 */
	void getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime,
			BinanceAPICallback<List<AggTrade>> callback);


	/**
	 * Return the most recent aggregate trades for <code>symbol</code>
	 *
	 * @see #getAggTrades(String, String, Integer, Long, Long, BinanceAPICallback)
	 */
	void getAggTrades(String symbol, BinanceAPICallback<List<AggTrade>> callback);


	/**
	 * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
	 *
	 * @param symbol symbol to aggregate (mandatory)
	 * @param interval candlestick interval (mandatory)
	 * @param limit Default 500; max 1000 (optional)
	 * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
	 * @param endTime Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
	 * @param callback the callback that handles the response containing a candlestick bar for the given symbol and interval
	 */
	void getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime,
			BinanceAPICallback<List<Candlestick>> callback);


	/**
	 * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
	 *
	 * @see #getCandlestickBars(String, CandlestickInterval, BinanceAPICallback)
	 */
	void getCandlestickBars(String symbol, CandlestickInterval interval, BinanceAPICallback<List<Candlestick>> callback);


	/**
	 * Get 24 hour price change statistics (asynchronous).
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 * @param callback the callback that handles the response
	 */
	void get24HrPriceStatistics(String symbol, BinanceAPICallback<TickerStatistics> callback);


	/**
	 * Get 24 hour price change statistics for all symbols (asynchronous).
	 * 
	 * @param callback the callback that handles the response
	 */
	void getAll24HrPriceStatistics(BinanceAPICallback<List<TickerStatistics>> callback);


	/**
	 * Get Latest price for all symbols (asynchronous).
	 *
	 * @param callback the callback that handles the response
	 */
	void getAllPrices(BinanceAPICallback<List<TickerPrice>> callback);


	/**
	 * Get latest price for <code>symbol</code> (asynchronous).
	 * 
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 * @param callback the callback that handles the response
	 */
	void getPrice(String symbol, BinanceAPICallback<TickerPrice> callback);


	/**
	 * Get best price/qty on the order book for all symbols (asynchronous).
	 *
	 * @param callback the callback that handles the response
	 */
	void getBookTickers(BinanceAPICallback<List<BookTicker>> callback);

	// Account endpoints


	/**
	 * Send in a new order (asynchronous)
	 *
	 * @param order the new order to submit.
	 * @param callback the callback that handles the response
	 */
	void newOrder(NewOrder order, BinanceAPICallback<NewOrderResponse> callback);


	/**
	 * Test new order creation and signature/recvWindow long. Creates and validates a new order but does not send it into the matching engine.
	 *
	 * @param order the new TEST order to submit.
	 * @param callback the callback that handles the response
	 */
	void newOrderTest(NewOrder order, BinanceAPICallback<Void> callback);


	/**
	 * Check an order's status (asynchronous).
	 *
	 * @param orderStatusRequest order status request parameters
	 * @param callback the callback that handles the response
	 */
	void getOrderStatus(OrderStatusRequest orderStatusRequest, BinanceAPICallback<BinanceOrder> callback);


	/**
	 * Cancel an active order (asynchronous).
	 *
	 * @param cancelOrderRequest order status request parameters
	 * @param callback the callback that handles the response
	 */
	void cancelOrder(CancelOrderRequest cancelOrderRequest, BinanceAPICallback<CancelOrderResponse> callback);


	/**
	 * Get all open orders on a symbol (asynchronous).
	 *
	 * @param orderRequest order request parameters
	 * @param callback the callback that handles the response
	 */
	void getOpenOrders(OrderRequest orderRequest, BinanceAPICallback<List<BinanceOrder>> callback);


	/**
	 * Get all account orders; active, canceled, or filled.
	 *
	 * @param orderRequest order request parameters
	 * @param callback the callback that handles the response
	 */
	void getAllOrders(AllOrdersRequest orderRequest, BinanceAPICallback<List<BinanceOrder>> callback);


	/**
	 * Get current account information (async).
	 */
	void getAccount(Long recvWindow, Long timestamp, BinanceAPICallback<BinanceAccount> callback);


	/**
	 * Get current account information using default parameters (async).
	 */
	void getAccount(BinanceAPICallback<BinanceAccount> callback);


	/**
	 * Get trades for a specific account and symbol.
	 *
	 * @param symbol symbol to get trades from
	 * @param limit default 500; max 1000
	 * @param fromId TradeId to fetch from. Default gets most recent trades.
	 * @param callback the callback that handles the response with a list of trades
	 */
	void getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp,
			BinanceAPICallback<List<Trade>> callback);


	/**
	 * Get trades for a specific account and symbol.
	 *
	 * @param symbol symbol to get trades from
	 * @param limit default 500; max 1000
	 * @param callback the callback that handles the response with a list of trades
	 */
	void getMyTrades(String symbol, Integer limit, BinanceAPICallback<List<Trade>> callback);


	/**
	 * Get trades for a specific account and symbol.
	 *
	 * @param symbol symbol to get trades from
	 * @param callback the callback that handles the response with a list of trades
	 */
	void getMyTrades(String symbol, BinanceAPICallback<List<Trade>> callback);


	/**
	 * Submit a withdraw request.
	 *
	 * Enable Withdrawals option has to be active in the API settings.
	 *
	 * @param asset asset symbol to withdraw
	 * @param address address to withdraw to
	 * @param amount amount to withdraw
	 * @param name description/alias of the address
	 * @param addressTag Secondary address identifier for coins like XRP,XMR etc.
	 */
	void withdraw(String asset, String address, String amount, String name, String addressTag,
			BinanceAPICallback<WithdrawResult> callback);


	/**
	 * Fetch account deposit history.
	 *
	 * @param callback the callback that handles the response and returns the deposit history
	 */
	void getDepositHistory(String asset, BinanceAPICallback<DepositHistory> callback);


	/**
	 * Fetch account withdraw history.
	 *
	 * @param callback the callback that handles the response and returns the withdraw history
	 */
	void getWithdrawHistory(String asset, BinanceAPICallback<WithdrawHistory> callback);


	/**
	 * Fetch deposit address.
	 *
	 * @param callback the callback that handles the response and returns the deposit address
	 */
	void getDepositAddress(String asset, BinanceAPICallback<DepositAddress> callback);

	// User stream endpoints


	/**
	 * Start a new user data stream.
	 *
	 * @param callback the callback that handles the response which contains a listenKey
	 */
	void startUserDataStream(BinanceAPICallback<ListenKey> callback);


	/**
	 * PING a user data stream to prevent a time out.
	 *
	 * @param listenKey listen key that identifies a data stream
	 * @param callback the callback that handles the response which contains a listenKey
	 */
	void keepAliveUserDataStream(String listenKey, BinanceAPICallback<Void> callback);


	/**
	 * Close out a new user data stream.
	 *
	 * @param listenKey listen key that identifies a data stream
	 * @param callback the callback that handles the response which contains a listenKey
	 */
	void closeUserDataStream(String listenKey, BinanceAPICallback<Void> callback);
}
