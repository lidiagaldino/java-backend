package com.example.menu.infra.jpa.adapter;

import com.example.menu.infra.jpa.JpaFoodRepository;
import com.example.menu.infra.jpa.model.FoodModel;
import com.example.menu.domain.entities.Food;
import com.example.menu.domain.repositories.FoodRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class JpaFoodRepositoryAdapter implements FoodRepository {
    private final JpaFoodRepository jpaFoodRepository;

    public JpaFoodRepositoryAdapter(JpaFoodRepository jpaFoodRepository){
        this.jpaFoodRepository = jpaFoodRepository;
    }

    @Override
    public List<Food> getFoods() {
        List<FoodModel> foods = jpaFoodRepository.findAll();
        if(foods.isEmpty()) return null;
        return new FoodModel().toFoodList(foods);
    }

    @Override
    public Food save(Food food) {
        FoodModel newFood = new FoodModel(food.getTitle(), food.getImage(), food.getPrice());
        FoodModel savedFood = jpaFoodRepository.save(newFood);
        return savedFood.toFood();
    }

    @Override
    public Food update(Food food) {
        FoodModel model = new FoodModel(food.getId(), food.getTitle(), food.getImage(), food.getPrice());
        FoodModel updatedFood = jpaFoodRepository.save(model);
        return updatedFood.toFood();
    }

    @Override
    public void delete(Integer id) {
        jpaFoodRepository.deleteById(id);
    }

    @Override
    public Food show(Integer id) {
        Optional<FoodModel> food = jpaFoodRepository.findById(id);
        return food.map(FoodModel::toFood).orElse(null);
    }
}
