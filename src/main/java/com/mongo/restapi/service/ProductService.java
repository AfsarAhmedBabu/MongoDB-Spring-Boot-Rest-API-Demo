package com.mongo.restapi.service;

import com.mongo.restapi.model.Product;
import com.mongo.restapi.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product saveProduct(Product product) {
       return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product getProductByName(String productName) {
        return productRepository.findByProductName(productName);
    }

    public void removeProduct(Long id) {
        productRepository.deleteById(id);
    }

}
