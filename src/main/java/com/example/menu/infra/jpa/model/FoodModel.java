package com.example.menu.infra.jpa.model;

import com.example.menu.domain.entities.Food;
import jakarta.persistence.*;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "tbl_food")
@Getter
public class FoodModel {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String image;
    private Integer price;

    public FoodModel(String title, String image, Integer price){
        super();
        this.title = title;
        this.image = image;
        this.price = price;
    }

    public FoodModel() {

    }

    public FoodModel(FoodModel foodModel) {
        this.id = foodModel.id;
        this.price = foodModel.price;
        this.image = foodModel.image;
        this.title = foodModel.title;
    }

    public FoodModel(Integer id, String title, String image, Integer price) {
        this.id = id;
        this.title = title;
        this.image = image;
        this.price = price;
    }


    public Food toFood(){
        return new Food(id, title, image, price);
    }

    public List<Food> toFoodList(List<FoodModel> foodModels) {
        return foodModels.stream().map(foodModel -> new Food(foodModel.id, foodModel.title, foodModel.image, foodModel.price)).collect(Collectors.toList());
    }

    @Override
    public String toString(){
        return "";
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
