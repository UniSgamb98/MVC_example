package com.orodent.mvc_example.features.order.model;

import com.orodent.mvc_example.features.product.model.Product;

import java.time.LocalDate;
import java.util.List;

public record Order(LocalDate date, List<Product> products) {

    @Override
    public String toString() {
        return "Ordine del " + date + " (" + products.size() + " prodotti)";
    }
}
