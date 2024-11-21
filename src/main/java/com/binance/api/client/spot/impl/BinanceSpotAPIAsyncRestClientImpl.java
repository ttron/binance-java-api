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
import com.binance.api.client.spot.BinanceAPICallback;
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
	public void cancelOrder(CancelOrderRequest cancelOrderRequest, BinanceAPICallback<CancelOrderResponse> callback)
	{
		binanceApiService
				.cancelOrder( cancelOrderRequest.getSymbol(), cancelOrderRequest.getOrderId(),
						cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
						cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void closeUserDataStream(String listenKey, BinanceAPICallback<Void> callback)
	{
		binanceApiService.closeAliveUserDataStream( listenKey ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAll24HrPriceStatistics(BinanceAPICallback<List<TickerStatistics>> callback)
	{
		binanceApiService.getAll24HrPriceStatistics().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void get24HrPriceStatistics(String symbol, BinanceAPICallback<TickerStatistics> callback)
	{
		binanceApiService.get24HrPriceStatistics( symbol ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAccount(BinanceAPICallback<BinanceAccount> callback)
	{
		long timestamp = System.currentTimeMillis();
		binanceApiService.getAccount( BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, timestamp )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}

	// Market Data endpoints


	@Override
	public void getAccount(Long recvWindow, Long timestamp, BinanceAPICallback<BinanceAccount> callback)
	{
		binanceApiService.getAccount( recvWindow, timestamp ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAggTrades(String symbol, BinanceAPICallback<List<AggTrade>> callback)
	{
		getAggTrades( symbol, null, null, null, null, callback );
	}


	@Override
	public void getAggTrades(String symbol, String fromId, Integer limit, Long startTime, Long endTime,
			BinanceAPICallback<List<AggTrade>> callback)
	{
		binanceApiService.getAggTrades( symbol, fromId, limit, startTime, endTime )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAllAssets(BinanceAPICallback<List<Asset>> callback)
	{
		binanceApiService.getAllAssets( BinanceAPIConfig.getAssetInfoApiBaseUrl() + "assetWithdraw/getAllAsset.html" )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAllOrders(AllOrdersRequest orderRequest, BinanceAPICallback<List<BinanceOrder>> callback)
	{
		binanceApiService
				.getAllOrders( orderRequest.getSymbol(), orderRequest.getOrderId(), orderRequest.getLimit(),
						orderRequest.getRecvWindow(), orderRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAllPrices(BinanceAPICallback<List<TickerPrice>> callback)
	{
		binanceApiService.getLatestPrices().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getBookTickers(BinanceAPICallback<List<BookTicker>> callback)
	{
		binanceApiService.getBookTickers().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getCandlestickBars(String symbol, CandlestickInterval interval, BinanceAPICallback<List<Candlestick>> callback)
	{
		getCandlestickBars( symbol, interval, null, null, null, callback );
	}


	@Override
	public void getCandlestickBars(String symbol, CandlestickInterval interval, Integer limit, Long startTime, Long endTime,
			BinanceAPICallback<List<Candlestick>> callback)
	{
		binanceApiService.getCandlestickBars( symbol, interval.getIntervalId(), limit, startTime, endTime )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getDepositAddress(String asset, BinanceAPICallback<DepositAddress> callback)
	{
		binanceApiService.getDepositAddress( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getDepositHistory(String asset, BinanceAPICallback<DepositHistory> callback)
	{
		binanceApiService.getDepositHistory( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getSpotExchangeInfo(BinanceAPICallback<ExchangeInfo> callback)
	{
		binanceApiService.getExchangeInfo().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getHistoricalTrades(String symbol, Integer limit, Long fromId,
			BinanceAPICallback<List<TradeHistoryItem>> callback)
	{
		binanceApiService.getHistoricalTrades( symbol, limit, fromId ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}

	// Account endpoints


	@Override
	public void getMyTrades(String symbol, BinanceAPICallback<List<Trade>> callback)
	{
		getMyTrades( symbol, null, null, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis(), callback );
	}


	@Override
	public void getMyTrades(String symbol, Integer limit, BinanceAPICallback<List<Trade>> callback)
	{
		getMyTrades( symbol, limit, null, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis(), callback );
	}


	@Override
	public void getMyTrades(String symbol, Integer limit, Long fromId, Long recvWindow, Long timestamp,
			BinanceAPICallback<List<Trade>> callback)
	{
		binanceApiService.getMyTrades( symbol, limit, fromId, recvWindow, timestamp )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getOpenOrders(OrderRequest orderRequest, BinanceAPICallback<List<BinanceOrder>> callback)
	{
		binanceApiService.getOpenOrders( orderRequest.getSymbol(), orderRequest.getRecvWindow(), orderRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getOrderBook(String symbol, Integer limit, BinanceAPICallback<OrderBook> callback)
	{
		binanceApiService.getOrderBook( symbol, limit ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getOrderStatus(OrderStatusRequest orderStatusRequest, BinanceAPICallback<BinanceOrder> callback)
	{
		binanceApiService.getOrderStatus( orderStatusRequest.getSymbol(), orderStatusRequest.getOrderId(),
				orderStatusRequest.getOrigClientOrderId(), orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getPrice(String symbol, BinanceAPICallback<TickerPrice> callback)
	{
		binanceApiService.getLatestPrice( symbol ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getServerTime(BinanceAPICallback<ServerTime> callback)
	{
		binanceApiService.getServerTime().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getTrades(String symbol, Integer limit, BinanceAPICallback<List<TradeHistoryItem>> callback)
	{
		binanceApiService.getTrades( symbol, limit ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getWithdrawHistory(String asset, BinanceAPICallback<WithdrawHistory> callback)
	{
		binanceApiService.getWithdrawHistory( asset, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void keepAliveUserDataStream(String listenKey, BinanceAPICallback<Void> callback)
	{
		binanceApiService.keepAliveUserDataStream( listenKey ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void newOrder(NewOrder order, BinanceAPICallback<NewOrderResponse> callback)
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
	public void newOrderTest(NewOrder order, BinanceAPICallback<Void> callback)
	{
		binanceApiService
				.newOrderTest( order.getSymbol(), order.getSide(), order.getType(), order.getTimeInForce(), order.getQuantity(),
						order.getQuoteOrderQty(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
						order.getIcebergQty(), order.getNewOrderRespType(), order.getRecvWindow(), order.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}

	// User stream endpoints


	@Override
	public void ping(BinanceAPICallback<Void> callback)
	{
		binanceApiService.ping().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void startUserDataStream(BinanceAPICallback<ListenKey> callback)
	{
		binanceApiService.startUserDataStream().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void withdraw(String asset, String address, String amount, String name, String addressTag,
			BinanceAPICallback<WithdrawResult> callback)
	{
		binanceApiService.withdraw( asset, address, amount, name, addressTag, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW,
				System.currentTimeMillis() ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}
}
