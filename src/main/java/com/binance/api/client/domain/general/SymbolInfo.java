package com.binance.api.client.domain.general;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.OrderType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Symbol information (base/quote).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolInfo
{
	private String baseAsset;

	private Integer baseAssetPrecision;

	private String contractType;

	private long deliveryDate, onboardDate;

	private List<SymbolFilter> filters;

	private boolean icebergAllowed;

	private boolean isMarginTradingAllowed;

	private boolean isSpotTradingAllowed;

	private boolean ocoAllowed;

	private List<OrderType> orderTypes;

	private String quoteAsset;

	private boolean quoteOrderQtyMarketAllowed;

	private Integer quotePrecision;

	private int settlePlan;

	private SymbolStatus status;

	private String symbol;

	public String getBaseAsset()
	{
		return baseAsset;
	}


	public Integer getBaseAssetPrecision()
	{
		return baseAssetPrecision;
	}


	public String getContractType()
	{
		return contractType;
	}


	public long getDeliveryDate()
	{
		return deliveryDate;
	}


	public List<SymbolFilter> getFilters()
	{
		return filters;
	}


	public long getOnboardDate()
	{
		return onboardDate;
	}


	public List<OrderType> getOrderTypes()
	{
		return orderTypes;
	}


	public String getQuoteAsset()
	{
		return quoteAsset;
	}


	public Integer getQuotePrecision()
	{
		return quotePrecision;
	}


	public int getSettlePlan()
	{
		return settlePlan;
	}


	public SymbolStatus getStatus()
	{
		return status;
	}


	public String getSymbol()
	{
		return symbol;
	}


	/**
	 * @param filterType filter type to filter for.
	 * @return symbol filter information for the provided filter type.
	 */
	public SymbolFilter getSymbolFilter(FilterType filterType)
	{
		return filters.stream().filter( symbolFilter -> symbolFilter.getFilterType() == filterType ).findFirst().get();
	}


	public boolean isIcebergAllowed()
	{
		return icebergAllowed;
	}


	public boolean isMarginTradingAllowed()
	{
		return isMarginTradingAllowed;
	}


	public boolean isOcoAllowed()
	{
		return ocoAllowed;
	}


	public boolean isQuoteOrderQtyMarketAllowed()
	{
		return quoteOrderQtyMarketAllowed;
	}


	public boolean isSpotTradingAllowed()
	{
		return isSpotTradingAllowed;
	}


	public void setBaseAsset(String baseAsset)
	{
		this.baseAsset = baseAsset;
	}


	public void setBaseAssetPrecision(Integer baseAssetPrecision)
	{
		this.baseAssetPrecision = baseAssetPrecision;
	}


	public void setContractType(String contractType)
	{
		this.contractType = contractType;
	}


	public void setDeliveryDate(long deliveryDate)
	{
		this.deliveryDate = deliveryDate;
	}


	public void setFilters(List<SymbolFilter> filters)
	{
		this.filters = filters;
	}


	public void setIcebergAllowed(boolean icebergAllowed)
	{
		this.icebergAllowed = icebergAllowed;
	}


	public void setIsMarginTradingAllowed(boolean isMarginTradingAllowed)
	{
		this.isMarginTradingAllowed = isMarginTradingAllowed;
	}


	public void setIsSpotTradingAllowed(boolean isSpotTradingAllowed)
	{
		this.isSpotTradingAllowed = isSpotTradingAllowed;
	}


	public void setOcoAllowed(boolean ocoAllowed)
	{
		this.ocoAllowed = ocoAllowed;
	}


	public void setOnboardDate(long onboardDate)
	{
		this.onboardDate = onboardDate;
	}


	public void setOrderTypes(List<OrderType> orderTypes)
	{
		this.orderTypes = orderTypes;
	}


	public void setQuoteAsset(String quoteAsset)
	{
		this.quoteAsset = quoteAsset;
	}


	public void setQuoteOrderQtyMarketAllowed(boolean quoteOrderQtyMarketAllowed)
	{
		this.quoteOrderQtyMarketAllowed = quoteOrderQtyMarketAllowed;
	}


	public void setQuotePrecision(Integer quotePrecision)
	{
		this.quotePrecision = quotePrecision;
	}


	public void setSettlePlan(int settlePlan)
	{
		this.settlePlan = settlePlan;
	}


	public void setStatus(SymbolStatus status)
	{
		this.status = status;
	}


	public void setSymbol(String symbol)
	{
		this.symbol = symbol;
	}


	@Override
	public String toString()
	{
		return new ToStringBuilder( this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE ).append( "symbol", symbol )
				.append( "status", status ).append( "baseAsset", baseAsset ).append( "baseAssetPrecision", baseAssetPrecision )
				.append( "quoteAsset", quoteAsset ).append( "quotePrecision", quotePrecision ).append( "orderTypes", orderTypes )
				.append( "icebergAllowed", icebergAllowed ).append( "filters", filters ).toString();
	}
}
