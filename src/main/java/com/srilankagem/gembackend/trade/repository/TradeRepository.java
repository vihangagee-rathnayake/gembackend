package com.srilankagem.gembackend.trade.repository;

import com.srilankagem.gembackend.trade.entity.Trade;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TradeRepository extends JpaRepository<Trade, Long> {

    Optional<Trade> findByTradeNumber(String tradeNumber);

    Page<Trade> searchByTradeNumberContains(String searchTerm, Pageable pageable);

}