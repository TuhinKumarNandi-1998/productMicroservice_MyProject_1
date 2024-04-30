package com.example.productservicemyproject_1.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDTO {
    private long id;
    private String title;
    private double price;
    String category;
    String description;
    String imageURL;
}
