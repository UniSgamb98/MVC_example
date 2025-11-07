package com.orodent.mvc_example.features.order.controller;

import com.orodent.mvc_example.app.AppController;
import com.orodent.mvc_example.features.order.model.Order;
import com.orodent.mvc_example.features.order.service.OrderService;
import com.orodent.mvc_example.features.order.view.OrderListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class OrderListController {

    private final OrderService service;
    private final AppController appController;
    private final ObservableList<Order> orders;
    private final OrderListView view;

    public OrderListController(OrderService service, OrderListView view, AppController appController) {
        this.service = service;
        this.view = view;
        this.appController = appController;

        this.orders = FXCollections.observableArrayList(service.getAll());
        view.getListView().setItems(orders);

        view.getAddButton().setOnAction(e -> appController.showOrderForm());
    }

    public OrderListView getView() { return view; }
}
