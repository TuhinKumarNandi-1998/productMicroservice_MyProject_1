package com.example.productservicemyproject_1.controllers;

import com.example.productservicemyproject_1.Exceptions.ProductNotFoundException;
import com.example.productservicemyproject_1.models.Product;
import com.example.productservicemyproject_1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(@Qualifier("SelfProductService") ProductService productService) {
        this.productService = productService;
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> products = productService.getAllProducts();

        ResponseEntity<List<Product>> response = new ResponseEntity<>(products, HttpStatus.FOUND);
        return response;
    }

    @GetMapping("/{id}")
    public Product getAProduct(@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getAProduct(id);
    }

    @GetMapping("/category/{name}")
    public List<Product> getInCategory(@PathVariable("name") String name) {
        return productService.getInCategory(name);
    }

    @PostMapping()
    public Product addANewProduct(@RequestBody Product product) {
        return productService.addANewProduct(product);
    }

    @PutMapping("/{id}")
    public Product replaceAProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.replaceAProduct(id, product);
    }
    @PatchMapping("/{id}")
    public Product updateAProduct(@PathVariable("id") Long id, @RequestBody Product product) throws ProductNotFoundException {
        return productService.updateAProduct(id, product);
    }

    @DeleteMapping("/{id}")
    public void deleteAProduct(@PathVariable("id") Long id) {
        productService.deleteAProduct(id);
    }
}
