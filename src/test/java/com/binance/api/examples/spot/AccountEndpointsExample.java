package com.binance.api.examples.spot;

import java.util.List;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.account.BinanceAccount;
import com.binance.api.client.domain.account.Trade;
import com.binance.api.client.spot.IBinanceSpotAPIRestClient;

/**
 * Examples on how to get account information.
 */
public class AccountEndpointsExample
{

	public static void main(String[] args)
	{
		BinanceAPIClientFactory factory = BinanceAPIClientFactory.newInstance( "YOUR_API_KEY", "YOUR_SECRET" );
		IBinanceSpotAPIRestClient client = factory.newSpotRestClient();
		// Get account balances
		BinanceAccount account = client.getAccount( 60_000L, System.currentTimeMillis() );
		System.out.println( account.getBalances() );
		System.out.println( account.getAssetBalance( "ETH" ) );

		// Get list of trades
		List<Trade> myTrades = client.getMyTrades( "NEOETH" );
		System.out.println( myTrades );

		// Get withdraw history
		System.out.println( client.getWithdrawHistory( "ETH" ) );

		// Get deposit history
		System.out.println( client.getDepositHistory( "ETH" ) );

		// Get deposit address
		System.out.println( client.getDepositAddress( "ETH" ) );

		// Withdraw
		client.withdraw( "ETH", "0x123", "0.1", null, null );
	}
}
