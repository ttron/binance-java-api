package com.binance.api.examples.spot;

import static com.binance.api.client.domain.account.NewOrder.limitBuy;
import static com.binance.api.client.domain.account.NewOrder.marketBuy;

import java.util.List;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.TimeInForce;
import com.binance.api.client.domain.account.BinanceOrder;
import com.binance.api.client.domain.account.CancelOrderResponse;
import com.binance.api.client.domain.account.NewOrderResponse;
import com.binance.api.client.domain.account.NewOrderResponseType;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.CancelOrderRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.domain.account.request.OrderStatusRequest;
import com.binance.api.client.exception.BinanceAPIException;
import com.binance.api.client.spot.IBinanceSpotAPIRestClient;

/**
 * Examples on how to place orders, cancel them, and query account information.
 */
public class OrdersExample
{
	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance( "YOUR_API_KEY", "YOUR_SECRET" );
		IBinanceSpotAPIRestClient client = factory.newSpotRestClient();

		// Getting list of open orders
		List<BinanceOrder> openOrders = client.getOpenOrders( new OrderRequest( "LINKETH" ) );
		System.out.println( openOrders );

		// Getting list of all orders with a limit of 10
		List<BinanceOrder> allOrders = client.getAllOrders( new AllOrdersRequest( "LINKETH" ).limit( 10 ) );
		System.out.println( allOrders );

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

		// Placing a test LIMIT order
		client.newOrderTest( limitBuy( "LINKETH", TimeInForce.GTC, "1000", "0.0001" ) );

		// Placing a test MARKET order
		client.newOrderTest( marketBuy( "LINKETH", "1000" ) );

		// Placing a real LIMIT order
		NewOrderResponse newOrderResponse = client.newOrder(
				limitBuy( "LINKETH", TimeInForce.GTC, "1000", "0.0001" ).newOrderRespType( NewOrderResponseType.FULL ) );
		System.out.println( newOrderResponse );
	}
}
