package dev.java10x.web_sales.services;

import org.springframework.stereotype.Service;
import dev.java10x.web_sales.repositories.*;
import java.util.*;
import dev.java10x.web_sales.models.*;
import dev.java10x.web_sales.dtos.*;
import dev.java10x.web_sales.enumerates.*;
@Service
public class OrderServices {
    private final OrderRepository orderRepository;
    private final ProductRepository productRepository;
    public OrderServices(OrderRepository orderRepository, ProductRepository productRepository) {
        this.orderRepository = orderRepository;
        this.productRepository = productRepository;
    }
    public List<OrderModel> getAll(){
        return orderRepository.findAll();
    }
    public OrderModel create(OrderModel entity){
        OrderModel NewOrder= new OrderModel();//から注文作成
        NewOrder.set(OrderStatus.PENDING);//その注文の状態をPENDINGにする

        List<OrderItemModel> items= entity.getItems();//注文に含まれる商品を取得
        double total=0;

        for(OrderItemModel item: items){
            ProductModel product = productRepository.findById(item.getId()).orElseThrow(()
                    ->new RuntimeException("Product not found"));
            OrderItemModel orderItem= new OrderItemModel();
            orderItem.setOrder(NewOrder);
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            total+=item.getPrice()*item.getQuantity();
            orderItem.setTotal(total);
            item.add(items);
        }

       return orderRepository.save(NewOrder);
    }
    public void delete(Long id){
        orderRepository.deleteById(id);
    }
}
