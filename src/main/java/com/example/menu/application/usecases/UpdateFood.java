package com.example.menu.application.usecases;

import com.example.menu.domain.entities.Food;
import com.example.menu.domain.errors.NotFoundException;
import com.example.menu.domain.repositories.FoodRepository;
import com.example.menu.domain.usecases.UpdateFoodUseCase;
import org.springframework.stereotype.Service;

@Service
public class UpdateFood implements UpdateFoodUseCase {
    final FoodRepository foodRepository;

    public UpdateFood(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food updateFood(Integer id, Food food){
        Food findFood = foodRepository.show(id);
        if(findFood == null) throw new NotFoundException();
        Food instance = new Food(food);
        instance.setId(id);
        return foodRepository.update(instance);
    }
}
