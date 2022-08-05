package com.karalexsandr.coreservice.service;

import com.karalexsandr.coreservice.dto.MealDto;
import com.karalexsandr.coreservice.dto.request.MealCreate;
import com.karalexsandr.coreservice.dto.request.UpdateMeal;
import com.karalexsandr.coreservice.entity.Meal;
import com.karalexsandr.coreservice.exception.AppException;
import com.karalexsandr.coreservice.repository.MealRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MealService {
    private final MealRepository mealRepository;

    public Page<MealDto> findAll(Pageable pageable){
        return mealRepository.findAll(pageable).map(MealDto::new);
    }

    public Meal create(MealCreate mealCreateDto){
        Meal meal = new Meal();
        if (mealCreateDto!=null){
            meal.setTitle(mealCreateDto.getTitle());
            meal.setCalories(mealCreateDto.getCalories());
            meal.setWeight(mealCreateDto.getWeight());
            meal.setFats(mealCreateDto.getFats());
            meal.setProteins(mealCreateDto.getProteins());
            meal.setCarbohydrates(mealCreateDto.getCarbohydrates());
            mealRepository.save(meal);
        }
        return meal;
    }

    public List<Meal> findAllById(List<Long> id){
        return mealRepository.findAllById(id);
    }

    public void update(UpdateMeal updateMeal){
        Meal meal = mealRepository.findById(updateMeal.getId())
                .orElseThrow(() ->new AppException("Dish не найдено с ID: " + updateMeal.getId()));
        meal.setTitle(updateMeal.getTitle());
        meal.setWeight(updateMeal.getWeight());
        meal.setCalories(updateMeal.getCalories());
        meal.setFats(updateMeal.getFats());
        meal.setProteins(updateMeal.getProteins());
        meal.setCarbohydrates(updateMeal.getCarbohydrates());
        mealRepository.save(meal);
    }
}
