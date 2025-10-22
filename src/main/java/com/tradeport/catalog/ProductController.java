package com.tradeport.catalog;

import com.tradeport.catalog.model.Product;
import com.tradeport.catalog.service.ProductService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v2/ProductManagement/GetFilteredProducts")
public class ProductController {
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/GetFilteredProducts/GetFilteredProducts")
    public List<Product> getAll() {
        return service.extractNestedProducts();
    }

    @GetMapping("/GetFilteredProducts/GetFilteredProducts/{id}")
    public Product getById(@PathVariable String id) {
        return service.getProductById(id);
    }

    @PostMapping("/CreateProduct")
    public Product create(@RequestBody Product product) {
        return service.saveProduct(product);
    }
}
