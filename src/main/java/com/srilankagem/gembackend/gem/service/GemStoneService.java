package com.srilankagem.gembackend.gem.service;

import com.srilankagem.gembackend.gem.dto.GemStoneRequest;
import com.srilankagem.gembackend.gem.dto.GemStoneResponse;
import com.srilankagem.gembackend.gem.models.GemStone;
import com.srilankagem.gembackend.gem.repository.GemStoneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GemStoneService {

    private final GemStoneRepository gemStoneRepo;

    public Page<GemStoneResponse> getAllGemStones(Pageable pageable) {

//      return gemStoneRepo.findByActiveTrue(pageable).map(item ->toResponse(item));
        return gemStoneRepo.findByActiveTrue(pageable).map(this::toResponse);
    }

    public GemStoneResponse gemStoneResponse(GemStoneRequest request) {

        GemStone gemStone = GemStone.builder()
                .gemCode(request.getGemCode())
                .type(request.getType())
                .origin(request.getOrigin())
                .caratWeight(request.getCaratWeight())
                .description(request.getDescription())
                .stockQuantity(request.getStockQuantity())
                .color(request.getColor())
                .treatment(request.getTreatment())
                .pricePerCarat(request.getPricePerCarat())
                .build();
    }

    private GemStoneResponse toResponse(GemStone gemStone) {
        return GemStoneResponse.builder()
                .id(gemStone.getId())
                .gemCode(gemStone.getGemCode())
                .type(gemStone.getType())
                .color(gemStone.getColor())
                .caratWeight(gemStone.getCaratWeight())
                .origin(gemStone.getOrigin())
                .treatment(gemStone.getTreatment())
                .pricePerCarat(gemStone.getPricePerCarat())
                .stockQuantity(gemStone.getStockQuantity())
                .description(gemStone.getDescription())
                .certified(gemStone.isCertified())
                .createdAt(gemStone.getCreatedAt())
                .updatedAt(gemStone.getUpdatedAt()).build();
    }
}
