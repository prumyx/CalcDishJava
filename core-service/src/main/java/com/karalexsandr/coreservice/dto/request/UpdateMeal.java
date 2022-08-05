package com.karalexsandr.coreservice.dto.request;

import lombok.Data;

@Data
public class UpdateMeal {
    private Long id;
    private String title;
    private Float weight;
    private Float calories;
    private Float fats;
    private Float proteins;
    private Float carbohydrates;


}
