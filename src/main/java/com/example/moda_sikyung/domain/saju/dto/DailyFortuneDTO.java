package com.example.moda_sikyung.domain.saju.dto;


import java.time.LocalDate;
import java.util.List;

public record DailyFortuneDTO(
        LocalDate date,
        String fortuneSummary
//        List<String> recommendedSongs
) {}
