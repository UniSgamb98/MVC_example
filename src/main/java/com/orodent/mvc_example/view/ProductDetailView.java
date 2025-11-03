package com.orodent.mvc_example.view;

import com.orodent.mvc_example.view.components.AppHeader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class ProductDetailView {

    private final VBox root;
    private final Label productLabel;
    private final Button backButton;
    private final AppHeader header;

    public ProductDetailView() {
        header = new AppHeader("Dettaglio Prodotto");

        productLabel = new Label();
        productLabel.getStyleClass().add("title");

        backButton = new Button("Torna alla lista");

        VBox content = new VBox(15, productLabel, backButton);
        content.setAlignment(Pos.CENTER);
        content.getStyleClass().add("container");

        root = new VBox(10, header.getRoot(), content);
    }

    public VBox getRoot() { return root; }
    public Label getProductLabel() { return productLabel; }
    public Button getBackButton() { return backButton; }
    public AppHeader getHeader() { return header; }
}
