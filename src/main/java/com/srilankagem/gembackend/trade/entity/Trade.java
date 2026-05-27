package com.srilankagem.gembackend.trade.entity;


import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "trades")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Trade {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    private String tradeNumber;

    @OneToMany(mappedBy = "trade" , cascade = CascadeType.ALL, orphanRemoval = true) // connected to     private Trade trade;    in TradeItem
    @Builder.Default
    private List<TradeItem> items = new ArrayList<>();

    @Column(nullable = false)
    @Builder.Default
    private BigDecimal subtotal = BigDecimal.ZERO;

    @Column(nullable = false)
    @Builder.Default
    private BigDecimal certificationFee = BigDecimal.ZERO;

    @Column(nullable = false)
    @Builder.Default
    private BigDecimal totalAmount = BigDecimal.ONE;

    @Column(length = 500)
    private String shippingAddress;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;


    public void addItems(TradeItem item) {
        items.add(item);
    }

    public void removeItem(TradeItem item) {
        items.remove(item);

    }

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = LocalDateTime.now();
    }



}
