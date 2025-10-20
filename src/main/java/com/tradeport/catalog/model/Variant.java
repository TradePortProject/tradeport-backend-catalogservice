package com.tradeport.catalog.model;

import lombok.Data;

@Data
public class Variant {
    private String sku;
    private String color;
    private String size;
    private double price;
}
