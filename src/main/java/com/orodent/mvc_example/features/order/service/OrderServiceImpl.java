package com.orodent.mvc_example.features.order.service;

import com.orodent.mvc_example.features.order.model.Order;

import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private final List<Order> orders = new ArrayList<>();

    /*
    Una ServiceImplementation generica.
     */
    @Override
    public List<Order> getAll() {
        return orders;
    }

    @Override
    public void add(Order order) {
        orders.add(order);
    }
}
