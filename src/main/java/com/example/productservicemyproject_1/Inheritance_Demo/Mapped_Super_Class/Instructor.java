package com.example.productservicemyproject_1.Inheritance_Demo.Mapped_Super_Class;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "mapped_super_class_Instructor")
public class Instructor extends User {
    private double avg_rating;
}
