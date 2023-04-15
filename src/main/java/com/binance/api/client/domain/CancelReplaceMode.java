package com.binance.api.client.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Buy/Sell order side.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum CancelReplaceMode
{
	STOP_ON_FAILURE, ALLOW_FAILURE
}
