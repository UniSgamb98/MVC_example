package com.orodent.mvc_example.app;

import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {

    /*
    AppController è una classe che fa le veci da Router dell'app. Tutti i Controller delle
    varie pagine chiederanno ad AppController di cambiare vista.
     */
    @Override
    public void start(Stage stage) {
        new AppController(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}
