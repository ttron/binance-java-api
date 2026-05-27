package com.binance.api.client.domain.general;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Status of a symbol on the exchange.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public enum SymbolStatus
{
	/**
	 *
	 */
	PRE_TRADING,
	/**
	 * The symbol is active, and orders are allowed.
	 */
	TRADING,
	/**
	 *
	 */
	POST_TRADING,
	/**
	 *
	 */
	END_OF_DAY,
	/**
	 * Trading for the symbol is temporarily suspended.
	 */
	HALT,
	/**
	 *
	 */
	AUCTION_MATCH,
	/**
	 * The symbol is in a temporary break period, and trading is not allowed.
	 */
	BREAK,
	/**
	 *
	 */
	PENDING_TRADING,
	/**
	 *
	 */
	SETTLING;
}
