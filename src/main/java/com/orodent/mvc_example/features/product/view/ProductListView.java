package com.orodent.mvc_example.features.product.view;

import com.orodent.mvc_example.features.product.model.Product;
import com.orodent.mvc_example.core.components.AppHeader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class ProductListView extends VBox{

    private final ListView<Product> listView;
    private final Button detailsButton;
    private final Button addButton;
    private final AppHeader header;

    /*
    Semplice View dove gestisco il layout. Lo stile viene gestito dal css in "styles.css".
     */

    public ProductListView() {
        header = new AppHeader("Gestione Prodotti");

        listView = new ListView<>();
        listView.setPrefHeight(200);

        detailsButton = new Button("Dettagli prodotto");
        addButton = new Button("Aggiungi prodotto");

        VBox content = new VBox(10, listView, detailsButton, addButton);
        content.setAlignment(Pos.CENTER);
        content.getStyleClass().add("container");

        this.getChildren().addAll(header, content);
        this.setSpacing(10);
    }

    public ListView<Product> getListView() { return listView; }
    public Button getDetailsButton() { return detailsButton; }
    public Button getAddButton() { return addButton; }
    public AppHeader getHeader() { return header; }
}
