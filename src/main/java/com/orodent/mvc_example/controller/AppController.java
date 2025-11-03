package com.orodent.mvc_example.controller;

import com.orodent.mvc_example.model.Product;
import com.orodent.mvc_example.model.ProductService;
import com.orodent.mvc_example.service.ProductServiceImpl;
import com.orodent.mvc_example.view.ProductDetailView;
import com.orodent.mvc_example.view.ProductListView;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppController {

    private final Stage stage;
    private final ProductService productService;
    private final String cssPath;

    private ProductListController listController;
    private ProductDetailController detailController;

    public AppController(Stage stage) {
        this.stage = stage;
        this.productService = new ProductServiceImpl();
        this.cssPath = getClass().getResource("/style.css").toExternalForm();

        showProductList();
    }

    private Scene createSceneWithCSS(Object root) {
        Scene scene = new Scene((javafx.scene.Parent) root, 400, 300);
        scene.getStylesheets().add(cssPath);
        return scene;
    }

    public void showProductList() {
        ProductListView view = new ProductListView();
        listController = new ProductListController(productService, view, this);

        stage.setScene(createSceneWithCSS(view.getRoot()));
        stage.setTitle("Negozio - Lista Prodotti");
        stage.show();
    }

    public void showProductDetail(Product product) {
        ProductDetailView view = new ProductDetailView();
        detailController = new ProductDetailController(productService, view, this, product);

        stage.setScene(createSceneWithCSS(view.getRoot()));
        stage.setTitle("Dettaglio Prodotto");
    }
}
