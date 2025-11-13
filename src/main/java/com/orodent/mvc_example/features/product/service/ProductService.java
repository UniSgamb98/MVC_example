package com.orodent.mvc_example.features.product.service;

import com.orodent.mvc_example.features.product.model.Product;

import java.util.List;

public interface ProductService {

    /*
    I Service di base servono a dare un modo ai vari controllori di accedere a tutti i dati relativi a un specifico
    model, in quanto è bene che questo sia soltanto un oggetto che contiene variabili per il salvataggio di una singola
    istanza. Quindi nei service si scrive la logica di recupero dei dati. Il fatto che sia una interfaccia è utile per
    fare i service injections. Così grazie questa interfaccia posso stabilire la firma dei metodi per recuperare i dati
    e nei ServiceImplementation scrivo come li recupero.
     */

    List<Product> getAll();
}
