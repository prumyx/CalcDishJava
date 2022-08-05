package com.karalexsandr.coreservice.dto;

import com.karalexsandr.coreservice.entity.Meal;
import lombok.Data;


@Data
public class MealDto {
    private Long id;
    private String title;
    private Float weight;
    private Float calories;
    private Float fats;
    private Float proteins;
    private Float carbohydrates;

    public MealDto(Meal meal) {
        this.id = meal.getId();
        this.title = meal.getTitle();
        this.weight = meal.getWeight();
        this.calories = meal.getCalories();
        this.fats = meal.getFats();
        this.proteins = meal.getProteins();
        this.carbohydrates = meal.getCarbohydrates();
    }

}
