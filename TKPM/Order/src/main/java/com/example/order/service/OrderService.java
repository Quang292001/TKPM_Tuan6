package com.example.order.service;

import com.example.order.model.Order;

import java.util.List;

public interface OrderService {
    public Order addOrder(Order order);
    public void deleteOrderById(long id);
    public Order getOrderById(long id);
    public List<Order> getListOrder();

}
