package com.orodent.mvc_example.features.order.service;

import com.orodent.mvc_example.features.order.model.Order;

import java.util.List;

public interface OrderService {
    List<Order> getAll();
    void add(Order order);
}
