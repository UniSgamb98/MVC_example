package com.orodent.mvc_example.features.product.view;

import com.orodent.mvc_example.core.components.AppHeader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;

public class ProductDetailView extends VBox{

    private final Label productLabel;
    private final Button backButton;
    private final AppHeader header;

    /*
    Semplice View dove gestisco il layout. Lo stile viene gestito dal css in "styles.css".
     */

    public ProductDetailView() {
        header = new AppHeader("Dettaglio Prodotto");

        productLabel = new Label();
        productLabel.getStyleClass().add("title");

        backButton = new Button("Torna alla lista");

        VBox content = new VBox(15, productLabel, backButton);
        content.setAlignment(Pos.CENTER);
        content.getStyleClass().add("container");

        this.getChildren().addAll(header, content);
        this.setSpacing(10);
    }

    public Label getProductLabel() { return productLabel; }
    public Button getBackButton() { return backButton; }
    public AppHeader getHeader() { return header; }
}
