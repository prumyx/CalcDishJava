package com.karalexsandr.coreservice.repository;

import com.karalexsandr.coreservice.entity.Dish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DishRepository extends JpaRepository<Dish, Long> {
}