package com.orodent.mvc_example.features.product.model;

public record Product(String name) {

    /*
    Questo è un semplice POJO. La keyword "record" implementa automaticamente tutte le funzioni che dovrebbe avere e lo
    rende un Data Transfer Object ideale.
     */

    @Override
    public String toString() {
        return name;
    }
}
