package com.tradeport.catalog.service;

import com.tradeport.catalog.model.Product;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> extractNestedProducts() {
        // ✅ FIX: Use an empty Query instead of null
        Document wrapper = mongoTemplate.findOne(new Query(), Document.class, "products");
        if (wrapper == null || !wrapper.containsKey("product")) {
            return List.of();
        }

        List<Document> productDocs = (List<Document>) wrapper.get("product");
        return productDocs.stream()
                .map(doc -> mongoTemplate.getConverter().read(Product.class, doc))
                .collect(Collectors.toList());
    }

    public Product getProductById(String id) {
        return extractNestedProducts().stream()
                .filter(p -> p.getProductID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product saveProduct(Product product) {
        // ⚠️ Note: This will insert a new top-level document, not into the nested array
        return mongoTemplate.save(product, "products");
    }
}
