package com.example.moda_sikyung.domain.saju.service;

import com.example.moda_sikyung.domain.saju.entity.Saju;
import com.example.moda_sikyung.domain.saju.enums.Gender;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
@RequiredArgsConstructor
public class SajuService {
    public String analyze(Saju saju) {
        String base = String.format(
                "당신의 생년월일은 %s이고, 출생 시간은 %s입니다. ",
                saju.getBirthDate(), saju.getBirthTime()
        );

        String genderPart = saju.getGender() == Gender.MALE ?
                "오늘은 도전정신이 필요한 날이에요. " :
                "오늘은 감성이 풍부해지는 날이에요. ";

        String timePart = getTimeFortune(saju.getBirthTime());

        return base + genderPart + timePart;
    }

    private String getTimeFortune(LocalTime birthTime) {
        int hour = birthTime.getHour();
        if (hour >= 23 || hour < 1) return "야자시 출생자는 직관이 날카롭고 오늘 좋은 아이디어가 떠오를 수 있어요.";
        else if (hour >= 1 && hour < 3) return "축시 출생자는 안정과 휴식이 필요한 하루입니다.";
        else if (hour >= 3 && hour < 5) return "인시 출생자는 새로운 인연을 만날 기회가 있어요.";
        else if (hour >= 5 && hour < 7) return "묘시 출생자는 집중력이 좋아 중요한 결정을 내리기 좋아요.";
        else if (hour >= 7 && hour < 9) return "진시 출생자는 주변의 도움을 받을 수 있는 날이에요.";
        else if (hour >= 9 && hour < 11) return "사시 출생자는 대외 활동에 운이 따르니 활발히 움직이세요.";
        else if (hour >= 11 && hour < 13) return "오시 출생자는 창의력이 발휘되는 하루입니다.";
        else if (hour >= 13 && hour < 15) return "미시 출생자는 감정 조절에 유의하세요.";
        else if (hour >= 15 && hour < 17) return "신시 출생자는 재물운이 따라줄 수 있어요.";
        else if (hour >= 17 && hour < 19) return "유시 출생자는 오래된 관계에서 변화가 생길 수 있습니다.";
        else if (hour >= 19 && hour < 21) return "술시 출생자는 가족과의 시간이 중요한 날입니다.";
        else return  "해시 출생자는 오늘 하루 차분히 마무리하는 것이 좋겠어요.";
    }
}
