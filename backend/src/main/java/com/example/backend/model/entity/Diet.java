package com.example.backend.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Diet")
public class Diet {

    @EmbeddedId
    UserMealKey userMealKey;

    @NotEmpty
    private String mealName;

    @NotEmpty
    private float calories;

    @NotEmpty
    private float sugar;

    @NotEmpty
    private float carbs;

    @NotEmpty
    private float protein;

    @NotEmpty
    private float fat;

    public Diet(UserMealKey userMealKey, String mealName, float calories, float sugar, float carbs, float protein, float fat){
        this.userMealKey = userMealKey;
        this.mealName = mealName;
        this.calories = calories;
        this.sugar = sugar;
        this.protein = protein;
        this.carbs = carbs;
        this.fat = fat;
    }

}
