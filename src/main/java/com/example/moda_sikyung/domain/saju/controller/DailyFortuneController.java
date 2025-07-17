package com.example.moda_sikyung.domain.saju.controller;

import com.example.moda_sikyung.common.api.CommonResponse;
import com.example.moda_sikyung.domain.saju.dto.DailyFortuneDTO;
import com.example.moda_sikyung.domain.saju.entity.DailyFortune;
import com.example.moda_sikyung.domain.saju.enums.Gender;
import com.example.moda_sikyung.domain.saju.service.DailyFortuneService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
@RequestMapping("/daily-fortune")
@RequiredArgsConstructor
public class DailyFortuneController {
    private final DailyFortuneService dailyFortuneService;

    @GetMapping
    public CommonResponse<DailyFortuneDTO> getDailyFortune(
            @RequestParam(required = false) LocalDate birthDate,
            @RequestParam(required = false) LocalTime birthTime,
            @RequestParam(required = false) Gender gender
    ) {
        return CommonResponse.onSuccess(dailyFortuneService.getDailyFortune(birthDate, birthTime, gender));
    }
}
