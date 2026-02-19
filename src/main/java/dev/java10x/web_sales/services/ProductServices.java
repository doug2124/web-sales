package dev.java10x.web_sales.services;
import org.springframework.stereotype.Service;
import dev.java10x.web_sales.repositories.ProductRepository;
import dev.java10x.web_sales.models.ProductModel;
import java.util.List;
@Service
public class ProductServices {
    private final ProductRepository productRepository;

    public ProductServices(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<ProductModel> getAll(String param) {
        return productRepository.findAll();
    }

    public ProductModel save(ProductModel entity) {
        return productRepository.save(entity);
    }

}
