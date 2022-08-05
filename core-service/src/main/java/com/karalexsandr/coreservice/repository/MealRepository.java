package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Meal;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MealRepository extends JpaRepository<Meal, Long> {
}