package com.example.productservicemyproject_1.Inheritance_Demo.Table_Per_Class;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "Table_per_class_Mentor")
public class Mentor extends User {
    private double avg_rating;
    private String company; 
}
