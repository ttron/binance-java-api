package com.binance.api.client.domain.account;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import xyz.tsst.billions.crypto.CYYAccount;

/**
 * Account information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class BinanceAccount extends CYYAccount
{
	/**
	 * List of asset balances of this account.
	 */
	private List<AssetBalance> balances;

	/**
	 * Buyer commission.
	 */
	private int buyerCommission;

	/**
	 * Whether or not it is possible to deposit into this account.
	 */
	private boolean canDeposit;

	/**
	 * Whether or not this account can trade.
	 */
	private boolean canTrade;

	/**
	 * Whether or not it is possible to withdraw from this account.
	 */
	private boolean canWithdraw;

	@JsonProperty("commissionRates")
	private CommissionRate commissionRate;

	/**
	 * Maker commission.
	 */
	private int makerCommission;

	/**
	 * Seller commission.
	 */
	private int sellerCommission;

	/**
	 * Taker commission.
	 */
	private int takerCommission;

	/**
	 * Last account update time.
	 */
	private long updateTime;

	/**
	 * Returns the asset balance for a given symbol.
	 *
	 * @param symbol asset symbol to obtain the balances from
	 * @return an asset balance for the given symbol which can be 0 in case the symbol has no balance in the account
	 */
	public AssetBalance getAssetBalance(String symbol)
	{
		for ( AssetBalance assetBalance : balances )
		{
			if (symbol.equals( assetBalance.getAsset() ))
			{
				return assetBalance;
			}
		}

		AssetBalance empty = new AssetBalance();
		empty.setAsset( symbol );
		empty.setFree( "0" );
		empty.setLocked( "0" );
		return empty;
	}


	public List<AssetBalance> getBalances()
	{
		return balances;
	}


	public int getBuyerCommission()
	{
		return buyerCommission;
	}


	public CommissionRate getCommissionRate()
	{
		return commissionRate;
	}


	public int getMakerCommission()
	{
		return makerCommission;
	}


	public int getSellerCommission()
	{
		return sellerCommission;
	}


	public int getTakerCommission()
	{
		return takerCommission;
	}


	public long getUpdateTime()
	{
		return updateTime;
	}


	public boolean isCanDeposit()
	{
		return canDeposit;
	}


	public boolean isCanTrade()
	{
		return canTrade;
	}


	public boolean isCanWithdraw()
	{
		return canWithdraw;
	}


	public void setBalances(List<AssetBalance> balances)
	{
		this.balances = balances;
	}


	public void setBuyerCommission(int buyerCommission)
	{
		this.buyerCommission = buyerCommission;
	}


	public void setCanDeposit(boolean canDeposit)
	{
		this.canDeposit = canDeposit;
	}


	public void setCanTrade(boolean canTrade)
	{
		this.canTrade = canTrade;
	}


	public void setCanWithdraw(boolean canWithdraw)
	{
		this.canWithdraw = canWithdraw;
	}


	public void setCommissionRate(CommissionRate commissionRate)
	{
		this.commissionRate = commissionRate;
	}


	public void setMakerCommission(int makerCommission)
	{
		this.makerCommission = makerCommission;
	}


	public void setSellerCommission(int sellerCommission)
	{
		this.sellerCommission = sellerCommission;
	}


	public void setTakerCommission(int takerCommission)
	{
		this.takerCommission = takerCommission;
	}


	public void setUpdateTime(long updateTime)
	{
		this.updateTime = updateTime;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE )
				.append( "makerCommission", makerCommission ).append( "takerCommission", takerCommission )
				.append( "buyerCommission", buyerCommission ).append( "sellerCommission", sellerCommission )
				.append( "canTrade", canTrade ).append( "canWithdraw", canWithdraw ).append( "canDeposit", canDeposit )
				.append( "updateTime", updateTime ).append( "balances", balances ).toString();
	}
}
