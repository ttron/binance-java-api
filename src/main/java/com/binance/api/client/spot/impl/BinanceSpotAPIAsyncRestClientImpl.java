package com.binance.api.client.spot.impl;

import static com.binance.api.client.BinanceAPIServiceGenerator.createService;
import static com.binance.api.client.config.BinanceAPIConfig.getSpotBaseUrl;

import java.util.List;

import com.binance.api.client.BinanceSpotAPIService;
import com.binance.api.client.config.BinanceAPIConfig;
import com.binance.api.client.constant.BinanceAPIConstants;
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
import com.binance.api.client.spot.BinanceApiCallback;
import com.binance.api.client.spot.IBinanceSpotAPIAsyncRestClient;

/**
 * Implementation of Binance's REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceSpotAPIAsyncRestClientImpl implements IBinanceSpotAPIAsyncRestClient
{
	private final BinanceSpotAPIService binanceApiService;

	public BinanceSpotAPIAsyncRestClientImpl(String apiKey, String secret)
	{
		binanceApiService = createService( BinanceSpotAPIService.class, getSpotBaseUrl(), apiKey, secret );
	}

	// General endpoints


	@Override
	public void cancelOrder(CancelOrderRequest cancelOrderRequest, BinanceApiCallback<CancelOrderResponse> callback)
	{
		binanceApiService
				.cancelOrder( cancelOrderRequest.getSymbol(), cancelOrderRequest.getOrderId(),
						cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
						cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void closeUserDataStream(String listenKey, BinanceApiCallback<Void> callback)
	{
		binanceApiService.closeAliveUserDataStream( listenKey ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void get24HrPriceStatistics(String symbol, BinanceApiCallback<TickerStatistics> callback)
	{
		binanceApiService.get24HrPriceStatistics( symbol ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAccount(BinanceApiCallback<BinanceAccount> callback)
	{
		long timestamp = System.currentTimeMillis();
		binanceApiService.getAccount( BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, timestamp )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}

	// Market Data endpoints


	@Override
	public void getAccount(Long recvWindow, Long timestamp, BinanceApiCallback<BinanceAccount> callback)
	{
		binanceApiService.getAccount( recvWindow, timestamp ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAggTrades(String symbol, BinanceApiCallback<List<AggTrade>> callback)
	{
		getAggTrades( symbol, null, null, null, null, callback );
	}


	@Override
	public void getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime,
			BinanceApiCallback<List<AggTrade>> callback)
	{
		binanceApiService.getAggTrades( symbol, fromId, limit, startTime, endTime )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAll24HrPriceStatistics(BinanceApiCallback<List<TickerStatistics>> callback)
	{
		binanceApiService.getAll24HrPriceStatistics().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAllAssets(BinanceApiCallback<List<Asset>> callback)
	{
		binanceApiService.getAllAssets( BinanceAPIConfig.getAssetInfoApiBaseUrl() + "assetWithdraw/getAllAsset.html" )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAllOrders(AllOrdersRequest orderRequest, BinanceApiCallback<List<BinanceOrder>> callback)
	{
		binanceApiService
				.getAllOrders( orderRequest.getSymbol(), orderRequest.getOrderId(), orderRequest.getLimit(),
						orderRequest.getRecvWindow(), orderRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAllPrices(BinanceApiCallback<List<TickerPrice>> callback)
	{
		binanceApiService.getLatestPrices().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getBookTickers(BinanceApiCallback<List<BookTicker>> callback)
	{
		binanceApiService.getBookTickers().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getCandlestickBars(String symbol, CandlestickInterval interval, BinanceApiCallback<List<Candlestick>> callback)
	{
		getCandlestickBars( symbol, interval, null, null, null, callback );
	}


	@Override
	public void getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime,
			BinanceApiCallback<List<Candlestick>> callback)
	{
		binanceApiService.getCandlestickBars( symbol, interval.getIntervalId(), limit, startTime, endTime )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getDepositAddress(String asset, BinanceApiCallback<DepositAddress> callback)
	{
		binanceApiService.getDepositAddress( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getDepositHistory(String asset, BinanceApiCallback<DepositHistory> callback)
	{
		binanceApiService.getDepositHistory( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getSpotExchangeInfo(BinanceApiCallback<ExchangeInfo> callback)
	{
		binanceApiService.getExchangeInfo().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getHistoricalTrades(String symbol, Integer limit, Long fromId,
			BinanceApiCallback<List<TradeHistoryItem>> callback)
	{
		binanceApiService.getHistoricalTrades( symbol, limit, fromId ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}

	// Account endpoints


	@Override
	public void getMyTrades(String symbol, BinanceApiCallback<List<Trade>> callback)
	{
		getMyTrades( symbol, null, null, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis(), callback );
	}


	@Override
	public void getMyTrades(String symbol, Integer limit, BinanceApiCallback<List<Trade>> callback)
	{
		getMyTrades( symbol, limit, null, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis(), callback );
	}


	@Override
	public void getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp,
			BinanceApiCallback<List<Trade>> callback)
	{
		binanceApiService.getMyTrades( symbol, limit, fromId, recvWindow, timestamp )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getOpenOrders(OrderRequest orderRequest, BinanceApiCallback<List<BinanceOrder>> callback)
	{
		binanceApiService.getOpenOrders( orderRequest.getSymbol(), orderRequest.getRecvWindow(), orderRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getOrderBook(String symbol, Integer limit, BinanceApiCallback<OrderBook> callback)
	{
		binanceApiService.getOrderBook( symbol, limit ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getOrderStatus(OrderStatusRequest orderStatusRequest, BinanceApiCallback<BinanceOrder> callback)
	{
		binanceApiService.getOrderStatus( orderStatusRequest.getSymbol(), orderStatusRequest.getOrderId(),
				orderStatusRequest.getOrigClientOrderId(), orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getPrice(String symbol, BinanceApiCallback<TickerPrice> callback)
	{
		binanceApiService.getLatestPrice( symbol ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getServerTime(BinanceApiCallback<ServerTime> callback)
	{
		binanceApiService.getServerTime().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getTrades(String symbol, Integer limit, BinanceApiCallback<List<TradeHistoryItem>> callback)
	{
		binanceApiService.getTrades( symbol, limit ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getWithdrawHistory(String asset, BinanceApiCallback<WithdrawHistory> callback)
	{
		binanceApiService.getWithdrawHistory( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void keepAliveUserDataStream(String listenKey, BinanceApiCallback<Void> callback)
	{
		binanceApiService.keepAliveUserDataStream( listenKey ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void newOrder(NewOrder order, BinanceApiCallback<NewOrderResponse> callback)
	{
		if (order.getQuoteOrderQty() == null)
		{
			binanceApiService
					.newOrder( order.getSymbol(), order.getSide(), order.getType(), order.getTimeInForce(), order.getQuantity(),
							order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(),
							order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp() )
					.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
		}
		else
		{
			binanceApiService
					.newOrderQuoteQty( order.getSymbol(), order.getSide(), order.getType(), order.getTimeInForce(),
							order.getQuoteOrderQty(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
							order.getIcebergQty(), order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp() )
					.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
		}
	}


	@Override
	public void newOrderTest(NewOrder order, BinanceApiCallback<Void> callback)
	{
		binanceApiService
				.newOrderTest( order.getSymbol(), order.getSide(), order.getType(), order.getTimeInForce(), order.getQuantity(),
						order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(),
						order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}

	// User stream endpoints


	@Override
	public void ping(BinanceApiCallback<Void> callback)
	{
		binanceApiService.ping().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void startUserDataStream(BinanceApiCallback<ListenKey> callback)
	{
		binanceApiService.startUserDataStream().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void withdraw(String asset, String address, String amount, String name, String addressTag,
			BinanceApiCallback<WithdrawResult> callback)
	{
		binanceApiService.withdraw( asset, address, amount, name, addressTag, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW,
				System.currentTimeMillis() ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}
}