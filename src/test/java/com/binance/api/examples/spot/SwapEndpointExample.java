package com.binance.api.examples.spot;

import com.binance.api.client.BinanceAPIClientFactory;
import com.binance.api.client.domain.account.*;
import com.binance.api.client.spot.BinanceApiSwapRestClient;

import java.util.List;

public class SwapEndpointExample {

    public static String API_KEY = "api-key";
    public static String SECRET_KEY = "secret-key";

    public static void main(String[] args) {

        BinanceAPIClientFactory binanceApiClientFactory = BinanceAPIClientFactory.newInstance(API_KEY, SECRET_KEY);
        BinanceApiSwapRestClient swapClient = binanceApiClientFactory.newSwapRestClient();
        List<Pool> pools = swapClient.listAllSwapPools();
        for(Pool pool:pools) {
            System.out.println(pool);
            Liquidity poolLiquidityInfo = swapClient.getPoolLiquidityInfo(pool.getPoolId());
            System.out.println(poolLiquidityInfo);
        }
        SwapQuote swapQuote = swapClient.requestQuote("USDT", "USDC", "10");
        System.out.println(swapQuote);
        SwapRecord swapRecord = swapClient.swap("USDT", "USDC", "10");
        SwapHistory swapHistory = swapClient.getSwapHistory(swapRecord.getSwapId());
        System.out.println(swapHistory);
    }


}
