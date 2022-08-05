package com.karalexsandr.coreservice.controller;

import com.karalexsandr.coreservice.dto.DishDto;
import com.karalexsandr.coreservice.dto.request.DishCreate;
import com.karalexsandr.coreservice.dto.request.UpdateDish;
import com.karalexsandr.coreservice.service.DishService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/dishes")
@RequiredArgsConstructor
public class DishController {
    private final DishService dishService;

    @GetMapping
    public Page<DishDto> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "5") Integer size){
        if (page<1){
            page = 1;
        }
        return dishService.findAll(PageRequest.of(page-1,size));
    }

    @PostMapping
    public void create (@RequestBody DishCreate dto){
        dishService.create(dto);
    }

    @PatchMapping
    public void update(@RequestBody UpdateDish updateDish){
        System.out.println(updateDish);
        dishService.update(updateDish);
    }
}
