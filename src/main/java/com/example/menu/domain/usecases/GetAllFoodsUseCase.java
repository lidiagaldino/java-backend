package com.example.menu.domain.usecases;

import com.example.menu.domain.entities.Food;

import java.util.List;

public interface GetAllFoodsUseCase {
    List<Food> getAll();
}
