package com.binance.api.examples.spot;

import static com.binance.api.client.domain.account.MarginNewOrder.limitBuy;

import java.util.List;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.BinanceOrder;
import com.binance.api.client.domain.account.CancelOrderResponse;
import com.binance.api.client.domain.account.MarginNewOrderResponse;
import com.binance.api.client.domain.account.NewOrderResponseType;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.exception.BinanceAPIException;
import com.binance.api.client.spot.BinanceApiMarginRestClient;

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
public class MarginOrdersExample
{

	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance( "YOUR_API_KEY", "YOUR_SECRET" );
		BinanceApiMarginRestClient client = factory.newMarginRestClient();

		// Getting list of open orders
		List<BinanceOrder> openOrders = client.getOpenOrders( new OrderRequest( "LINKETH" ) );
		System.out.println( openOrders );

		// Get status of a particular order
		BinanceOrder order = client.getOrderStatus( new OrderStatusRequest( "LINKETH", 751698L ) );
		System.out.println( order );

		// Canceling an order
		try
		{
			CancelOrderResponse cancelOrderResponse = client.cancelOrder( new CancelOrderRequest( "LINKETH", 756762l ) );
			System.out.println( cancelOrderResponse );
		}
		catch (BinanceAPIException e)
		{
			System.out.println( e.getError().getMsg() );
		}

		// Placing a real LIMIT order
		MarginNewOrderResponse newOrderResponse = client.newOrder(
				limitBuy( "LINKETH", TimeInForce.GTC, "1000", "0.0001" ).newOrderRespType( NewOrderResponseType.FULL ) );
		System.out.println( newOrderResponse );
	}

}
