package com.example.menu.infra.jpa;

import com.example.menu.infra.jpa.model.FoodModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaFoodRepository extends JpaRepository<FoodModel, Integer> {

}
