package dev.java10x.web_sales.models;

import lombok.*;
import jakarta.persistence.*;
import java.util.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OrderModel{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    
    @OneToMany(mappedBy="order",cascade=CascadeType.ALL)
    private List<OrderItemModel>items;
}