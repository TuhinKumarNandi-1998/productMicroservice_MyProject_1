package com.example.productservicemyproject_1.controllers;

import com.example.productservicemyproject_1.models.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @GetMapping()
    public List<Category> getAllCategory()   {
        return new ArrayList<>();
    }
}
