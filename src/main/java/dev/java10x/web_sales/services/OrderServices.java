package dev.java10x.web_sales.services;

import org.springframework.stereotype.Service;
import dev.java10x.web_sales.repositories.*;
import java.util.*;
import dev.java10x.web_sales.models.*;
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
        OrderModel newOrder= new OrderModel();                                                          //から注文作成
        newOrder.setStatus(OrderStatus.PENDING);                                                        //その注文の状態をPENDINGにする

        List<OrderItemModel> items= new ArrayList<>();                                                  //注文に含まれる商品を取得
        double total=0;

        for(OrderItemModel item: entity.getItems()){                                                    //各商品を注文にいれる
            ProductModel product = productRepository.findById(item.getProduct().getId()).orElseThrow(()//DBにある商品の中に入力されたの商品を検索
                    ->new RuntimeException("Product not found"));                                       //何もなかったらこのメッセージを表示
            OrderItemModel orderItem= new OrderItemModel();                                             //商品オブジェクト作成
            orderItem.setOrder(newOrder);
            orderItem.setProduct(product);
            orderItem.setPrice(product.getPrice());
            orderItem.setQuantity(item.getQuantity());

            double subtotal= product.getPrice()*item.getQuantity();
            total+=subtotal;
            orderItem.setTotal(subtotal);
            items.add(orderItem);
        }
        newOrder.setItems(items);
        newOrder.setTotalPrice(total);
       return orderRepository.save(newOrder);
    }
    public void delete(Long id){
        orderRepository.deleteById(id);
    }
}
