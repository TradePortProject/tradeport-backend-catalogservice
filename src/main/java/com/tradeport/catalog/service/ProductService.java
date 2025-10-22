package com.tradeport.catalog.service;

import com.tradeport.catalog.model.Product;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Product> extractNestedProducts() {
        Document wrapper = mongoTemplate.findOne(null, Document.class, "products");
        if (wrapper == null || !wrapper.containsKey("product")) {
            return List.of();
        }

        List<Document> productDocs = (List<Document>) wrapper.get("product");
        return productDocs.stream()
                .map(doc -> mongoTemplate.getConverter().read(Product.class, doc))
                .collect(Collectors.toList());
    }

    public Product getProductById(String id) {
        // Optional: search inside nested array manually
        return extractNestedProducts().stream()
                .filter(p -> p.getProductID().equals(id))
                .findFirst()
                .orElse(null);
    }

    public Product saveProduct(Product product) {
        // Optional: flatten and save directly if you restructure MongoDB
        return mongoTemplate.save(product, "products");
    }
}
