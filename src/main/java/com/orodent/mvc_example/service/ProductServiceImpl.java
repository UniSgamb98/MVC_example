package com.orodent.mvc_example.service;

import com.orodent.mvc_example.model.Product;
import com.orodent.mvc_example.model.ProductService;

import java.util.Arrays;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    @Override
    public List<Product> getAllProducts() {
        return Arrays.asList(
                new Product("Spada lunga"),
                new Product("Pozione curativa"),
                new Product("Scudo di ferro")
        );
    }
}
