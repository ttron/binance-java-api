package com.binance.api.examples;

import com.binance.api.client.IBinanceAPIAsyncRestClient;
import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.account.BinanceAccount;

/**
 * Examples on how to get account information.
 */
public class AccountEndpointsExampleAsync
{
	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance( "YOUR_API_KEY", "YOUR_SECRET" );
		IBinanceAPIAsyncRestClient client = factory.newAsyncRestClient();

		// Get account balances (async)
		client.getAccount( (BinanceAccount response) -> System.out.println( response.getAssetBalance( "ETH" ) ) );

		// Get list of trades (async)
		client.getMyTrades( "NEOETH", response -> System.out.println( response ) );

		// Get withdraw history (async)
		client.getWithdrawHistory( "ETH", response -> System.out.println( response ) );

		// Get deposit history (async)
		client.getDepositHistory( "ETH", response -> System.out.println( response ) );

		// Withdraw (async)
		client.withdraw( "ETH", "0x123", "0.1", null, null, response -> {
		} );
	}
}
