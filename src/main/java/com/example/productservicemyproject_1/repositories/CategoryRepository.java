package com.example.productservicemyproject_1.repositories;

import com.example.productservicemyproject_1.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    Category save(Category category);
    Optional<Category> findById(Long aLong);
}
