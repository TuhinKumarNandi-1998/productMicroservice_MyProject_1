package com.example.productservicemyproject_1.Inheritance_Demo.Joined_Table;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity(name = "Joined_Table_Instructor")
@PrimaryKeyJoinColumn(name = "user_id")
public class Instructor extends User {
    private double avg_rating;
}
