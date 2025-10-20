package com.tradeport.catalog.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "products")
public class Product {
    @Id
    private String productID;
    private String productCode;
    private String manufacturerID;
    private String productName;
    private String description;
    private String category;
    private double wholesalePrice;
    private double retailPrice;
    private int quantity;
    private String retailCurrency;
    private String wholeSaleCurrency;
    private double shippingCost;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
    private boolean isActive;
    private List<ProductImage> productImage;
}
