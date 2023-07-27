package com.example.menu.domain.entities;

import com.example.menu.domain.errors.BadRequestException;
import lombok.Getter;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Float.isNaN;

@Getter
public class Food {
    private Integer id = null;
    private String title;
    private String image;
    private Integer price;

    public Food(Integer id, String title, String image, Integer price){
        this.id = id;
        this.price = price;
        this.image = image;
        this.title = title;
    }

    public Food(Food food) {
        validate(food.getTitle(), food.getImage(), food.getPrice());
        this.title = food.getTitle();
        this.price = food.getPrice();
        this.image = food.getImage();

    }

    public Food() {

    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void validate(String title, String image, Integer price){
        ArrayList<String> errors = new ArrayList<>();
        if(title == null || title.trim().isEmpty()) errors.add("TITLE_REQUIRED");
        if(image == null) errors.add("IMAGE_REQUIRED");
        try {
            assert image != null;
            new URL(image);
        } catch (MalformedURLException e){
            errors.add("IMAGE_MUST_BE_URL");
        }
        if(price == null) errors.add("PRICE_REQUIRED");

        if(!errors.isEmpty()) throw new BadRequestException(errors.toString());
    }
}
