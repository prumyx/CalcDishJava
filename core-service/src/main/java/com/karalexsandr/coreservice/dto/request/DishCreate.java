package com.karalexsandr.coreservice.dto.request;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;


@Data
public class DishCreate {
    private LocalDate date;
    private LocalTime time;
    private List<Long> meals;

    public DishCreate(LocalDate date, LocalTime time, List<Long> meals) {
        this.date = date;
        this.time = time;
        this.meals = meals;
    }
}
