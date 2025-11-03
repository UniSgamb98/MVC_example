package com.orodent.mvc_example.view;

import com.orodent.mvc_example.model.Product;
import com.orodent.mvc_example.view.components.AppHeader;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class ProductListView {

    private final VBox root;
    private final ListView<Product> listView;
    private final Button detailsButton;
    private final AppHeader header;

    public ProductListView() {
        header = new AppHeader("Gestione Prodotti");

        listView = new ListView<>();
        listView.setPrefHeight(200);

        detailsButton = new Button("Dettagli prodotto");

        VBox content = new VBox(10, listView, detailsButton);
        content.setAlignment(Pos.CENTER);
        content.getStyleClass().add("container");

        root = new VBox(10, header.getRoot(), content);
    }

    public VBox getRoot() { return root; }
    public ListView<Product> getListView() { return listView; }
    public Button getDetailsButton() { return detailsButton; }
    public AppHeader getHeader() { return header; }
}
