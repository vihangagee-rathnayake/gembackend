package com.srilankagem.gembackend.gem.controller;

import com.srilankagem.gembackend.gem.dto.GemStoneResponse;
import com.srilankagem.gembackend.gem.service.GemStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/gems")
@RequiredArgsConstructor
public class GemStoneController {

    private final GemStoneService gemStoneService;

    @GetMapping
    public Page<GemStoneResponse> getAllGemStones(@PageableDefault(size = 20, sort = "color")Pageable pageable) {

        return gemStoneService.getAllGemStones(pageable);
    }






}
