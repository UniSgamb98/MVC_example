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

import java.util.List;
import java.util.Objects;


public class AppController {

    /*
    Qua salvo i modelli dell'applicazione e tutte le variabili che servono all'intera applicazione e non alle
    singole pagine.
     */
    private final Stage stage;
    private final ProductService productService;
    private final OrderService orderService;
    private final String cssPath;

    /*
    In questo progetto l'applicazione è state-less. Che significa che tutte le View vengono create da zero sempre.
    Questo significa che i riferimenti dei controller qui sotto non sono necessari. Sarebbero tornati utili nel caso:
    - i controller mantenessero uno stato per ricordare dei filtri impostati dall'utente, il testo inserito in
    un form oppure una selezione di qualche genere.
    - il controller gestisce qualcosa di continuo come Thread, Timer, connessioni TCP. Insomma tutto ciò che ha bisogno
    di essere fermato in un secondo momento oppure se sta leggendo un flusso di dati.
     */
    private ProductListController listController;
    private ProductDetailController detailController;
    private ProductFormController formController;
    private OrderListController orderListController;

    private ObservableList<Product> products = null;


    public AppController(Stage stage) {
        this.stage = stage;
        /*
        Queste due righe di fatto fanno la stessa cosa ma in ProductService eseguo un Service Injection che si rivela
        utile nel caso volessi cambiare al volo i dati dell'applicazione con dei dati di test. Questa operazione viene
        svolta da AppContainer, classe fatta apposta per i Service Injection.
         */
        this.productService = AppContainer.getProductService();
        this.orderService = new OrderServiceImpl();

        this.cssPath = Objects.requireNonNull(getClass().getResource("/style.css")).toExternalForm();

        showProductList();
        stage.show();
    }

    /*
    Creando le Scenes con questo metodo vengono collegate al CSS che può essere scritto tutto in un unico file.
     */
    private Scene createSceneWithCSS(Object root) {
        Scene scene = new Scene((javafx.scene.Parent) root, 400, 300);
        scene.getStylesheets().add(cssPath);
        return scene;
    }

    /*
    -------------------------------------------------------------------------------------------------------------------
    Creo un metodo per ogni view che devo mostrare. Ogni metodo chiama configureHeader per assegnare le funzioni dei
    tasti dello header qua e non nei singoli controller di tutte le view.
     */

    /*
    Questo metodo è diverso dagli altri perchè sto passando dei dati dei Model alla view per essere visualizzati e nel
    caso non ci sia il file Json uso il ServiceImplementation per ottenere dei dati predefiniti.
     */
    public void showProductList() {
        if (products == null) {
            List<Product> loaded = FileService.loadProducts();
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
        stage.setTitle("Negozio - Dettaglio Prodotto");
    }

    public void showProductForm(ObservableList<Product> products) {
        ProductFormView view = new ProductFormView();
        configureHeader(view.getHeader());
        formController = new ProductFormController(view, this, products);

        stage.setScene(createSceneWithCSS(view));
        stage.setTitle("Negozio - Nuovo prodotto");
    }

    public void showOrderList() {
        OrderListView view = new OrderListView();
        configureHeader(view.getHeader());
        orderListController = new OrderListController(orderService, view, this);

        stage.setScene(createSceneWithCSS(view));
        stage.setTitle("Negozio - Ordini");
    }

    //provate a creare voi la pagina di richiesta di un ordine.
    public void showOrderForm() {
        System.out.println("TODO: Aprire form nuovo ordine");
    }

    private void configureHeader(AppHeader header) {
        header.getHomeButton().setOnAction(e -> showProductList());
        header.getOrdersButton().setOnAction(e -> showOrderList());
    }
}
