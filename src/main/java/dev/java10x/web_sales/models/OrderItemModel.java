package dev.java10x.web_sales.models;

import jakarta.persistence.*;
import lombok.*;
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
    private double price;
}
