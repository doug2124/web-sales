package dev.java10x.web_sales.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import dev.java10x.web_sales.models.ProductModel;

public interface ProductRepository extends JpaRepository<ProductModel, Long> {
    
}
