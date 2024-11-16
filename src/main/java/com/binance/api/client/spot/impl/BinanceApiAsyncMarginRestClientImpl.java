package com.binance.api.client.spot.impl;

import static com.binance.api.client.BinanceAPIServiceGenerator.createService;

import java.util.List;

import com.binance.api.client.BinanceSpotAPIService;
import com.binance.api.client.constant.BinanceAPIConstants;
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
import com.binance.api.client.spot.BinanceApiAsyncMarginRestClient;
import com.binance.api.client.spot.BinanceAPICallback;

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiAsyncMarginRestClientImpl implements BinanceApiAsyncMarginRestClient
{
	private final BinanceSpotAPIService binanceApiService;

	public BinanceApiAsyncMarginRestClientImpl(String apiKey, String secret)
	{
		binanceApiService = createService( BinanceSpotAPIService.class, apiKey, secret );
	}

	// Margin Account endpoints


	@Override
	public void getAccount(Long recvWindow, Long timestamp, BinanceAPICallback<MarginAccount> callback)
	{
		binanceApiService.getMarginAccount( recvWindow, timestamp ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getAccount(BinanceAPICallback<MarginAccount> callback)
	{
		long timestamp = System.currentTimeMillis();
		binanceApiService.getMarginAccount( BinanceAPIConstants.DEFAULT_MARGIN_RECEIVING_WINDOW, timestamp )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getOpenOrders(OrderRequest orderRequest, BinanceAPICallback<List<BinanceOrder>> callback)
	{
		binanceApiService
				.getOpenMarginOrders( orderRequest.getSymbol(), orderRequest.getRecvWindow(), orderRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void newOrder(MarginNewOrder order, BinanceAPICallback<MarginNewOrderResponse> callback)
	{
		binanceApiService
				.newMarginOrder( order.getSymbol(), order.getSide(), order.getType(), order.getTimeInForce(), order.getQuantity(),
						order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(), order.getIcebergQty(),
						order.getNewOrderRespType(), order.getSideEffectType(), order.getRecvWindow(), order.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void cancelOrder(CancelOrderRequest cancelOrderRequest, BinanceAPICallback<CancelOrderResponse> callback)
	{
		binanceApiService
				.cancelMarginOrder( cancelOrderRequest.getSymbol(), cancelOrderRequest.getOrderId(),
						cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
						cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getOrderStatus(OrderStatusRequest orderStatusRequest, BinanceAPICallback<BinanceOrder> callback)
	{
		binanceApiService.getMarginOrderStatus( orderStatusRequest.getSymbol(), orderStatusRequest.getOrderId(),
				orderStatusRequest.getOrigClientOrderId(), orderStatusRequest.getRecvWindow(), orderStatusRequest.getTimestamp() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void getMyTrades(String symbol, BinanceAPICallback<List<Trade>> callback)
	{
		binanceApiService
				.getMyTrades( symbol, null, null, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, System.currentTimeMillis() )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}

	// user stream endpoints


	@Override
	public void startUserDataStream(BinanceAPICallback<ListenKey> callback)
	{
		binanceApiService.startMarginUserDataStream().enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void keepAliveUserDataStream(String listenKey, BinanceAPICallback<Void> callback)
	{
		binanceApiService.keepAliveMarginUserDataStream( listenKey ).enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void transfer(String asset, String amount, TransferType type, BinanceAPICallback<MarginTransaction> callback)
	{
		long timestamp = System.currentTimeMillis();
		binanceApiService
				.transfer( asset, amount, type.getValue(), BinanceAPIConstants.DEFAULT_MARGIN_RECEIVING_WINDOW, timestamp )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void borrow(String asset, String amount, BinanceAPICallback<MarginTransaction> callback)
	{
		long timestamp = System.currentTimeMillis();
		binanceApiService.borrow( asset, amount, BinanceAPIConstants.DEFAULT_MARGIN_RECEIVING_WINDOW, timestamp )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}


	@Override
	public void repay(String asset, String amount, BinanceAPICallback<MarginTransaction> callback)
	{
		long timestamp = System.currentTimeMillis();
		binanceApiService.repay( asset, amount, BinanceAPIConstants.DEFAULT_MARGIN_RECEIVING_WINDOW, timestamp )
				.enqueue( new BinanceApiCallbackAdapter<>( callback ) );
	}
}
