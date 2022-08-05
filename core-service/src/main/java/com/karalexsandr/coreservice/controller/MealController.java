package com.karalexsandr.coreservice.controller;

import com.karalexsandr.coreservice.dto.MealDto;
import com.karalexsandr.coreservice.dto.request.MealCreate;
import com.karalexsandr.coreservice.dto.request.UpdateMeal;
import com.karalexsandr.coreservice.entity.Meal;
import com.karalexsandr.coreservice.service.MealService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/meals")
public class MealController {
    private final MealService mealService;

    @GetMapping
    public Page<MealDto> findAll(
        @RequestParam(defaultValue = "1") Integer page,
        @RequestParam(defaultValue = "5")   Integer size){
        if (page<1){
            page = 1;
        }
        return mealService.findAll(PageRequest.of(page-1,size));
    }

    @PostMapping
    public Meal create(@RequestBody MealCreate mealCreateDto){
        return mealService.create(mealCreateDto);
    }

    @PatchMapping
    public void update(@RequestBody UpdateMeal updateMeal){
        mealService.update(updateMeal);
    }
}
