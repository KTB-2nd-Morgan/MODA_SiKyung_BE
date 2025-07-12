package com.example.moda_sikyung.domain.saju.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Table(
        uniqueConstraints = {
                @UniqueConstraint(columnNames = {"date", "saju_id"})
        }
)
@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class DailyFortune {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate date; // "오늘" 날짜

    @Column(nullable = false)
    @Lob
    private String fortuneSummary;  // 카드 해석 결과 or AI 해석 요약

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saju_id")
    private Saju saju;

    @ElementCollection
    private List<String> recommendedSongs; // 추천된 곡 ID or 이름 리스트
}
