package com.orodent.mvc_example.features.product.model;

public record Product(String name) {

    @Override
    public String toString() {
        return name;
    }
}
