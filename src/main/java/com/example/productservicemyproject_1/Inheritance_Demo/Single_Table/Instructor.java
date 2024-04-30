package com.example.productservicemyproject_1.Inheritance_Demo.Single_Table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@DiscriminatorValue(value = "2")
public class Instructor extends User {
    private double avg_rating;
}
