package dev.java10x.web_sales.controllers;

import dev.java10x.web_sales.services.ProductServices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import dev.java10x.web_sales.models.ProductModel;
import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }
    @GetMapping
    public List<ProductModel> getAll(@RequestParam String param) {
        return productServices.getAll(param);
    }

    @PostMapping
    public ProductModel save(@RequestBody ProductModel entity) {
        return productServices.save(entity);
    }
    
    

}
