package com.example.menu.controller;

import com.example.menu.application.usecases.*;
import com.example.menu.domain.entities.Food;
import com.example.menu.domain.errors.BadRequestException;
import com.example.menu.domain.errors.NotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    final GetAllFoods getAllFoods;
    final SaveFood saveFood;
    final UpdateFood updateFood;
    final DeleteFood deleteFood;
    final FindFoodById findFoodById;

    FoodController(GetAllFoods getAllFoods, SaveFood saveFood, UpdateFood updateFood, DeleteFood deleteFood, FindFoodById findFoodById){
        this.getAllFoods = getAllFoods;
        this.saveFood = saveFood;
        this.updateFood = updateFood;
        this.deleteFood = deleteFood;
        this.findFoodById = findFoodById;
    }

    @GetMapping
    public ResponseEntity<Object> getAll(){
        try{
            return ResponseEntity.status(200).body(getAllFoods.getAll());
        }catch (NotFoundException e){
            return  ResponseEntity.status(404).body(e.getMessage());
        }

    }

    @PostMapping
    public ResponseEntity<Object> save(@RequestBody Food food){
        try {
            return ResponseEntity.status(201).body(saveFood.saveFood(food));
        }catch (BadRequestException e){
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable(value = "id") Integer id, @RequestBody Food food){
        try {
            return ResponseEntity.status(200).body(updateFood.updateFood(id, food));
        } catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        } catch (BadRequestException e) {
            return ResponseEntity.status(400).body(e.getMessage());
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable(value = "id") Integer id) {
        try{
            deleteFood.deleteFood(id);
            return ResponseEntity.status(201).body("SUCCESS");
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> show(@PathVariable(value = "id")Integer id){
        try {
            return ResponseEntity.status(200).body(findFoodById.find(id));
        }catch (NotFoundException e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }
}
