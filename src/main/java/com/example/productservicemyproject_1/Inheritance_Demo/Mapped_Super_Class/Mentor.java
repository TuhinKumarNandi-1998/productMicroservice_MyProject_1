package com.example.productservicemyproject_1.Inheritance_Demo.Mapped_Super_Class;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "mapped_super_class_Mentor")
public class Mentor extends User {
    private double avg_rating;
    private String company; 
}
