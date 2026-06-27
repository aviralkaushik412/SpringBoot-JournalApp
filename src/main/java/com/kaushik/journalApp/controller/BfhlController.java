package com.kaushik.journalApp.controller;

import com.kaushik.journalApp.dto.BfhlRequestDto;
import com.kaushik.journalApp.dto.BfhlResponseDto;
import com.kaushik.journalApp.service.BfhlService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {
    private final BfhlService bfhlService;

    public BfhlController(BfhlService bfhlService) {
        this.bfhlService = bfhlService;
    }

    @PostMapping
    public ResponseEntity<BfhlResponseDto> process(@RequestBody BfhlRequestDto requestDto) {
        return ResponseEntity.ok(bfhlService.process(requestDto));
    }
}
