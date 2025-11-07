package com.orodent.mvc_example.features.product.view;

import com.orodent.mvc_example.core.components.AppHeader;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ProductFormView extends VBox {

    private final TextField nameField;
    private final Button saveButton;
    private final Button cancelButton;
    private final AppHeader header;

    public ProductFormView() {
        header = new AppHeader("Aggiungi Prodotto");

        nameField = new TextField();
        nameField.setPromptText("Nome prodotto");

        saveButton = new Button("Salva");
        cancelButton = new Button("Annulla");

        VBox content = new VBox(10,
                new Label("Nome:"), nameField,
                saveButton, cancelButton
        );
        content.setAlignment(Pos.CENTER);
        content.getStyleClass().add("container");

        this.getChildren().addAll(header, content);
        this.setSpacing(10);
    }

    public TextField getNameField() { return nameField; }
    public Button getSaveButton() { return saveButton; }
    public Button getCancelButton() { return cancelButton; }
    public AppHeader getHeader() { return header; }
}
