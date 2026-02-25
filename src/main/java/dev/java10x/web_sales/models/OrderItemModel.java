package dev.java10x.web_sales.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class OrderItemModel {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private OrderModel order;
    @ManyToOne
    private ProductModel product;
    private Integer quantity;
    private double total;
    private double price;

    public void setTotal(double total) {
    }

    public Object getTotal() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getTotal'");
    }
}
