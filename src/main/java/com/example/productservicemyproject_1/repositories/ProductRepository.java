package com.example.productservicemyproject_1.repositories;

import com.example.productservicemyproject_1.models.Product;
import com.example.productservicemyproject_1.repositories.Projections.ProductProjectionsWithIDandTitle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    //Declared Queries
    List<Product> findAll();

    Optional<Product> findById(Long aLong);

    List<Product> findByCategory_Name(String name);

    Product save(Product product);

    void deleteById(Long aLong);

    //HQL Queries
    @Query("select p from Product p where p.id=3")
    Product fetchingMyProjects();

    @Query("select p.id AS id, p.title AS title from Product p where p.id=:id")
    List<ProductProjectionsWithIDandTitle> fetchMyProjectsWithIDAndTile(@Param("id") Long id);

    //Native SQL Queries
    @Query(value = "select * from Product p where p.id=:id",nativeQuery = true)
    List<Product> fetchProjectAsTheQuery(@Param("id") Long id);
    //here also we can do Projections
}
