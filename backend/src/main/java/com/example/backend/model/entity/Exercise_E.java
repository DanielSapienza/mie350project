package com.example.backend.model.entity;

import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;

public class Exercise_E {

    @Id
    @NotEmpty
    private int Exercise_Id;
}
