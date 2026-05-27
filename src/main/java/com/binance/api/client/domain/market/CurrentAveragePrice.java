/**
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS HEADER.
 *
 * Copyright (c) 2007-2026 Ttron Kidman. All rights reserved.
 */
package com.binance.api.client.domain.market;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @Ttron May 5, 2026
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CurrentAveragePrice
{
	// {
	// "mins": 5, // Average price interval (in minutes)
	// "price": "9.35751834", // Average price
	// "closeTime": 1694061154503 // Last trade time
	// }

	@JsonProperty("mins")
	private Integer mins;

	@JsonProperty("price")
	private Double price;

	@JsonProperty("closeTime")
	private Long closeTime;

	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "mins", mins )
				.append( "price", price ).append( "closeTime", closeTime ).toString();
	}
}
