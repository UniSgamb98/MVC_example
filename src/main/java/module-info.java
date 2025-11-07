module com.orodent.mvc_example {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.gson;

    exports com.orodent.mvc_example.app;
    exports com.orodent.mvc_example.features.product.model;
    exports com.orodent.mvc_example.features.product.controller;
    exports com.orodent.mvc_example.features.product.view;
    exports com.orodent.mvc_example.core.components;

    opens com.orodent.mvc_example.features.product.model to com.google.gson;
}
