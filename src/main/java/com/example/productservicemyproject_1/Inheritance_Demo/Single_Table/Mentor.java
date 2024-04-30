package com.example.productservicemyproject_1.Inheritance_Demo.Single_Table;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@DiscriminatorValue(value = "1")
public class Mentor extends User {
    private double avg_rating;
    private String company; 
}
