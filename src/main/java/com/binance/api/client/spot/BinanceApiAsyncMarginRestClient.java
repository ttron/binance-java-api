package com.binance.api.client.spot;

import java.util.List;

import com.binance.api.client.domain.TransferType;
import com.binance.api.client.domain.account.BinanceOrder;
import com.binance.api.client.domain.account.CancelOrderResponse;
import com.binance.api.client.domain.account.MarginAccount;
import com.binance.api.client.domain.account.MarginNewOrder;
import com.binance.api.client.domain.account.MarginNewOrderResponse;
import com.binance.api.client.domain.account.MarginTransaction;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.domain.event.ListenKey;

/**
 * Binance API façade, supporting asynchronous/non-blocking access Binance's Margin REST API.
 */
public interface BinanceApiAsyncMarginRestClient
{
	// Account endpoints

	/**
	 * Get current margin account information (async).
	 */
	void getAccount(Long recvWindow, Long timestamp, BinanceAPICallback<MarginAccount> callback);


	/**
	 * Get current margin account information using default parameters (async).
	 */
	void getAccount(BinanceAPICallback<MarginAccount> callback);


	/**
	 * Get all open orders on margin account for a symbol (async).
	 *
	 * @param orderRequest order request parameters
	 * @param callback the callback that handles the response
	 */
	void getOpenOrders(OrderRequest orderRequest, BinanceAPICallback<List<BinanceOrder>> callback);


	/**
	 * Send in a new margin order (async).
	 *
	 * @param order the new order to submit.
	 * @return a response containing details about the newly placed order.
	 */
	void newOrder(MarginNewOrder order, BinanceAPICallback<MarginNewOrderResponse> callback);


	/**
	 * Cancel an active margin order (async).
	 *
	 * @param cancelOrderRequest order status request parameters
	 */
	void cancelOrder(CancelOrderRequest cancelOrderRequest, BinanceAPICallback<CancelOrderResponse> callback);


	/**
	 * Check margin order's status (async).
	 *
	 * @param orderStatusRequest order status request options/filters
	 * @return an order
	 */
	void getOrderStatus(OrderStatusRequest orderStatusRequest, BinanceAPICallback<BinanceOrder> callback);


	/**
	 * Get margin trades for a specific symbol (async).
	 *
	 * @param symbol symbol to get trades from
	 * @return a list of trades
	 */
	void getMyTrades(String symbol, BinanceAPICallback<List<Trade>> callback);

	// User stream endpoints


	/**
	 * Start a new user data stream (async).
	 *
	 * @return a listen key that can be used with data streams
	 */
	void startUserDataStream(BinanceAPICallback<ListenKey> callback);


	/**
	 * PING a user data stream to prevent a time out (async).
	 *
	 * @param listenKey listen key that identifies a data stream
	 */
	void keepAliveUserDataStream(String listenKey, BinanceAPICallback<Void> callback);


	/**
	 * Execute transfer between spot account and margin account
	 * @param asset asset to repay
	 * @param amount amount to repay
	 * @return transaction id
	 */
	void transfer(String asset, String amount, TransferType type, BinanceAPICallback<MarginTransaction> callback);


	/**
	 * Apply for a loan
	 * @param asset asset to repay
	 * @param amount amount to repay
	 * @return transaction id
	 */
	void borrow(String asset, String amount, BinanceAPICallback<MarginTransaction> callback);


	/**
	 * Repay loan for margin account
	 * @param asset asset to repay
	 * @param amount amount to repay
	 * @return transaction id
	 */
	void repay(String asset, String amount, BinanceAPICallback<MarginTransaction> callback);

}
