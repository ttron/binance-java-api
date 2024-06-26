package com.binance.api.client.domain.account;

import com.binance.api.client.constant.BinanceAPIConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * MarginTransaction information.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MarginTransaction {

  private String tranId;

  public String getTranId() {
    return tranId;
  }

  public void setTranId(String tranId) {
    this.tranId = tranId;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, BinanceAPIConstants.TO_STRING_BUILDER_STYLE)
        .append("transactionId", tranId)
        .toString();
  }
}
