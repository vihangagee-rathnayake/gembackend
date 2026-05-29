package com.srilankagem.gembackend.trade.dto;

import com.srilankagem.gembackend.gem.models.GemStone;
import com.srilankagem.gembackend.trade.entity.TradeItem;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class TradeItemRequest {
    @NotNull(message = "Gemstone Id is required")
    private Long gemId;
    @NotNull(message = "Quantity is required")
    @Min(value = 1, message = "Quantity should be greater than or equal to 1")
    @Max(value = 100, message = "Quantity should be less than or equal to 100")
    private Integer quantity;

    public static TradeItem toEntity(TradeItemRequest request) {
        return TradeItem.builder()
                .stone(new GemStone(request.getGemId()))
                .quantity(request.getQuantity())
                .build();
    }
}