package com.orodent.mvc_example.controller;


import com.orodent.mvc_example.model.Product;
import com.orodent.mvc_example.model.ProductService;
import com.orodent.mvc_example.view.ProductListView;

public class ProductListController {

    private final ProductService productService;
    private final ProductListView view;
    private final AppController appController;

    public ProductListController(ProductService productService, ProductListView view, AppController appController) {
        this.productService = productService;
        this.view = view;
        this.appController = appController;

        view.getListView().getItems().setAll(productService.getAllProducts());
        view.getDetailsButton().setOnAction(e -> showDetails());
    }

    private void showDetails() {
        Product selected = view.getListView().getSelectionModel().getSelectedItem();
        if (selected != null) {
            appController.showProductDetail(selected);
        }
    }

    public ProductListView getView() {
        return view;
    }
}
