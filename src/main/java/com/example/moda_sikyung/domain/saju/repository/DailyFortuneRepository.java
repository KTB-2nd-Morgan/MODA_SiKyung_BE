package com.example.moda_sikyung.domain.saju.repository;

import com.example.moda_sikyung.domain.saju.entity.DailyFortune;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DailyFortuneRepository extends JpaRepository<DailyFortune, Integer> {
}
