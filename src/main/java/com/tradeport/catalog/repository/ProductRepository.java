package com.tradeport.catalog.repository;

import com.tradeport.catalog.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProductRepository extends MongoRepository<Product, String> {
    // Custom queries if needed
}
