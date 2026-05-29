package com.srilankagem.gembackend.trade.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TradeResponse {
    private Long id;
    private String tradeNumber;
    private Long traderId;
    private String traderName;
    private String tradingPlatform;
    private String location;
    private Double pricePerCarat;
    private Integer quantity;
    private String currency;
    private String paymentMethod;
    private String tradeStatus;
    private String remarks;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}