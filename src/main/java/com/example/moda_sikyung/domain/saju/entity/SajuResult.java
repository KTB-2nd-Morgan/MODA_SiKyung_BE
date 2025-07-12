package com.example.moda_sikyung.domain.saju.entity;

import com.example.moda_sikyung.common.BaseDateTimeEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
public class SajuResult extends BaseDateTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @Lob
    private String content;

    @OneToOne
    @JoinColumn(name = "saju_id")
    private Saju saju;
}
