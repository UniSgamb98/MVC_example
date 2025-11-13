package com.orodent.mvc_example.core;

import com.orodent.mvc_example.features.order.service.OrderService;
import com.orodent.mvc_example.features.order.service.OrderServiceImpl;
import com.orodent.mvc_example.features.product.service.ProductService;
import com.orodent.mvc_example.features.product.service.ProductServiceImpl;

public class AppContainer {

    private static ProductService productService = new ProductServiceImpl();
    private static OrderService orderService = new OrderServiceImpl();

    /*
    Questa classe si occupa di eseguire i Service Injection. Questa classe diventa molto utile nel caso in cui ho
    bisogno di fare dei test e devo sostituire i dati. Per sostituire i dati basta cambiare la parte dinamica dei vari
    service con una diversa ServiceImpl.
     */

    //Service Injection per i prodotti.
    public static ProductService getProductService() {
        return productService;
    }

    //utile per test con dati fittizi.
    public static void setProductService(ProductService service) {
        productService = service;
    }

    //Service Injection per gli ordini.
    public static OrderService getOrderService() {
        return orderService;
    }

    //utile per test con dati fittizi.
    public static void setOrderService(OrderService service) {
        orderService = service;
    }
}
