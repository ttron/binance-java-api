package com.binance.api.examples.spot;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.event.AccountUpdateEvent;
import com.binance.api.client.domain.event.OrderTradeUpdateEvent;
import com.binance.api.client.domain.event.UserDataUpdateEvent.UserDataUpdateEventType;
import com.binance.api.client.spot.BinanceApiMarginRestClient;
import com.binance.api.client.spot.IBinanceAPIWebSocketClient;

/**
 * User data stream endpoints examples.
 *
 * It illustrates how to create a stream to obtain updates on a user account,
 * as well as update on trades/orders on a user account.
 */
public class MarginUserDataStreamExample
{

	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance( "YOUR_API_KEY", "YOUR_SECRET" );
		BinanceApiMarginRestClient client = factory.newMarginRestClient();

		// First, we obtain a listenKey which is required to interact with the user data stream
		String listenKey = client.startUserDataStream();

		// Then, we open a new web socket client, and provide a callback that is called on every update
		IBinanceAPIWebSocketClient webSocketClient = factory.newWebSocketClient();

		// Listen for changes in the account
		webSocketClient.onUserDataUpdateEvent( listenKey, response -> {
			if (response.getEventType() == UserDataUpdateEventType.ACCOUNT_UPDATE)
			{
				AccountUpdateEvent accountUpdateEvent = response.getAccountUpdateEvent();
				// Print new balances of every available asset
				System.out.println( accountUpdateEvent.getBalances() );
			}
			else
			{
				OrderTradeUpdateEvent orderTradeUpdateEvent = response.getOrderTradeUpdateEvent();
				// Print details about an order/trade
				System.out.println( orderTradeUpdateEvent );

				// Print original quantity
				System.out.println( orderTradeUpdateEvent.getOriginalQuantity() );

				// Or price
				System.out.println( orderTradeUpdateEvent.getPrice() );
			}
		} );
		System.out.println( "Waiting for events..." );

		// We can keep alive the user data stream
		// client.keepAliveUserDataStream(listenKey);

		// Or we can invalidate it, whenever it is no longer needed
		// client.closeUserDataStream(listenKey);
	}
}
