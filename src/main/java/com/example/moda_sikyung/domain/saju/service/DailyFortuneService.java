package com.example.moda_sikyung.domain.saju.service;

import com.example.moda_sikyung.domain.saju.dto.DailyFortuneDTO;
import com.example.moda_sikyung.domain.saju.entity.DailyFortune;
import com.example.moda_sikyung.domain.saju.entity.Saju;
import com.example.moda_sikyung.domain.saju.enums.Gender;
import com.example.moda_sikyung.domain.saju.repository.DailyFortuneRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DailyFortuneService {
    private final DailyFortuneRepository dailyFortuneRepository;
    private final SajuService sajuService;
//    private final SongRecommendationService songRecommendationService;

    public DailyFortuneDTO getDailyFortune(LocalDate birthDate, String birthTime, Gender gender) {
        if (birthDate == null || birthTime == null || gender == null) {
            throw new IllegalArgumentException("비로그인 사용자는 생년월일, 시간, 성별을 입력해야 합니다.");
        }
        Saju saju = Saju.builder()
                .birthDate(birthDate)
                .birthTime(birthTime)
                .gender(gender)
                .build();

        LocalDate today = LocalDate.now();
//        Optional<DailyFortune> cached = dailyFortuneRepository.findByDate(today);

        String summary = sajuService.analyze(saju);
//        List<String> songs = songRecommendationService.recommendSongs(summary);
        DailyFortune newFortune = DailyFortune.builder()
                .date(today)
                .fortuneSummary(summary)
//                .recommendedSongs(songs)
                .build();

        dailyFortuneRepository.save(newFortune);

        return new DailyFortuneDTO(
                newFortune.getDate(),
                newFortune.getFortuneSummary()
        );

    }

}
