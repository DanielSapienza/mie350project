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
@Table(name = "Exercise_E")
public class Exercise {

    @Id
    @NotEmpty
    private int Exercise_Id;

    @NotEmpty
    private String Name;

    @NotEmpty
    private String Muscle_Group;

    @NotEmpty
    private int Repetitions;

    @NotEmpty
    private int Heart_Baets_Per_Min;

    public Exercise(int Exercise_ID, String Name, String Muscle_Group, int Repetitions, int Heart_Baets_Per_Min) {
        this.Exercise_Id = Exercise_ID;
        this.Name = Name;
        this.Muscle_Group = Muscle_Group;
        this.Repetitions = Repetitions;
        this.Heart_Baets_Per_Min = Heart_Baets_Per_Min;
    }
}
