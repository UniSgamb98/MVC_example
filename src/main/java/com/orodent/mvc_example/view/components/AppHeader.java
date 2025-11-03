package com.orodent.mvc_example.view.components;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

public class AppHeader {

    private final HBox root;
    private final Label titleLabel;
    private final Button homeButton;

    public AppHeader(String title) {
        titleLabel = new Label(title);
        titleLabel.getStyleClass().add("header-title");

        homeButton = new Button("🏠 Home");
        homeButton.getStyleClass().add("header-button");

        root = new HBox();
        root.setAlignment(Pos.CENTER_LEFT);
        root.setSpacing(10);
        root.setPadding(new Insets(10, 20, 10, 20));
        root.getStyleClass().add("header-bar");

        HBox spacer = new HBox();
        HBox.setHgrow(spacer, javafx.scene.layout.Priority.ALWAYS);

        root.getChildren().addAll(titleLabel, spacer, homeButton);
    }

    public HBox getRoot() { return root; }
    public Button getHomeButton() { return homeButton; }
}
