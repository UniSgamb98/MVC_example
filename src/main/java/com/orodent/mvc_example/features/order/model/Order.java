package com.orodent.mvc_example.features.order.model;

import com.orodent.mvc_example.features.product.model.Product;

import java.time.LocalDate;
import java.util.List;

public record Order(LocalDate date, List<Product> products) {

    /*
    Questo è un semplice POJO. La keyword "record" implementa automaticamente tutte le funzioni che dovrebbe avere e lo
    rende un Data Transfer Object ideale.
     */

    @Override
    public String toString() {
        return "Ordine del " + date + " (" + products.size() + " prodotti)";
    }
}
