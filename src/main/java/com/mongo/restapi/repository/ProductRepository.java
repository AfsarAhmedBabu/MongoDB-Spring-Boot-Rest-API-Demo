package com.mongo.restapi.repository;

import com.mongo.restapi.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends MongoRepository<Product, Long> {

    Product findByProductName(String productName);

}
