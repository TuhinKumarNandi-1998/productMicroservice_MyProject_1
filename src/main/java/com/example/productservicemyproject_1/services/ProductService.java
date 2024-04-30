package com.example.productservicemyproject_1.services;

import com.example.productservicemyproject_1.Exceptions.ProductNotFoundException;
import com.example.productservicemyproject_1.models.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getAllProducts();

    public Product getAProduct(Long id) throws ProductNotFoundException;

    public List<Product> getInCategory(String name);

    public Product addANewProduct(Product product);

    public Product replaceAProduct(Long id, Product product) throws ProductNotFoundException;

    public Product updateAProduct(Long id, Product product) throws ProductNotFoundException;

    public void deleteAProduct(Long id);
}
