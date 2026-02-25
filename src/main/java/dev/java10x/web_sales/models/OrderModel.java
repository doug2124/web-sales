package dev.java10x.web_sales.models;
import java.util.List;

import dev.java10x.web_sales.enumerates.OrderStatus;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Setter
@Getter
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
    @Enumerated(EnumType.STRING)
    private OrderStatus status;
    public void set(OrderStatus pending) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'set'");
    }
    
}