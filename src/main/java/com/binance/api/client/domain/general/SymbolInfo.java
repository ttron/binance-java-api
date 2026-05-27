package com.binance.api.client.domain.general;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.binance.api.client.domain.OrderType;
import com.binance.api.client.domain.SymbolRR;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Symbol information (base/quote).
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class SymbolInfo extends SymbolRR
{
	// "symbol": "ETHBTC",
	// "status": "TRADING",
	// "baseAsset": "ETH",
	// "baseAssetPrecision": 8,
	// "quoteAsset": "BTC",
	// "quotePrecision": 8, // will be removed in future api versions (v4+)
	// "quoteAssetPrecision": 8,
	// "baseCommissionPrecision": 8,
	// "quoteCommissionPrecision": 8,
	// "icebergAllowed": true,
	// "ocoAllowed": true,
	// "otoAllowed": true,
	// "opoAllowed": true,
	// "quoteOrderQtyMarketAllowed": true,
	// "allowTrailingStop": false,
	// "cancelReplaceAllowed": false,
	// "amendAllowed": false,
	// "pegInstructionsAllowed": true,
	// "isSpotTradingAllowed": true,
	// "isMarginTradingAllowed": true,

	private String baseAsset;

	private int baseAssetPrecision;

	private int baseCommissionPrecision, quoteCommissionPrecision;

	private List<SymbolFilter> filters;

	private boolean icebergAllowed;

	private boolean isMarginTradingAllowed, isSpotTradingAllowed;

	private boolean ocoAllowed, opoAllowed, otoAllowed;

	private List<OrderType> orderTypes;

	private String quoteAsset;

	private boolean quoteOrderQtyMarketAllowed;

	private int quotePrecision;

	private SymbolStatus status;

	public String getBaseAsset()
	{
		return baseAsset;
	}


	public Integer getBaseAssetPrecision()
	{
		return baseAssetPrecision;
	}


	public int getBaseCommissionPrecision()
	{
		return baseCommissionPrecision;
	}


	public List<SymbolFilter> getFilters()
	{
		return filters;
	}


	public List<OrderType> getOrderTypes()
	{
		return orderTypes;
	}


	public String getQuoteAsset()
	{
		return quoteAsset;
	}


	public int getQuoteCommissionPrecision()
	{
		return quoteCommissionPrecision;
	}


	public Integer getQuotePrecision()
	{
		return quotePrecision;
	}


	public SymbolStatus getStatus()
	{
		return status;
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


	public boolean isOpoAllowed()
	{
		return opoAllowed;
	}


	public boolean isOtoAllowed()
	{
		return otoAllowed;
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


	public void setBaseAssetPrecision(int baseAssetPrecision)
	{
		this.baseAssetPrecision = baseAssetPrecision;
	}


	public void setBaseAssetPrecision(Integer baseAssetPrecision)
	{
		this.baseAssetPrecision = baseAssetPrecision;
	}


	public void setBaseCommissionPrecision(int baseCommissionPrecision)
	{
		this.baseCommissionPrecision = baseCommissionPrecision;
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


	public void setMarginTradingAllowed(boolean isMarginTradingAllowed)
	{
		this.isMarginTradingAllowed = isMarginTradingAllowed;
	}


	public void setOcoAllowed(boolean ocoAllowed)
	{
		this.ocoAllowed = ocoAllowed;
	}


	public void setOpoAllowed(boolean opoAllowed)
	{
		this.opoAllowed = opoAllowed;
	}


	public void setOrderTypes(List<OrderType> orderTypes)
	{
		this.orderTypes = orderTypes;
	}


	public void setOtoAllowed(boolean otoAllowed)
	{
		this.otoAllowed = otoAllowed;
	}


	public void setQuoteAsset(String quoteAsset)
	{
		this.quoteAsset = quoteAsset;
	}


	public void setQuoteCommissionPrecision(int quoteCommissionPrecision)
	{
		this.quoteCommissionPrecision = quoteCommissionPrecision;
	}


	public void setQuoteOrderQtyMarketAllowed(boolean quoteOrderQtyMarketAllowed)
	{
		this.quoteOrderQtyMarketAllowed = quoteOrderQtyMarketAllowed;
	}


	public void setQuotePrecision(int quotePrecision)
	{
		this.quotePrecision = quotePrecision;
	}


	public void setQuotePrecision(Integer quotePrecision)
	{
		this.quotePrecision = quotePrecision;
	}


	public void setSpotTradingAllowed(boolean isSpotTradingAllowed)
	{
		this.isSpotTradingAllowed = isSpotTradingAllowed;
	}


	public void setStatus(SymbolStatus status)
	{
		this.status = status;
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
