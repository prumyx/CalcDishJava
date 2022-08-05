package com.karalexsandr.coreservice.dto.request;

import lombok.Data;

@Data
public class MealCreate {
    private String title;
    private Float weight;
    private Float calories;
    private Float fats;
    private Float proteins;
    private Float carbohydrates;

    public MealCreate(String title, Float weight, Float calories,
                      Float fats, Float proteins, Float carbohydrates) {
        this.title = title;
        this.weight = weight;
        this.calories = calories;
        this.fats = fats;
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
    }
}
