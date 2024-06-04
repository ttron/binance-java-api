package com.binance.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Type of order to submit to the system.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum OrderType
{
	LIMIT, MARKET, STOP, STOP_LOSS, STOP_LOSS_LIMIT, STOP_MARKET, TAKE_PROFIT, TAKE_PROFIT_LIMIT, LIMIT_MAKER, TAKE_PROFIT_MARKET, TRAILING_STOP_MARKET;
}
