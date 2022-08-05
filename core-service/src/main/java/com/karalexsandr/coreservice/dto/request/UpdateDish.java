package com.karalexsandr.coreservice.dto.request;

import lombok.Data;

import java.util.List;

@Data
public class UpdateDish {
    private Long id;
    private List<Long> meals;


}
