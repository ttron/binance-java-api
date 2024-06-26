package com.binance.api.client.spot.impl;

import static com.binance.api.client.BinanceAPIServiceGenerator.createService;
import static com.binance.api.client.BinanceAPIServiceGenerator.executeSync;

import java.util.List;

import com.binance.api.client.BinanceSpotAPIService;
import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.TransferType;
import com.binance.api.client.domain.account.BinanceOrder;
import com.binance.api.client.domain.account.CancelOrderResponse;
import com.binance.api.client.domain.account.LoanQueryResult;
import com.binance.api.client.domain.account.MarginAccount;
import com.binance.api.client.domain.account.MarginNewOrder;
import com.binance.api.client.domain.account.MarginNewOrderResponse;
import com.binance.api.client.domain.account.MarginTransaction;
import com.binance.api.client.domain.account.MaxBorrowableQueryResult;
import com.binance.api.client.domain.account.RepayQueryResult;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.spot.BinanceApiMarginRestClient;

/**
 * Implementation of Binance's Margin REST API using Retrofit with asynchronous/non-blocking method calls.
 */
public class BinanceApiMarginRestClientImpl implements BinanceApiMarginRestClient
{
	private final BinanceSpotAPIService binanceApiService;

	public BinanceApiMarginRestClientImpl(String apiKey, String secret)
	{
		binanceApiService = createService( BinanceSpotAPIService.class, apiKey, secret );
	}


	@Override
	public MarginAccount getAccount()
	{
		long timestamp = System.currentTimeMillis();
		return executeSync( binanceApiService.getMarginAccount( BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, timestamp ) );
	}


	@Override
	public List<BinanceOrder> getOpenOrders(OrderRequest orderRequest)
	{
		return executeSync( binanceApiService.getOpenMarginOrders( orderRequest.getSymbol(), orderRequest.getRecvWindow(),
				orderRequest.getTimestamp() ) );
	}


	@Override
	public MarginNewOrderResponse newOrder(MarginNewOrder order)
	{
		return executeSync( binanceApiService.newMarginOrder( order.getSymbol(), order.getSide(), order.getType(),
				order.getTimeInForce(), order.getQuantity(), order.getPrice(), order.getNewClientOrderId(), order.getStopPrice(),
				order.getIcebergQty(), order.getNewOrderRespType(), order.getSideEffectType(), order.getRecvWindow(),
				order.getTimestamp() ) );
	}


	@Override
	public CancelOrderResponse cancelOrder(CancelOrderRequest cancelOrderRequest)
	{
		return executeSync( binanceApiService.cancelMarginOrder( cancelOrderRequest.getSymbol(), cancelOrderRequest.getOrderId(),
				cancelOrderRequest.getOrigClientOrderId(), cancelOrderRequest.getNewClientOrderId(),
				cancelOrderRequest.getRecvWindow(), cancelOrderRequest.getTimestamp() ) );
	}


	@Override
	public BinanceOrder getOrderStatus(OrderStatusRequest orderStatusRequest)
	{
		return executeSync( binanceApiService.getMarginOrderStatus( orderStatusRequest.getSymbol(),
				orderStatusRequest.getOrderId(), orderStatusRequest.getOrigClientOrderId(), orderStatusRequest.getRecvWindow(),
				orderStatusRequest.getTimestamp() ) );
	}


	@Override
	public List<Trade> getMyTrades(String symbol)
	{
		return executeSync( binanceApiService.getMyTrades( symbol, null, null, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW,
				System.currentTimeMillis() ) );
	}

	// user stream endpoints


	@Override
	public String startUserDataStream()
	{
		return executeSync( binanceApiService.startMarginUserDataStream() ).toString();
	}


	@Override
	public void keepAliveUserDataStream(String listenKey)
	{
		executeSync( binanceApiService.keepAliveMarginUserDataStream( listenKey ) );
	}


	@Override
	public MarginTransaction transfer(String asset, String amount, TransferType type)
	{
		long timestamp = System.currentTimeMillis();
		return executeSync( binanceApiService.transfer( asset, amount, type.getValue(),
				BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, timestamp ) );
	}


	@Override
	public MarginTransaction borrow(String asset, String amount)
	{
		long timestamp = System.currentTimeMillis();
		return executeSync( binanceApiService.borrow( asset, amount, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, timestamp ) );
	}


	@Override
	public LoanQueryResult queryLoan(String asset, String txId)
	{
		long timestamp = System.currentTimeMillis();
		return executeSync( binanceApiService.queryLoan( asset, txId, timestamp ) );
	}


	@Override
	public RepayQueryResult queryRepay(String asset, String txId)
	{
		long timestamp = System.currentTimeMillis();
		return executeSync( binanceApiService.queryRepay( asset, txId, timestamp ) );
	}


	@Override
	public RepayQueryResult queryRepay(String asset, long startTime)
	{
		long timestamp = System.currentTimeMillis();
		return executeSync( binanceApiService.queryRepay( asset, startTime, timestamp ) );
	}


	@Override
	public MaxBorrowableQueryResult queryMaxBorrowable(String asset)
	{
		long timestamp = System.currentTimeMillis();
		return executeSync( binanceApiService.queryMaxBorrowable( asset, timestamp ) );
	}


	@Override
	public MarginTransaction repay(String asset, String amount)
	{
		long timestamp = System.currentTimeMillis();
		return executeSync( binanceApiService.repay( asset, amount, BinanceAPIConstants.DEFAULT_RECEIVING_WINDOW, timestamp ) );
	}
}
