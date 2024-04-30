package com.example.productservicemyproject_1.Inheritance_Demo.Joined_Table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity(name = "Joined_Table_Mentor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Mentor extends User {
    private double avg_rating;
    private String company;
}
