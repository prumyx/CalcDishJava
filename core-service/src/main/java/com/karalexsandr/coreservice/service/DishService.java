package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.dto.DishDto;
import com.karalexsandr.coreservice.dto.request.DishCreate;
import com.karalexsandr.coreservice.dto.request.UpdateDish;
import com.karalexsandr.coreservice.entity.Dish;
import com.karalexsandr.coreservice.entity.Meal;
import com.karalexsandr.coreservice.exception.AppException;
import com.karalexsandr.coreservice.repository.DishRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DishService {
    private final DishRepository dishRepository;
    private final MealService mealService;

    public Page<DishDto> findAll(Pageable pageable){
        return dishRepository.findAll(pageable).map(DishDto::new);
    }

    public void create(DishCreate dto){
        Dish dish = new Dish();
        dish.setDate(dto.getDate());
        dish.setTime(dto.getTime());
        List<Meal> meals = mealService.findAllById(dto.getMeals());
        dish.setMeals(meals);
        dishRepository.save(dish);
    }

    public void update(UpdateDish updateDish){
        Dish dish = dishRepository.findById(updateDish.getId())
                .orElseThrow(() ->new AppException("Dish не найдено с ID: " + updateDish.getId()));
        List<Meal> meals = mealService.findAllById(updateDish.getMeals());
        dish.getMeals().clear();
        dish.setMeals(meals);
        dishRepository.save(dish);
    }

}
