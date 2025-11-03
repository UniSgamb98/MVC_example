module com.orodent.mvc_example {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.orodent.mvc_example to javafx.fxml;
    exports com.orodent.mvc_example;
}