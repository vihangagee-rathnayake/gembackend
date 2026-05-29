package com.srilankagem.gembackend.trade.service;

import com.srilankagem.gembackend.common.exception.DuplicateResourceException;
import com.srilankagem.gembackend.common.exception.ResourceNotFoundException;
import com.srilankagem.gembackend.trade.dto.TradeItemRequest;
import com.srilankagem.gembackend.trade.dto.TradeRequest;
import com.srilankagem.gembackend.trade.dto.TradeResponse;
import com.srilankagem.gembackend.trade.entity.Trade;
import com.srilankagem.gembackend.trade.repository.TradeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TradeService {
    private final TradeRepository tradeRepository;

    public TradeResponse createTrade(TradeRequest request) {
        if (tradeRepository.existsByTradeNumber(request.getTradeNumber())) {
            throw new DuplicateResourceException("Trade with " + request.getTradeNumber() + " already exists");
        }

        Trade trade = Trade.builder()
                .tradeNumber(request.getTradeNumber())
                .build();

        trade.addItems(TradeItemRequest.toEntity(request.getItems()));

        return toResponse(tradeRepository.save(trade));
    }

    public TradeResponse getTradeById(Long id) {
        Trade trade = tradeRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Trade", id.toString()));
        return toResponse(trade);
    }

    public Page<TradeResponse> getAllTrades(Pageable pageable) {
        return tradeRepository.findAll(pageable).map(this::toResponse);
    }

    private TradeResponse toResponse(Trade trade) {
        return TradeResponse.builder()
                .tradeNumber(trade.getTradeNumber())
                .items(trade.getItems().stream().map(TradeItem::toDto).toList())
                .build();
    }
}