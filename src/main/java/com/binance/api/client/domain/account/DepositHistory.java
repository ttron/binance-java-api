package com.binance.api.client.domain.account;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * History of account deposits.
 *
 * @see Deposit
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepositHistory
{
	@JsonProperty("depositList")
	private List<Deposit> depositList;

	private boolean success;

	private String msg;

	public String getMsg()
	{
		return msg;
	}


	public void setMsg(String msg)
	{
		this.msg = msg;
	}


	public List<Deposit> getDepositList()
	{
		return depositList;
	}


	public void setDepositList(List<Deposit> depositList)
	{
		this.depositList = depositList;
	}


	public boolean isSuccess()
	{
		return success;
	}


	public void setSuccess(boolean success)
	{
		this.success = success;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "depositList", depositList )
				.append( "success", success ).append( "msg", msg ).toString();
	}
}
