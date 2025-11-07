package com.orodent.mvc_example.features.order.view;

import com.orodent.mvc_example.core.components.AppHeader;
import com.orodent.mvc_example.features.order.model.Order;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

public class OrderListView extends VBox {

    private final ListView<Order> listView = new ListView<>();
    private final Button addButton = new Button("Nuovo Ordine");
    private final AppHeader header;


    public OrderListView() {
        header = new AppHeader("Elenco Ordini");
        this.getChildren().addAll(header, listView, addButton);
        this.setSpacing(10);
    }

    public ListView<Order> getListView() { return listView; }
    public Button getAddButton() { return addButton; }
    public AppHeader getHeader() { return header; }
}
