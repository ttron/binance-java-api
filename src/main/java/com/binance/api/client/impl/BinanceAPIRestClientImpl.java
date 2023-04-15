package com.binance.api.client.impl;

import static com.binance.api.client.impl.BinanceAPIServiceGenerator.createService;
import static com.binance.api.client.impl.BinanceAPIServiceGenerator.executeSync;

import java.util.List;

import com.binance.api.client.IBinanceAPIRestClient;
import com.binance.api.client.config.BinanceApiConfig;
import com.binance.api.client.constant.BinanceAPIConstants;
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

import retrofit2.Call;

/**
 * Implementation of Binance's REST API using Retrofit with synchronous/blocking
 * method calls.
 */
public class BinanceAPIRestClientImpl implements IBinanceAPIRestClient
{
	private final BinanceAPIService binanceAPIService;

	public BinanceAPIRestClientImpl(String apiKey, String secret)
	{
		binanceAPIService = createService( BinanceAPIService.class, apiKey, secret );
	}

	// General endpoints


	@Override
	public List<CancelOrderResponse> cancelAllOrder(String symbol)
	{
		return executeSync( binanceAPIService.cancelAllOrder( symbol, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW,
				System.currentTimeMillis() ) );
	}


	@Override
	public CancelOrderResponse cancelOrder(CancelOrderRequest request)
	{
		return executeSync(
				binanceAPIService.cancelOrder( request.getSymbol(), request.getOrderId(), request.getOrigClientOrderId(),
						request.getNewClientOrderId(), request.getRecvWindow(), request.getTimestamp() ) );
	}


	@Override
	public void closeUserDataStream(String listenKey)
	{
		executeSync( binanceAPIService.closeAliveUserDataStream( listenKey ) );
	}


	@Override
	public TickerStatistics get24HrPriceStatistics(String symbol)
	{
		return executeSync( binanceAPIService.get24HrPriceStatistics( symbol ) );
	}

	// Market Data endpoints


	@Override
	public BinanceAccount getAccount()
	{
		return getAccount( BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() );
	}


	@Override
	public BinanceAccount getAccount(Long recvWindow, Long timestamp)
	{
		return executeSync( binanceAPIService.getAccount( recvWindow, timestamp ) );
	}


	@Override
	public List<AggTrade> getAggTrades(String symbol)
	{
		return getAggTrades( symbol, null, null, null, null );
	}


	@Override
	public List<AggTrade> getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime)
	{
		return executeSync( binanceAPIService.getAggTrades( symbol, fromId, limit, startTime, endTime ) );
	}


	@Override
	public List<TickerStatistics> getAll24HrPriceStatistics()
	{
		return executeSync( binanceAPIService.getAll24HrPriceStatistics() );
	}


	@Override
	public List<Asset> getAllAssets()
	{
		return executeSync(
				binanceAPIService.getAllAssets( BinanceApiConfig.getAssetInfoApiBaseUrl() + "assetWithdraw/getAllAsset.html" ) );
	}


	@Override
	public List<BinanceOrder> getAllOrders(AllOrdersRequest orderRequest)
	{
		return executeSync( binanceAPIService.getAllOrders( orderRequest.getSymbol(), orderRequest.getOrderId(),
				orderRequest.getLimit(), orderRequest.getRecvWindow(), orderRequest.getTimestamp() ) );
	}


	@Override
	public List<TickerPrice> getAllPrices()
	{
		return executeSync( binanceAPIService.getLatestPrices() );
	}


	@Override
	public List<BookTicker> getBookTickers()
	{
		return executeSync( binanceAPIService.getBookTickers() );
	}


	@Override
	public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval)
	{
		return getCandlestickBars( symbol, interval, null, null, null );
	}


	@Override
	public List<Candlestick> getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime,
			Long endTime)
	{
		return executeSync( binanceAPIService.getCandlestickBars( symbol, interval.getIntervalId(), limit, startTime, endTime ) );
	}


	@Override
	public DepositAddress getDepositAddress(String asset)
	{
		return executeSync( binanceAPIService.getDepositAddress( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW,
				System.currentTimeMillis() ) );
	}


	@Override
	public DepositHistory getDepositHistory(String asset)
	{
		return executeSync( binanceAPIService.getDepositHistory( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW,
				System.currentTimeMillis() ) );
	}


	@Override
	public ExchangeInfo getExchangeInfo()
	{
		return executeSync( binanceAPIService.getExchangeInfo() );
	}

	// Account endpoints


	@Override
	public List<TradeHistoryItem> getHistoricalTrades(String symbol, Integer limit, Long fromId)
	{
		return executeSync( binanceAPIService.getHistoricalTrades( symbol, limit, fromId ) );
	}


	@Override
	public List<Trade> getMyTrades(String symbol)
	{
		return getMyTrades( symbol, null, null, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() );
	}


	@Override
	public List<Trade> getMyTrades(String symbol, Integer limit)
	{
		return getMyTrades( symbol, limit, null, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() );
	}


	@Override
	public List<Trade> getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp)
	{
		return executeSync( binanceAPIService.getMyTrades( symbol, limit, fromId, recvWindow, timestamp ) );
	}


	@Override
	public List<Trade> getMyTrades(String symbol, Long fromId)
	{
		return getMyTrades( symbol, null, fromId, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() );
	}


	@Override
	public List<BinanceOrder> getOpenOrders(OrderRequest orderRequest)
	{
		return executeSync( binanceAPIService.getOpenOrders( orderRequest.getSymbol(), orderRequest.getRecvWindow(),
				orderRequest.getTimestamp() ) );
	}


	@Override
	public OrderBook getOrderBook(String symbol, Integer limit)
	{
		return executeSync( binanceAPIService.getOrderBook( symbol, limit ) );
	}


	@Override
	public BinanceOrder getOrderStatus(OrderStatusRequest orderStatusRequest)
	{
		return executeSync( binanceAPIService.getOrderStatus( orderStatusRequest.getSymbol(), orderStatusRequest.getOrderId(),
				orderStatusRequest.getOrigClientOrderId(), orderStatusRequest.getRecvWindow(),
				orderStatusRequest.getTimestamp() ) );
	}


	@Override
	public TickerPrice getPrice(String symbol)
	{
		return executeSync( binanceAPIService.getLatestPrice( symbol ) );
	}


	@Override
	public Long getServerTime()
	{
		return executeSync( binanceAPIService.getServerTime() ).getServerTime();
	}


	@Override
	public List<SubAccountTransfer> getSubAccountTransfers()
	{
		return executeSync( binanceAPIService.getSubAccountTransfers( System.currentTimeMillis() ) );
	}


	@Override
	public List<TradeHistoryItem> getTrades(String symbol, Integer limit)
	{
		return executeSync( binanceAPIService.getTrades( symbol, limit ) );
	}


	@Override
	public WithdrawHistory getWithdrawHistory(String asset)
	{
		return executeSync( binanceAPIService.getWithdrawHistory( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW,
				System.currentTimeMillis() ) );
	}


	@Override
	public void keepAliveUserDataStream(String listenKey)
	{
		executeSync( binanceAPIService.keepAliveUserDataStream( listenKey ) );
	}


	@Override
	public NewOrderResponse newOrder(NewOrder order)
	{
		final Call<NewOrderResponse> call;
		if (order.getQuoteOrderQty() == null)
		{
			call = binanceAPIService.newOrder( order.getSymbol(), order.getSide(), order.getType(), order.getTimeInForce(),
					order.getQuantity(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
					order.getIcebergQty(), order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp() );
		}
		else
		{
			call = binanceAPIService.newOrderQuoteQty( order.getSymbol(), order.getSide(), order.getType(),
					order.getTimeInForce(), order.getQuoteOrderQty(), order.getPrice(), order.getNewClientOrderId(),
					order.getStopPrice(), order.getIcebergQty(), order.getNewOrderRespType(), order.getRecvWindow(),
					order.getTimestamp() );
		}
		return executeSync( call );
	}


	@Override
	public CancelReplaceOrderResponse cancelReplace(NewNewOrder order)
	{
		return executeSync( binanceAPIService.cancelReplace( order.getSymbol(), order.getSide(), order.getType(), order.getMode(),
				order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getCancelOrderId(),
				order.getCancelOrigClientOrderId(), order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(),
				order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp() ) );
	}

	// User stream endpoints


	@Override
	public void newOrderTest(NewOrder order)
	{
		executeSync( binanceAPIService.newOrderTest( order.getSymbol(), order.getSide(), order.getType(), order.getTimeInForce(),
				order.getQuantity(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(),
				order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp() ) );
	}


	@Override
	public void ping()
	{
		executeSync( binanceAPIService.ping() );
	}


	@Override
	public String startUserDataStream()
	{
		return executeSync( binanceAPIService.startUserDataStream() ).toString();
	}


	@Override
	public WithdrawResult withdraw(String asset, String address, String amount, String name, String addressTag)
	{
		return executeSync( binanceAPIService.withdraw( asset, address, amount, name, addressTag,
				BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() ) );
	}
}
