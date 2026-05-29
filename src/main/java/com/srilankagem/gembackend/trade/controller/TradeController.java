package com.srilankagem.gembackend.trade.controller;

import com.srilankagem.gembackend.trade.dto.TradeRequest;
import com.srilankagem.gembackend.trade.dto.TradeResponse;
import com.srilankagem.gembackend.trade.service.TradeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trade")
public class TradeController {

    private final TradeService tradeService;

    @Autowired
    public TradeController(TradeService tradeService) {
        this.tradeService = tradeService;
    }

    @PostMapping
    public ResponseEntity<TradeResponse> createTrade(@Valid @RequestBody TradeRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(tradeService.createTrade(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TradeResponse> getTradeById(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(tradeService.getTradeById(id));
    }
}