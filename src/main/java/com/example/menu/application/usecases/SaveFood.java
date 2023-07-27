package com.example.menu.application.usecases;

import com.example.menu.domain.entities.Food;
import com.example.menu.domain.repositories.FoodRepository;
import com.example.menu.domain.usecases.CreateFoodUseCase;
import org.springframework.stereotype.Service;

@Service
public class SaveFood implements CreateFoodUseCase {
    final FoodRepository foodRepository;

    public SaveFood(FoodRepository foodRepository){
        this.foodRepository = foodRepository;
    }

    public Food saveFood(Food food){
        return foodRepository.save(food);
    }
}
