package dev.java10x.web_sales.services;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import dev.java10x.web_sales.repositories.ProductRepository;
import dev.java10x.web_sales.models.ProductModel;
import java.util.*;
@Service
public class ProductServices {
    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> getAll() {
        return productRepository.findAll();
    }

    public ProductModel save(ProductModel entity) {
        return productRepository.save(entity);
    }
    public ProductModel update(Long id, ProductModel entity) {
        return productRepository.findById(id).map(procuct -> {
            procuct.setName(entity.getName());
            procuct.setPrice(entity.getPrice());
            procuct.setQuantity(entity.getQuantity());
            return productRepository.save(procuct);
        }).orElseGet(() -> {
            entity.setId(id);
            return productRepository.save(entity);
        });
    }
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
    public ProductModel patch(Long id, Map<String,Object>entity) {
        ProductModel product = productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
            entity.forEach((key, value) -> {
                switch (key) {
                    case "name"->product.setName((String)value);
                    case "price"->product.setPrice((Double)value);
                    case "quantity"->product.setQuantity((Integer)value);
                }
            });
            return productRepository.save(product);
        }
}
