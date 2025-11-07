package com.orodent.mvc_example.features.product.controller;

import com.orodent.mvc_example.app.AppController;
import com.orodent.mvc_example.features.product.model.Product;
import com.orodent.mvc_example.features.product.view.ProductListView;
import javafx.collections.ObservableList;

public class ProductListController {

    private final ProductListView view;
    private final AppController appController;
    private final ObservableList<Product> products;

    public ProductListController(ProductListView view, AppController appController, ObservableList<Product> products) {
        this.view = view;
        this.appController = appController;
        this.products = products;

        view.getListView().setItems(products);

        view.getDetailsButton().setOnAction(e -> showDetails());
        view.getAddButton().setOnAction(e -> showProductForm());
    }


    private void showDetails() {
        Product selected = view.getListView().getSelectionModel().getSelectedItem();
        if (selected != null) {
            appController.showProductDetail(selected);
        }
    }

    private void showProductForm(){
        appController.showProductForm(products);
    }

    public ProductListView getView() {
        return view;
    }
}
