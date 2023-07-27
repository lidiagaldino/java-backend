package com.example.menu.domain.usecases;

import com.example.menu.domain.entities.Food;

public interface UpdateFoodUseCase {
    Food updateFood(Integer id, Food food);
}
