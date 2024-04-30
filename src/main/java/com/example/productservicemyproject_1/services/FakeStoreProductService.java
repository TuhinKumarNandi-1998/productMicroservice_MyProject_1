package com.example.productservicemyproject_1.services;

import com.example.productservicemyproject_1.Exceptions.ProductNotFoundException;
import com.example.productservicemyproject_1.dtos.FakeStoreProductDTO;
import com.example.productservicemyproject_1.models.Category;
import com.example.productservicemyproject_1.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service("FakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private RestTemplate restTemplate;

    @Autowired
    public FakeStoreProductService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Product convert(FakeStoreProductDTO fakeStoreProductDTO) {
        Product product = new Product();
        product.setId(fakeStoreProductDTO.getId());
        product.setTitle(fakeStoreProductDTO.getTitle());
        product.setPrice(fakeStoreProductDTO.getPrice());
        product.setDescription(fakeStoreProductDTO.getDescription());
        product.setImageURL(fakeStoreProductDTO.getImageURL());
        product.setCategory(new Category());
        product.getCategory().setName(fakeStoreProductDTO.getCategory());

        return product;
    }
    @Override
    public List<Product> getAllProducts() {
        FakeStoreProductDTO[] fakeStoreProductDTOS = restTemplate.getForObject("https://fakestoreapi.com/products",
                FakeStoreProductDTO[].class);

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO : fakeStoreProductDTOS) {
            products.add(convert(fakeStoreProductDTO));
        }
        return products;
    }

    @Override
    public Product getAProduct(Long id) throws ProductNotFoundException {
        FakeStoreProductDTO fakeStoreProductDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/"+id,
                FakeStoreProductDTO.class);
        if(fakeStoreProductDTO == null) {
            throw new ProductNotFoundException("Product with id "+id+" not found in DB.");
        }
        return convert(fakeStoreProductDTO);
    }

    @Override
    public List<Product> getInCategory(String name) {
        FakeStoreProductDTO[] fakeStoreProductDTO = restTemplate.getForObject(
                "https://fakestoreapi.com/products/category/"+name,
                FakeStoreProductDTO[].class
        );

        List<Product> products = new ArrayList<>();

        for(FakeStoreProductDTO fakeStoreProductDTO1 : fakeStoreProductDTO) {
            products.add(convert(fakeStoreProductDTO1));
        }
        return products;
    }

    @Override
    public Product addANewProduct(Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setImageURL(product.getImageURL());

        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.postForObject(
                "https://fakestoreapi.com/products",
                fakeStoreProductDTO,
                FakeStoreProductDTO.class);
        return convert(fakeStoreProductDTO1);
    }

    @Override
    public Product replaceAProduct(Long id, Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());
        fakeStoreProductDTO.setTitle(product.getTitle());
        fakeStoreProductDTO.setDescription(product.getDescription());
        fakeStoreProductDTO.setPrice(product.getPrice());
        fakeStoreProductDTO.setCategory(product.getCategory().getName());
        fakeStoreProductDTO.setImageURL(product.getImageURL());

//        ResponseEntity<FakeStoreProductDTO> fakeStoreProductDTO1 = restTemplate.exchange(
//                "https://fakestoreapi.com/products/"+id,
//                HttpMethod.PUT,
//                null,
//                FakeStoreProductDTO.class
//                );

        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO, FakeStoreProductDTO.class);
        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
                new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);
        return convert(fakeStoreProductDTO1);
    }

    @Override
    public Product updateAProduct(Long id, Product product) {
        FakeStoreProductDTO fakeStoreProductDTO = new FakeStoreProductDTO();
        fakeStoreProductDTO.setId(product.getId());

        if(product.getTitle() != null) {
            fakeStoreProductDTO.setTitle(product.getTitle());
        }

        if(product.getDescription() != null) {
            fakeStoreProductDTO.setDescription(product.getDescription());
        }

        if(product.getPrice() != null) {
            fakeStoreProductDTO.setPrice(product.getPrice());
        }

        if(product.getCategory() != null) {
            fakeStoreProductDTO.setCategory(product.getCategory().getName());
        }

        if(product.getImageURL() != null) {
            fakeStoreProductDTO.setImageURL(product.getImageURL());
        }

//        RequestCallback requestCallback = restTemplate.httpEntityCallback(fakeStoreProductDTO, FakeStoreProductDTO.class);
//        HttpMessageConverterExtractor<FakeStoreProductDTO> responseExtractor =
//                new HttpMessageConverterExtractor<>(FakeStoreProductDTO.class, restTemplate.getMessageConverters());
//        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.execute("https://fakestoreapi.com/products/"+id, HttpMethod.PUT, requestCallback, responseExtractor);

        FakeStoreProductDTO fakeStoreProductDTO1 = restTemplate.patchForObject(
                "https://fakestoreapi.com/products/"+id,
                fakeStoreProductDTO,
                FakeStoreProductDTO.class
        );
        return convert(fakeStoreProductDTO1);
    }

    @Override
    public void deleteAProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
    }
}
