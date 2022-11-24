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
    private Long Client_Id;

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

    @NotEmpty
    private String Password;

    public User(Long Client_Id, String First_Name, String Last_Name, int Age, float Height, float Weight, String Password){
        this.Client_Id = Client_Id;
        this.First_Name = First_Name;
        this.Last_Name = Last_Name;
        this.Age = Age;
        this.Height = Height;
        this.Weight = Weight;
        this.Password = Password;
    }


}
