package com.example.backend.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "Diet_E")

public class Diet {

    @NotEmpty
    private String Name;

    @NotEmpty
    private String Food_Group;

    @NotEmpty
    private float Calories_Per_Serving;

    @NotEmpty
    private float Sugar_Per_Serving;

    @NotEmpty
    private float Protein_Per_Serving;

    @NotEmpty
    private float Carbohydrates_Per_Serving;

    public Diet(String Name, String Food_Group, float Calories_Per_Serving,
                float Sugar_Per_Serving, float Protein_Per_Serving, float Carbohydrates_Per_Serving){
        this.Name = Name;
        this.Food_Group = Food_Group;
        this.Calories_Per_Serving = Calories_Per_Serving;
        this.Sugar_Per_Serving = Sugar_Per_Serving;
        this.Protein_Per_Serving = Protein_Per_Serving;
        this.Carbohydrates_Per_Serving = Carbohydrates_Per_Serving;
    }

}
