package com.mongo.restapi.controller;

import com.mongo.restapi.model.Product;
import com.mongo.restapi.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/save-product")
    public ResponseEntity<?> saveUpdateProduct(@RequestBody Product product) {
        Product savedProduct = productService.saveProduct(product);
        return new ResponseEntity<Product>(savedProduct, HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-products")
    public ResponseEntity<List<Product>> getAllProduct() {
        return new ResponseEntity<List<Product>>(productService.getAllProducts(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/get-product-by-name")
    public ResponseEntity<Product> getProductByName(String productName) {
        return new ResponseEntity<Product>(productService.getProductByName(productName), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/delete-product")
    public ResponseEntity<String> deleteProduct(@RequestBody Long id) {
        productService.removeProduct(id);
        return new ResponseEntity<String>("Product Deleted", HttpStatus.ACCEPTED);
    }

}
