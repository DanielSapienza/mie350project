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
@Table(name = "UserProfile_E")
public class User {
    @Id 
    @NotEmpty
    private int Client_ID;

    @NotEmpty
    private String First_Name;

    @NotEmpty
    private String Last_Name;

    @NotEmpty
    private int Age;

    @NotEmpty
    private float Height;

    @NotEmpty
    private float Weight;

    public User(int Client_ID, String First_Name, String Last_Name, int Age, float Height, float Weight){
        this.Client_ID = Client_ID;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Age = Age;
        this.Height = Height;
        this.Weight = Weight;
    }

}
