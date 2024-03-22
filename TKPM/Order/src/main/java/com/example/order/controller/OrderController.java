package com.example.order.controller;
import com.example.order.model.Order;
import com.example.order.service.OrderService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.CachePut;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import redis.clients.jedis.Jedis;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class OrderController {
    @Autowired
    private OrderService orderService;

//    private Jedis jedis = new Jedis();

    @GetMapping("/orders")
    @Cacheable(value = "orders")
    public List<Order> getLisOrder(){
        return  orderService.getListOrder();
    }

    @GetMapping("/orders/{id}")
    @Cacheable(value = "order", key = "#id")
    public Order getUserById(@PathVariable(value = "id") long id){
        return orderService.getOrderById(id);
    }

    @PostMapping("/orders")
    @CachePut(value = "order", key = "#result.id")
    public Order addOrder(@RequestBody Order order) {
        return orderService.addOrder(order);
    }

    @DeleteMapping("/orders/{orderId}")
    @CacheEvict(value = "order")
    public void deleteOrder(@PathVariable(value = "orderId") long orderId){
        orderService.deleteOrderById(orderId);
    }
}

