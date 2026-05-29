package com.srilankagem.gembackend.trade.dto;

import jakarta.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@NoArgsConstructor
public class TradeRequest {

    @NotNull(message = "Gemstone Id is required")
    private Long gemId;

    @NotNull(message = "Trade Amount is required")
    private BigDecimal tradeAmount;

    @NotNull(message = "Trade Date is required")
    private LocalDate tradeDate;

    private String tradeRemarks;

    @NotNull(message = "Trade Type is required")
    private String tradeType;

}