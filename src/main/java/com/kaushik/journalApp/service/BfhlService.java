package com.kaushik.journalApp.service;

import com.kaushik.journalApp.dto.BfhlRequestDto;
import com.kaushik.journalApp.dto.BfhlResponseDto;

public interface BfhlService {
    BfhlResponseDto process(BfhlRequestDto requestDto);
}
