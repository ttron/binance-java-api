/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2024 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.derivative;

import com.binance.api.client.domain.general.ExchangeInfo;

/**
 * @Ttron May 31, 2024
 */
public interface IBinanceFutureAPIRestClient
{
	/**
	 * Test connectivity to the Rest API.
	 */
	void ping();


	/**
	 * @return Current exchange trading rules and symbol information
	 */
	ExchangeInfo getExchangeInfo();


	/**
	 * Test connectivity to the Rest API and get the current server time.
	 *
	 * @return current server time.
	 */
	Long getServerTime();
}
