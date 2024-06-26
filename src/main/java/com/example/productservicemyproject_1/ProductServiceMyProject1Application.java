package com.example.productservicemyproject_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class ProductServiceMyProject1Application {

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceMyProject1Application.class, args);
    }

}
