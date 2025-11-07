package com.orodent.mvc_example.core;

import com.orodent.mvc_example.features.product.service.ProductService;
import com.orodent.mvc_example.features.product.service.ProductServiceImpl;

public class AppContainer {

    private static ProductService productService = new ProductServiceImpl();

    public static ProductService getProductService() {
        return productService;
    }

    //utile per test con dati fittizi
    public static void setProductService(ProductService service) {
        productService = service;
    }
}
