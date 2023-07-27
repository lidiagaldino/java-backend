package com.example.menu.application.usecases;

import com.example.menu.domain.entities.Food;
import com.example.menu.domain.errors.NotFoundException;
import com.example.menu.domain.repositories.FoodRepository;
import com.example.menu.domain.usecases.GetAllFoodsUseCase;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllFoods implements GetAllFoodsUseCase {
    final FoodRepository foodRepository;

    public GetAllFoods(FoodRepository foodRepository) {
        this.foodRepository = foodRepository;
    }

    public List<Food> getAll(){
        List<Food> foods = foodRepository.getFoods();
        if(foods == null) throw new NotFoundException();
        return foods;
    }
}
