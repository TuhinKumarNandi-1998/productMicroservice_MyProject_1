package com.example.productservicemyproject_1.controllers;

import com.example.productservicemyproject_1.Exceptions.ProductNotFoundException;
import com.example.productservicemyproject_1.commons.AuthenticationCommons;
import com.example.productservicemyproject_1.models.Product;
import com.example.productservicemyproject_1.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private ProductService productService;
    private AuthenticationCommons authenticationCommons;

    @Autowired
    public ProductController(@Qualifier("SelfProductService") ProductService productService,
                             AuthenticationCommons authenticationCommons) {
        this.productService = productService;
        this.authenticationCommons = authenticationCommons;
    }
    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        //Now I don't need to manage the authentication here in controller of Product Service
        //It is now been managed by the Authentication server (i.e. my User Service Microservice)
//        if(!authenticationCommons.validateToken(tokenValues)) {
//            return new ResponseEntity<>(HttpStatus.FORBIDDEN);
//        }
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
