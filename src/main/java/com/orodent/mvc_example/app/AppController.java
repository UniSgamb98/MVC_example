package com.orodent.mvc_example.app;

import com.orodent.mvc_example.core.AppContainer;
import com.orodent.mvc_example.core.FileService;
import com.orodent.mvc_example.core.components.AppHeader;
import com.orodent.mvc_example.features.order.controller.OrderListController;
import com.orodent.mvc_example.features.order.service.OrderService;
import com.orodent.mvc_example.features.order.service.OrderServiceImpl;
import com.orodent.mvc_example.features.order.view.OrderListView;
import com.orodent.mvc_example.features.product.controller.ProductDetailController;
import com.orodent.mvc_example.features.product.controller.ProductFormController;
import com.orodent.mvc_example.features.product.controller.ProductListController;
import com.orodent.mvc_example.features.product.model.Product;
import com.orodent.mvc_example.features.product.service.ProductService;
import com.orodent.mvc_example.features.product.view.ProductDetailView;
import com.orodent.mvc_example.features.product.view.ProductFormView;
import com.orodent.mvc_example.features.product.view.ProductListView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class AppController {

    private final Stage stage;
    private final ProductService productService;
    private final OrderService orderService;
    private final String cssPath;

    private ProductListController listController;
    private ProductDetailController detailController;
    private ProductFormController formController;
    private OrderListController orderListController;

    private ObservableList<Product> products = null;


    public AppController(Stage stage) {
        this.stage = stage;
        this.productService = AppContainer.getProductService();
        this.orderService = new OrderServiceImpl();
        this.cssPath = getClass().getResource("/style.css").toExternalForm();

        showProductList();
        stage.show();
    }

    private Scene createSceneWithCSS(Object root) {
        Scene scene = new Scene((javafx.scene.Parent) root, 400, 300);
        scene.getStylesheets().add(cssPath);
        return scene;
    }

    public void showProductList() {
        if (products == null) {
            var loaded = FileService.loadProducts();
            if (loaded.isEmpty()) {
                products = FXCollections.observableArrayList(productService.getAll());
            } else {
                products = FXCollections.observableArrayList(loaded);
            }
        }

        ProductListView view = new ProductListView();
        configureHeader(view.getHeader());
        listController = new ProductListController(view, this, products);

        stage.setScene(createSceneWithCSS(view));
        stage.setTitle("Negozio - Lista Prodotti");
    }


    public void showProductDetail(Product product) {
        ProductDetailView view = new ProductDetailView();
        configureHeader(view.getHeader());
        detailController = new ProductDetailController(productService, view, this, product);

        stage.setScene(createSceneWithCSS(view));
        stage.setTitle("Dettaglio Prodotto");
    }

    public void showProductForm(ObservableList<Product> products) {
        ProductFormView view = new ProductFormView();
        configureHeader(view.getHeader());
        formController = new ProductFormController(view, this, products);

        stage.setScene(createSceneWithCSS(view));
        stage.setTitle("Nuovo prodotto");
    }

    public void showOrderList() {
        OrderListView view = new OrderListView();
        configureHeader(view.getHeader());
        orderListController = new OrderListController(orderService, view, this);

        stage.setScene(createSceneWithCSS(view));
        stage.setTitle("Ordini");
    }

    public void showOrderForm() {
        System.out.println("TODO: Aprire form nuovo ordine");
    }

    public void configureHeader(AppHeader header) {
        header.getHomeButton().setOnAction(e -> showProductList());
        header.getOrdersButton().setOnAction(e -> showOrderList());
    }

}
