package com.example.menu.domain.usecases;

import com.example.menu.domain.entities.Food;

public interface CreateFoodUseCase {
    Food saveFood(Food food);
}
