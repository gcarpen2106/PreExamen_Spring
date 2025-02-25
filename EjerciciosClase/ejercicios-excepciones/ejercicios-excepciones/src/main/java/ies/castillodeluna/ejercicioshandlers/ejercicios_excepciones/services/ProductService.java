package ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.services;



import java.util.List;
import java.util.Optional;

import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.models.Product;



public interface ProductService {
    List<Product> findAll();
    Optional<Product> findById(Long id);
}

