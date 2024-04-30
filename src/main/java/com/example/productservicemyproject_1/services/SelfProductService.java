package com.example.productservicemyproject_1.services;

import com.example.productservicemyproject_1.Exceptions.ProductNotFoundException;
import com.example.productservicemyproject_1.models.Category;
import com.example.productservicemyproject_1.models.Product;
import com.example.productservicemyproject_1.repositories.CategoryRepository;
import com.example.productservicemyproject_1.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("SelfProductService")
public class SelfProductService implements ProductService {
    private ProductRepository productRepository;
    private CategoryRepository categoryRepository;

    @Autowired
    public SelfProductService(ProductRepository productRepository, CategoryRepository categoryRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product getAProduct(Long id) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id "+id+" not found.");
        }
        Product product = optionalProduct.get();

        return product;
    }

    @Override
    public List<Product> getInCategory(String name) {
        List<Product> productList = productRepository.findByCategory_Name(name);
        return productList;
    }

    @Override
    public Product addANewProduct(Product product) {
        if(product.getCategory().getId() != null) {
            Optional<Category> categoryOptional = categoryRepository.findById(product.getCategory().getId());

            if(categoryOptional.isEmpty()) {
//                Category category = product.getCategory();
//                categoryRepository.save(category);
            }
            else {
                product.setCategory(categoryOptional.get());
            }
        }


        return productRepository.save(product);
    }

    @Override
    public Product replaceAProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id "+id+" not found");
        }
        Product product1 = optionalProduct.get();
        product1.setTitle(product.getTitle());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        product1.setImageURL(product.getImageURL());

        Optional<Category> optionalCategory = categoryRepository.findById(product.getCategory().getId());
        if(optionalCategory.isEmpty()) {
//            Category category = categoryRepository.save(product.getCategory());
//            product1.setCategory(category);
        }
        else {
            //If the category details is also updated along with the product details that information also need to be saved
            optionalCategory.get().setName(product.getCategory().getName());
            Category category = categoryRepository.save(optionalCategory.get());
            product1.setCategory(optionalCategory.get());
        }
        return product1;
    }

    @Override
    public Product updateAProduct(Long id, Product product) throws ProductNotFoundException {
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isEmpty()) {
            throw new ProductNotFoundException("Product with id "+id+" not found");
        }
        Product product1 = optionalProduct.get();
        if(product.getTitle() != null) {
            product1.setTitle(product.getTitle());
        }
        if(product.getDescription() != null) {
            product1.setDescription(product.getDescription());
        }

        if(product.getPrice() != null) {
            product1.setPrice(product.getPrice());
        }

//        if(product.getCategory() != null) {
//            product1.setCategory(product.getCategory());
//        }

        if(product.getImageURL() != null) {
            product1.setImageURL(product.getImageURL());
        }
        return productRepository.save(product1);
    }

    @Override
    public void deleteAProduct(Long id) {
        productRepository.deleteById(id);
    }
}
