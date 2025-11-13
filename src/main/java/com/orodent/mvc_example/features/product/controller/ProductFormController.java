package com.orodent.mvc_example.features.product.controller;

import com.orodent.mvc_example.app.AppController;
import com.orodent.mvc_example.core.FileService;
import com.orodent.mvc_example.features.product.model.Product;
import com.orodent.mvc_example.features.product.view.ProductFormView;
import javafx.collections.ObservableList;

public class ProductFormController {

    private final ProductFormView view;
    private final AppController appController;
    private final ObservableList<Product> products;

    public ProductFormController(ProductFormView view, AppController appController, ObservableList<Product> products) {
        this.view = view;
        this.appController = appController;
        this.products = products;

        view.getSaveButton().setOnAction(e -> save());
        view.getCancelButton().setOnAction(e -> appController.showProductList());
    }

    private void save() {
        String name = view.getNameField().getText().trim();

        if (name.isEmpty()) {
            view.getNameField().setStyle("-fx-border-color: red;");
            return;
        }

        products.add(new Product(name)); // UI si aggiorna automaticamente in quanto ObservableList
        FileService.saveProducts(products);
        appController.showProductList();
    }

    public ProductFormView getView() { return view; }
}
