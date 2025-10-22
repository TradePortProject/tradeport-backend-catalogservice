package com.tradeport.catalog.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Document(collection = "products")
public class Product {

    @Id
    @Field("productID")
    private String productID;

    @Field("productCode")
    private String productCode;

    @Field("manufacturerID")
    private String manufacturerID;

    @Field("productName")
    private String productName;

    @Field("description")
    private String description;

    @Field("category")
    private String category;

    @Field("wholesalePrice")
    private double wholesalePrice;

    @Field("retailPrice")
    private double retailPrice;

    @Field("quantity")
    private int quantity;

    @Field("retailCurrency")
    private String retailCurrency;

    @Field("wholeSaleCurrency")
    private String wholeSaleCurrency;

    @Field("shippingCost")
    private double shippingCost;

    @Field("createdOn")
    private LocalDateTime createdOn;

    @Field("updatedOn")
    private LocalDateTime updatedOn;

    @Field("isActive")
    private boolean active;

    @Field("productImage")
    private List<ProductImage> productImage;
}
