package com.orodent.mvc_example.controller;


import com.orodent.mvc_example.model.Product;
import com.orodent.mvc_example.model.ProductService;
import com.orodent.mvc_example.view.ProductDetailView;

public class ProductDetailController {

    private final ProductService productService;
    private final ProductDetailView view;
    private final AppController appController;

    public ProductDetailController(ProductService productService, ProductDetailView view, AppController appController, Product product) {
        this.productService = productService;
        this.view = view;
        this.appController = appController;

        view.getProductLabel().setText("Hai selezionato: " + product.getName());

        // Pulsanti
        view.getBackButton().setOnAction(e -> appController.showProductList());
        view.getHeader().getHomeButton().setOnAction(e -> appController.showProductList());
    }

    public ProductDetailView getView() {
        return view;
    }
}
