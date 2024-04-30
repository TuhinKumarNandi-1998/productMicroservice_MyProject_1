package com.example.productservicemyproject_1.Inheritance_Demo.Table_Per_Class;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Table_per_class_Instructor")
public class Instructor extends User {
    private double avg_rating;
}
