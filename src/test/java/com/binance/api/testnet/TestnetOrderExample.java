/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.testnet;

import java.util.List;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.account.BinanceOrder;
import com.binance.api.client.domain.account.request.AllOrdersRequest;
import com.binance.api.client.domain.account.request.OrderRequest;
import com.binance.api.client.spot.IBinanceSpotAPIRestClient;

/**
 * @MR006 Nov 10, 2024
 *
 */
public class TestnetOrderExample
{
	static BinanceAPIClientFactory FACTORY;

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		if (FACTORY == null)
			FACTORY = BinanceAPIClientFactory.newInstance();
		IBinanceSpotAPIRestClient client = FACTORY.newTestnetSpotRestClient();

		// Getting list of open orders
		List<BinanceOrder> openOrders = client.getOpenOrders( new OrderRequest( "DOGEUSDT" ) );
		System.out.println( openOrders );

		// Placing a real LIMIT order
		// NewOrderResponse newOrderResponse = client.newOrder(
		// limitBuy( "DOGEUSDT", TimeInForce.GTC, "1000", "0.265" ).newOrderRespType(
		// NewOrderResponseType.FULL ) );
		// System.out.println( newOrderResponse );

		// Getting list of all orders with a limit of 10
		List<BinanceOrder> allOrders = client.getAllOrders( new AllOrdersRequest( "DOGEUSDT" ).limit( 10 ) );
		System.out.println( allOrders );
	}
}
