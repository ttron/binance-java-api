package com.binance.api.client;

import java.util.List;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.CancelReplaceMode;
import com.binance.api.client.domain.OrderSide;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.SwapRemoveType;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.BinanceAccount;
import com.binance.api.client.domain.account.BinanceOrder;
import com.binance.api.client.domain.account.CancelOrderResponse;
import com.binance.api.client.domain.account.CancelReplaceOrderResponse;
import com.binance.api.client.domain.account.DepositAddress;
import com.binance.api.client.domain.account.DepositHistory;
import com.binance.api.client.domain.account.Liquidity;
import com.binance.api.client.domain.account.LiquidityOperationRecord;
import com.binance.api.client.domain.account.LoanQueryResult;
import com.binance.api.client.domain.account.MarginAccount;
import com.binance.api.client.domain.account.MarginNewOrderResponse;
import com.binance.api.client.domain.account.MarginTransaction;
import com.binance.api.client.domain.account.MaxBorrowableQueryResult;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.NewOrderResponseType;
import com.binance.api.client.domain.account.Pool;
import com.binance.api.client.domain.account.RepayQueryResult;
import com.binance.api.client.domain.account.SideEffectType;
import com.binance.api.client.domain.account.SubAccountTransfer;
import com.binance.api.client.domain.account.SwapHistory;
import com.binance.api.client.domain.account.SwapQuote;
import com.binance.api.client.domain.account.SwapRecord;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.TradeHistoryItem;
import com.binance.api.client.domain.account.WithdrawHistory;
import com.binance.api.client.domain.account.WithdrawResult;
import com.binance.api.client.domain.event.ListenKey;
import com.binance.api.client.domain.general.Asset;
import com.binance.api.client.domain.general.ExchangeInfo;
import com.binance.api.client.domain.general.ServerTime;
import com.binance.api.client.domain.market.AggTrade;
import com.binance.api.client.domain.market.BookTicker;
import com.binance.api.client.domain.market.Candlestick;
import com.binance.api.client.domain.market.OrderBook;
import com.binance.api.client.domain.market.TickerPrice;
import com.binance.api.client.domain.market.TickerStatistics;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Binance's REST API URL mappings and endpoint security configuration.
 */
public interface BinanceSpotAPIService
{

	// General endpoints
	@GET("/api/v3/ping")
	Call<Void> ping();


	@GET("/api/v3/time")
	Call<ServerTime> getServerTime();


	@GET("/api/v3/exchangeInfo")
	Call<ExchangeInfo> getExchangeInfo();


	@GET
	Call<List<Asset>> getAllAssets(@Url String url);


	// Market data endpoints
	@GET("/api/v3/depth")
	Call<OrderBook> getOrderBook(@Query("symbol") String symbol, @Query("limit") Integer limit);


	@GET("/api/v3/trades")
	Call<List<TradeHistoryItem>> getTrades(@Query("symbol") String symbol, @Query("limit") Integer limit);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
	@GET("/api/v3/historicalTrades")
	Call<List<TradeHistoryItem>> getHistoricalTrades(@Query("symbol") String symbol, @Query("limit") Integer limit,
			@Query("fromId") Long fromId);


	@GET("/api/v3/aggTrades")
	Call<List<AggTrade>> getAggTrades(@Query("symbol") String symbol, @Query("fromId") String fromId,
			@Query("limit") Integer limit, @Query("startTime") Long startTime, @Query("endTime") Long endTime);


	@GET("/api/v3/klines")
	Call<List<Candlestick>> getCandlestickBars(@Query("symbol") String symbol, @Query("interval") String interval,
			@Query("limit") Integer limit, @Query("startTime") Long startTime, @Query("endTime") Long endTime);


	@GET("/api/v3/ticker/24hr")
	Call<List<TickerStatistics>> getAll24HrPriceStatistics();


	@GET("/api/v3/ticker/24hr")
	Call<TickerStatistics> get24HrPriceStatistics(@Query("symbol") String symbol);


	@GET("/api/v3/ticker/tradingDay")
	Call<TickerStatistics> getTradingDayPriceStatistics(@Query("symbol") String symbol);


	@GET("/api/v3/ticker/tradingDay")
	Call<List<TickerStatistics>> getAllTradingDayPriceStatistics();


	@GET("/api/v1/ticker/allPrices")
	Call<List<TickerPrice>> getLatestPrices();


	@GET("/api/v3/ticker/price")
	Call<TickerPrice> getLatestPrice(@Query("symbol") String symbol);


	@GET("/api/v1/ticker/allBookTickers")
	Call<List<BookTicker>> getBookTickers();


	// Account endpoints
	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/api/v3/order/cancelReplace")
	Call<CancelReplaceOrderResponse> cancelReplace(@Query("symbol") String symbol, @Query("side") OrderSide side,
			@Query("type") OrderType type, @Query("cancelReplaceMode") CancelReplaceMode mode,
			@Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
			@Query("cancelOrderId") Long cancelOrderId, @Query("cancelOrigClientOrderId") String cancelOrigClientOrderId,
			@Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
			@Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/api/v3/order")
	Call<NewOrderResponse> newOrder(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
			@Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity, @Query("price") String price,
			@Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
			@Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/api/v3/order")
	Call<NewOrderResponse> newOrderQuoteQty(@Query("symbol") String symbol, @Query("side") OrderSide side,
			@Query("type") OrderType type, @Query("timeInForce") TimeInForce timeInForce,
			@Query("quoteOrderQty") String quoteOrderQty, @Query("price") String price,
			@Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
			@Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	/**
	 * Send in an one-cancels-the-other (OCO) pair, where activation of one order immediately cancels the other.
	 * An OCO has 2 orders called the above order and below order.
	 * One of the orders must be a LIMIT_MAKER order and the other must be STOP_LOSS or STOP_LOSS_LIMIT order.
	 * Price restrictions:
	 * If the OCO is on the SELL side: LIMIT_MAKER price > Last Traded Price > stopPrice
	 * If the OCO is on the BUY side: LIMIT_MAKER price < Last Traded Price < stopPrice
	 * OCOs add 2 orders to the unfilled order count, EXCHANGE_MAX_ORDERS filter, and the MAX_NUM_ORDERS filter.
	 * @return
	 */
	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/api/v3/orderList/oco")
	Call<NewOrderResponse> newOrderOneCancelstheOther(@Query("symbol") String symbol, @Query("side") OrderSide side,
			@Query("quantity") String quantity, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	/**
	 * 
	 * @param symbol
	 * @param side
	 * @param quantity
	 * @param recvWindow
	 * @param timestamp
	 * @return
	 */
	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/api/v3/orderList/oto")
	Call<NewOrderResponse> newOrderOneTriggerstheOther(@Query("symbol") String symbol, @Query("side") OrderSide side,
			@Query("quantity") String quantity, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	/**
	 * @param symbol
	 * @param side
	 * @param quantity
	 * @param recvWindow
	 * @param timestamp
	 * @return
	 */
	@POST("/api/v3/orderList/otoco")
	Call<NewOrderResponse> newOrderOneTriggersOneCancelstheOther(@Query("symbol") String symbol, @Query("side") OrderSide side,
			@Query("quantity") String quantity, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/api/v3/order/test")
	Call<Void> newOrderTest(@Query("symbol") String symbol, @Query("side") OrderSide side, @Query("type") OrderType type,
			@Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity,
			@Query("quoteOrderQty") String quoteOrderQty, @Query("price") String price,
			@Query("newClientOrderId") String newClientOrderId, @Query("stopPrice") String stopPrice,
			@Query("icebergQty") String icebergQty, @Query("newOrderRespType") NewOrderResponseType newOrderRespType,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/api/v3/order")
	Call<BinanceOrder> getOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
			@Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@DELETE("/api/v3/openOrders")
	Call<List<CancelOrderResponse>> cancelAllOrder(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@DELETE("/api/v3/order")
	Call<CancelOrderResponse> cancelOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
			@Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/api/v3/openOrders")
	Call<List<BinanceOrder>> getOpenOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/api/v3/allOrders")
	Call<List<BinanceOrder>> getAllOrders(@Query("symbol") String symbol, @Query("orderId") Long orderId,
			@Query("limit") Integer limit, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/api/v3/account")
	Call<BinanceAccount> getAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/api/v3/myTrades")
	Call<List<Trade>> getMyTrades(@Query("symbol") String symbol, @Query("limit") Integer limit, @Query("fromId") Long fromId,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/wapi/v3/withdraw.html")
	Call<WithdrawResult> withdraw(@Query("asset") String asset, @Query("address") String address, @Query("amount") String amount,
			@Query("name") String name, @Query("addressTag") String addressTag, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/wapi/v3/depositHistory.html")
	Call<DepositHistory> getDepositHistory(@Query("asset") String asset, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/wapi/v3/withdrawHistory.html")
	Call<WithdrawHistory> getWithdrawHistory(@Query("asset") String asset, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/wapi/v3/depositAddress.html")
	Call<DepositAddress> getDepositAddress(@Query("asset") String asset, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/sub-account/transfer/subUserHistory")
	Call<List<SubAccountTransfer>> getSubAccountTransfers(@Query("timestamp") Long timestamp);

	// User stream endpoints


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
	@POST("/api/v1/userDataStream")
	Call<ListenKey> startUserDataStream();


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
	@PUT("/api/v1/userDataStream")
	Call<Void> keepAliveUserDataStream(@Query("listenKey") String listenKey);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
	@DELETE("/api/v1/userDataStream")
	Call<Void> closeAliveUserDataStream(@Query("listenKey") String listenKey);


	// Margin Account endpoints
	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@POST("/sapi/v1/margin/transfer")
	Call<MarginTransaction> transfer(@Query("asset") String asset, @Query("amount") String amount, @Query("type") String type,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@POST("/sapi/v1/margin/loan")
	Call<MarginTransaction> borrow(@Query("asset") String asset, @Query("amount") String amount,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/margin/loan")
	Call<LoanQueryResult> queryLoan(@Query("asset") String asset, @Query("txId") String txId, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/margin/repay")
	Call<RepayQueryResult> queryRepay(@Query("asset") String asset, @Query("txId") String txId,
			@Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/margin/maxBorrowable")
	Call<MaxBorrowableQueryResult> queryMaxBorrowable(@Query("asset") String asset, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/margin/repay")
	Call<RepayQueryResult> queryRepay(@Query("asset") String asset, @Query("startTime") Long starttime,
			@Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@POST("/sapi/v1/margin/repay")
	Call<MarginTransaction> repay(@Query("asset") String asset, @Query("amount") String amount,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/margin/account")
	Call<MarginAccount> getMarginAccount(@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/margin/openOrders")
	Call<List<BinanceOrder>> getOpenMarginOrders(@Query("symbol") String symbol, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@POST("/sapi/v1/margin/order")
	Call<MarginNewOrderResponse> newMarginOrder(@Query("symbol") String symbol, @Query("side") OrderSide side,
			@Query("type") OrderType type, @Query("timeInForce") TimeInForce timeInForce, @Query("quantity") String quantity,
			@Query("price") String price, @Query("newClientOrderId") String newClientOrderId,
			@Query("stopPrice") String stopPrice, @Query("icebergQty") String icebergQty,
			@Query("newOrderRespType") NewOrderResponseType newOrderRespType,
			@Query("sideEffectType") SideEffectType sideEffectType, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@DELETE("/sapi/v1/margin/order")
	Call<CancelOrderResponse> cancelMarginOrder(@Query("symbol") String symbol, @Query("orderId") Long orderId,
			@Query("origClientOrderId") String origClientOrderId, @Query("newClientOrderId") String newClientOrderId,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/margin/order")
	Call<BinanceOrder> getMarginOrderStatus(@Query("symbol") String symbol, @Query("orderId") Long orderId,
			@Query("origClientOrderId") String origClientOrderId, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER)
	@GET("/sapi/v1/margin/myTrades")
	Call<List<Trade>> getMyMarginTrades(@Query("symbol") String symbol, @Query("limit") Integer limit,
			@Query("fromId") Long fromId, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
	@POST("/sapi/v1/userDataStream")
	Call<ListenKey> startMarginUserDataStream();


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
	@PUT("/sapi/v1/userDataStream")
	Call<Void> keepAliveMarginUserDataStream(@Query("listenKey") String listenKey);

	// Binance Liquidity Swap Pool endpoints


	@Headers(BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER)
	@GET("/sapi/v1/bswap/pools")
	Call<List<Pool>> listAllSwapPools();


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/bswap/liquidity")
	Call<List<Liquidity>> getPoolLiquidityInfo(@Query("poolId") String poolId, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@POST("/sapi/v1/bswap/liquidityAdd")
	Call<LiquidityOperationRecord> addLiquidity(@Query("poolId") String poolId, @Query("asset") String asset,
			@Query("quantity") String quantity, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@POST("/sapi/v1/bswap/liquidityRemove")
	Call<LiquidityOperationRecord> removeLiquidity(@Query("poolId") String poolId, @Query("type") SwapRemoveType type,
			@Query("asset") List<String> asset, @Query("shareAmount") String shareAmount, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/bswap/liquidityOps")
	Call<List<LiquidityOperationRecord>> getPoolLiquidityOperationRecords(@Query("poolId") String poolId,
			@Query("limit") Integer limit, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/bswap/liquidityOps")
	Call<List<LiquidityOperationRecord>> getLiquidityOperationRecord(@Query("operationId") String operationId,
			@Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/bswap/quote")
	Call<SwapQuote> requestQuote(@Query("quoteAsset") String quoteAsset, @Query("baseAsset") String baseAsset,
			@Query("quoteQty") String quoteQty, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@POST("/sapi/v1/bswap/swap")
	Call<SwapRecord> swap(@Query("quoteAsset") String quoteAsset, @Query("baseAsset") String baseAsset,
			@Query("quoteQty") String quoteQty, @Query("recvWindow") Long recvWindow, @Query("timestamp") Long timestamp);


	@Headers({ BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_APIKEY_HEADER,
			BinanceAPIConstants.ENDPOINT_SECURITY_TYPE_SIGNED_HEADER })
	@GET("/sapi/v1/bswap/swap")
	Call<List<SwapHistory>> getSwapHistory(@Query("swapId") String swapId, @Query("recvWindow") Long recvWindow,
			@Query("timestamp") Long timestamp);

}
