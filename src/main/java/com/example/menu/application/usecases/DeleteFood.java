package com.example.menu.application.usecases;

import com.example.menu.domain.entities.Food;
import com.example.menu.domain.errors.NotFoundException;
import com.example.menu.domain.repositories.FoodRepository;
import com.example.menu.domain.usecases.DeleteFoodUseCase;
import org.springframework.stereotype.Service;

@Service
public class DeleteFood implements DeleteFoodUseCase {

    final FoodRepository foodRepository;

    public DeleteFood(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public void deleteFood(Integer id){
        Food verify = foodRepository.show(id);
        if(verify == null) throw new NotFoundException();
        foodRepository.delete(id);
    }
}
