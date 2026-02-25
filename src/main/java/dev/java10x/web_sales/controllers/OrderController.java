package dev.java10x.web_sales.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import dev.java10x.web_sales.services.OrderServices;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import java.util.*;
import dev.java10x.web_sales.models.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/order")
public class OrderController {
    private final OrderServices orderServices;
    public OrderController(OrderServices orderServices) {
        this.orderServices = orderServices;
    }
    @GetMapping
    public List<OrderModel> getAll(){
        return orderServices.getAll();
    }
    @PostMapping
    public OrderModel create(@RequestBody OrderModel entity) {
        return orderServices.create(entity);
    }
    @DeleteMapping
    public void delete(@RequestParam Long id){
        orderServices.delete(id);
    }
    
}
