package com.example.productservicemyproject_1;

import com.example.productservicemyproject_1.models.Category;
import com.example.productservicemyproject_1.models.Product;
import com.example.productservicemyproject_1.repositories.CategoryRepository;
import com.example.productservicemyproject_1.repositories.ProductRepository;
import com.example.productservicemyproject_1.repositories.Projections.ProductProjectionsWithIDandTitle;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProductServiceMyProject1ApplicationTests {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryRepository categoryRepository;
    @Test
    void contextLoads() {

    }

    @Test
    @Transactional
    @Commit
    public void checkingTheHQL() {
//        Product product = productRepository.fetchingMyProjects();
//
//        List<ProductProjectionsWithIDandTitle> projections = productRepository.fetchMyProjectsWithIDAndTile(5L);
//
//        for(ProductProjectionsWithIDandTitle projections1 : projections) {
//            System.out.println(projections1.getId()+" || "+projections1.getTitle());
//        }
//
//        List<Product> products = productRepository.fetchProjectAsTheQuery(5L);

       Optional<Category> category = categoryRepository.findById(2L);

       //now I need the details of the product of the above category
        if(true) {
            Category category1 = category.get();

            List<Product> products = category1.getProducts();

            String s = products.get(0).getImageURL();
        }
    }

}
