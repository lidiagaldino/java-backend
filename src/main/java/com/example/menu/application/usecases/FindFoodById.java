package com.example.menu.application.usecases;

import com.example.menu.domain.entities.Food;
import com.example.menu.domain.errors.NotFoundException;
import com.example.menu.domain.repositories.FoodRepository;
import com.example.menu.domain.usecases.FindFoodByIdUseCase;
import org.springframework.stereotype.Service;

@Service
public class FindFoodById implements FindFoodByIdUseCase {
    final FoodRepository foodRepository;

    public FindFoodById(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public Food find(Integer id){
        Food findFood = foodRepository.show(id);
        if(findFood == null) throw new NotFoundException();
        return findFood;
    }
}
