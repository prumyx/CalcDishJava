package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.entity.Dish;
import com.karalexsandr.coreservice.entity.Meal;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class DishDto {
    private Long id;
    private LocalDate date;
    private LocalTime time;
    private List<MealDto> meals;

    public DishDto(Dish dish) {
        this.id = dish.getId();
        this.date = dish.getDate();
        this.time = dish.getTime();
        this.meals = dish.getMeals().stream().map(MealDto::new).collect(Collectors.toList());
    }

    public DishDto(Long id, LocalDate date, LocalTime time, List<MealDto> meals) {
        this.id = id;
        this.date = date;
        this.time = time;
        this.meals = meals;
    }
}
