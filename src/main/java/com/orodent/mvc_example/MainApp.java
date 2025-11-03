package com.orodent.mvc_example;

import com.orodent.mvc_example.controller.AppController;
import javafx.application.Application;
import javafx.stage.Stage;


public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        new AppController(stage); // avvia l'app e mostra la lista
    }

    public static void main(String[] args) {
        launch();
    }
}
