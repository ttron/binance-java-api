package com.binance.api.client.spot;

import java.util.List;

import com.binance.api.client.domain.account.BinanceAccount;
import com.binance.api.client.domain.account.BinanceOrder;
import com.binance.api.client.domain.account.CancelOrderResponse;
import com.binance.api.client.domain.account.CancelReplaceOrderResponse;
import com.binance.api.client.domain.account.DepositAddress;
import com.binance.api.client.domain.account.DepositHistory;
import com.binance.api.client.domain.account.NewNewOrder;
import com.binance.api.client.domain.account.NewOrder;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.SubAccountTransfer;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.TradeHistoryItem;
import com.binance.api.client.domain.account.WithdrawHistory;
import com.binance.api.client.domain.account.WithdrawResult;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.domain.general.Asset;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.CandlestickInterval;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;

/**
 * Binance API facade, supporting synchronous/blocking access Binance's REST API.
 */
public interface IBinanceSpotAPIRestClient
{
	// General endpoints
	List<CancelOrderResponse> cancelAllOrder(String symbol);


	/**
	 * Cancel an active order.
	 *
	 * @param cancelOrderRequest order status request parameters
	 */
	CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest);


	CancelReplaceOrderResponse cancelReplace(NewNewOrder order);


	/**
	 * Close out a new user data stream.
	 *
	 * @param listenKey listen key that identifies a data stream
	 */
	void closeUserDataStream(String listenKey);


	/**
	 * Get 24 hour price change statistics for all symbols.
	 */
	List<TickerStatistics> get24HAllPriceStatistics();


	/**
	 * Get 24 hour price change statistics.
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 */
	TickerStatistics get24HPriceStatistics(String symbol);


	/**
	 * Get current account information using default parameters.
	 */
	BinanceAccount getAccount();


	/**
	 * Get current account information.
	 */
	BinanceAccount getAccount(Long recvWindow, Long timestamp);


	/**
	 * Return the most recent aggregate trades for <code>symbol</code>
	 *
	 * @see #getAggTrades(String, String, Integer, Long, Long)
	 */
	List<AggTrade> getAggTrades(String symbol);


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
	 * @return a list of aggregate trades for the given symbol
	 */
	List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime);


	/**
	 * @return All the supported assets and whether or not they can be withdrawn.
	 */
	List<Asset> getAllAssets();


	/**
	 * Get all account orders; active, canceled, or filled.
	 *
	 * @param orderRequest order request parameters
	 * @return a list of all account orders
	 */
	List<BinanceOrder> getAllOrders(AllOrdersRequest orderRequest);


	/**
	 * Get Latest price for all symbols.
	 */
	List<TickerPrice> getAllPrices();


	List<TickerStatistics> getAllTradingDayPriceStatistics();


	/**
	 * Get best price/qty on the order book for all symbols.
	 */
	List<BookTicker> getBookTickers();


	/**
	 * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
	 *
	 * @see #getCandlestickBars(String, CandlestickInterval, Integer, Long, Long)
	 */
	List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval);


	/**
	 * Kline/candlestick bars for a symbol. Klines are uniquely identified by their open time.
	 *
	 * @param symbol symbol to aggregate (mandatory)
	 * @param interval candlestick interval (mandatory)
	 * @param limit Default 500; max 1000 (optional)
	 * @param startTime Timestamp in ms to get candlestick bars from INCLUSIVE (optional).
	 * @param endTime Timestamp in ms to get candlestick bars until INCLUSIVE (optional).
	 * @return a candlestick bar for the given symbol and interval
	 */
	List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime,
			Long endTime);


	/**
	 * Fetch deposit address.
	 *
	 * @return deposit address for a given asset.
	 */
	DepositAddress getDepositAddress(String asset);


	/**
	 * Fetch account deposit history.
	 *
	 * @return deposit history, containing a list of deposits
	 */
	DepositHistory getDepositHistory(String asset);

	// Account endpoints


	/**
	 * @return Current exchange trading rules and symbol information
	 */
	ExchangeInfo getExchangeInfo();


	/**
	 * Get older trades. Weight: 5
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 * @param limit of last trades (Default 500; max 1000.)
	 * @param fromId TradeId to fetch from. Default gets most recent trades.
	 */
	List<TradeHistoryItem> getHistoricalTrades(String symbol, Integer limit, Long fromId);


	/**
	 * Get trades for a specific account and symbol.
	 *
	 * @param symbol symbol to get trades from
	 * @return a list of trades
	 */
	List<Trade> getMyTrades(String symbol);


	/**
	 * Get trades for a specific account and symbol.
	 *
	 * @param symbol symbol to get trades from
	 * @param limit default 500; max 1000
	 * @return a list of trades
	 */
	List<Trade> getMyTrades(String symbol, Integer limit);


	/**
	 * Get trades for a specific account and symbol.
	 *
	 * @param symbol symbol to get trades from
	 * @param limit default 500; max 1000
	 * @param fromId TradeId to fetch from. Default gets most recent trades.
	 * @return a list of trades
	 */
	List<Trade> getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp);


	List<Trade> getMyTrades(String symbol, Long fromId);


	/**
	 * Get all open orders on a symbol.
	 *
	 * @param orderRequest order request parameters
	 * @return a list of all account open orders on a symbol.
	 */
	List<BinanceOrder> getOpenOrders(OrderRequest orderRequest);


	/**
	 * Get order book of a symbol.
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 * @param limit depth of the order book (max 100)
	 */
	OrderBook getOrderBook(String symbol, Integer limit);


	/**
	 * Check an order's status.
	 * @param orderStatusRequest order status request options/filters
	 *
	 * @return an order
	 */
	BinanceOrder getOrderStatus(OrderStatusRequest orderStatusRequest);


	/**
	 * Get latest price for <code>symbol</code>.
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 */
	TickerPrice getPrice(String symbol);


	/**
	 * Test connectivity to the Rest API and get the current server time.
	 *
	 * @return current server time.
	 */
	Long getServerTime();


	/**
	 * Fetch sub-account transfer history.
	 *
	 * @return sub-account transfers
	 */
	List<SubAccountTransfer> getSubAccountTransfers();


	/**
	 * Get recent trades (up to last 500). Weight: 1
	 *
	 * @param symbol ticker symbol (e.g. ETHBTC)
	 * @param limit of last trades (Default 500; max 1000.)
	 */
	List<TradeHistoryItem> getTrades(String symbol, Integer limit);


	TickerStatistics getTradingDayPriceStatistics(String symbol);
	// Market Data endpoints


	/**
	 * Fetch account withdraw history.
	 *
	 * @return withdraw history, containing a list of withdrawals
	 */
	WithdrawHistory getWithdrawHistory(String asset);


	/**
	 * PING a user data stream to prevent a time out.
	 *
	 * @param listenKey listen key that identifies a data stream
	 */
	void keepAliveUserDataStream(String listenKey);


	/**
	 * Send in a new order.
	 *
	 * @param order the new order to submit.
	 * @return a response containing details about the newly placed order.
	 */
	NewOrderResponse newOrder(NewOrder order);


	/**
	 * Test new order creation and signature/recvWindow long. Creates and validates a new order but does not send it into the matching engine.
	 *
	 * @param order the new TEST order to submit.
	 */
	void newOrderTest(NewOrder order);

	// User stream endpoints


	/**
	 * Test connectivity to the Rest API.
	 */
	void ping();


	/**
	 * Start a new user data stream.
	 *
	 * @return a listen key that can be used with data streams
	 */
	String startUserDataStream();


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
	WithdrawResult withdraw(String asset, String address, String amount, String name, String addressTag);
}
