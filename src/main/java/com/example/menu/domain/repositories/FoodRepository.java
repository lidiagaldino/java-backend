package com.example.menu.domain.repositories;

import com.example.menu.domain.entities.Food;

import java.util.List;

public interface FoodRepository {
    List<Food> getFoods();
    Food save(Food food);

    Food update(Food food);
    void delete(Integer id);
    Food show(Integer id);
}
