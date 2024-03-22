package com.example.order.service.impl;

import com.example.order.model.Order;
import com.example.order.model.User;
import com.example.order.repository.OrderRepository;
import com.example.order.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Slf4j
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;

    private final RestTemplate restTemplate;


    @Autowired
    public OrderServiceImpl(OrderRepository orderRepository, RestTemplate restTemplate) {
        this.orderRepository = orderRepository;
        this.restTemplate = restTemplate;
    }

    public List<Order> getListOrder(){
        List<Order> orderList = orderRepository.findAll();
        for (Order o: orderList) {
            User user = restTemplate.getForObject("http://localhost:8083/api/v1/users/"+o.getId(), User.class);
            o.setUser(user);
        }
        return orderList;
    }

    public Order getOrderById(long id){
        Order order = orderRepository.findById(id).get();
        User user = restTemplate.getForObject("http://localhost:8083/api/v1/users/"+id, User.class);
        order.setUser(user);
        return order;
    }

    public Order addOrder(Order order){
        return orderRepository.save(order);
    }

    public void deleteOrderById(long id){
        orderRepository.deleteById(id);
    }
}
