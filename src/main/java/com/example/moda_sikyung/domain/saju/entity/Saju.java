package com.example.moda_sikyung.domain.saju.entity;

import com.example.moda_sikyung.domain.saju.enums.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class Saju {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate birthDate;

    @Column(nullable = false)
    private LocalTime birthTime;     // 출생 시각

    @Enumerated(EnumType.STRING)
    private Gender gender;           // 성별 (MALE, FEMALE 등)

    // 연관관계 (1:1 또는 1:N 가능)
    @OneToOne(mappedBy = "saju", cascade = CascadeType.ALL)
    private SajuResult sajuResult;

    @OneToMany(mappedBy = "saju", cascade = CascadeType.ALL)
    private List<DailyFortune>  dailyFortunes;

}
