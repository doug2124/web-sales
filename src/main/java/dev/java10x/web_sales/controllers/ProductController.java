package dev.java10x.web_sales.controllers;

import dev.java10x.web_sales.services.ProductServices;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import dev.java10x.web_sales.models.ProductModel;
import java.util.List;
import dev.java10x.web_sales.repositories.*;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.Map;
@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductServices productServices;

    public ProductController(ProductServices productServices) {
        this.productServices = productServices;
    }
    @GetMapping
    public List<ProductModel> getAll() {
        return productServices.getAll();
    }

    @PostMapping
    public ProductModel save(@RequestBody ProductModel entity) {
        return productServices.save(entity);
    }

    @PutMapping("/{id}")
    public ProductModel update(@PathVariable Long id, @RequestBody ProductModel product) { 
        return productServices.update(id, product); }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        productServices.delete(id);
    }
   @PatchMapping("/{id}")
    public ProductModel patch(@PathVariable Long id, @RequestBody Map<String, Object> fields) {
        return productServices.patch(id, fields);
    }
    

}
