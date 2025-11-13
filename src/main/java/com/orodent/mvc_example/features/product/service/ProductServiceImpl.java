package com.orodent.mvc_example.features.product.service;

import com.orodent.mvc_example.features.product.model.Product;

import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService {

    /*
    Questo ServiceImplementation fa da seed. In quanto l'AppController verifica la presenza del file products.json e in
    caso mancasse usa questi dati.
     */
    @Override
    public List<Product> getAll() {
        return Arrays.asList(
                new Product("Spada lunga"),
                new Product("Pozione curativa"),
                new Product("Scudo di ferro")
        );
    }
}
