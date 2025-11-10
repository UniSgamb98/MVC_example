package com.orodent.mvc_example.core;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.orodent.mvc_example.features.product.model.Product;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileService {
    private static final Gson gson = new Gson();
    private static final Path PRODUCTS_FILE_PATH = Path.of("products.json");

    /*
    questa classe si occupa di caricare e salvare i dati in file Json e non chiedetemi nulla perchè li ho copiati
    pari paro da internet.
     */

    public static void saveProducts(List<Product> products) {
        try (FileWriter writer = new FileWriter(PRODUCTS_FILE_PATH.toFile())) {
            gson.toJson(products, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Product> loadProducts() {
        try {
            if (!Files.exists(PRODUCTS_FILE_PATH)) return List.of();

            Type listType = new TypeToken<List<Product>>() {}.getType();
            FileReader reader = new FileReader(PRODUCTS_FILE_PATH.toFile());
            return gson.fromJson(reader, listType);

        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
}
