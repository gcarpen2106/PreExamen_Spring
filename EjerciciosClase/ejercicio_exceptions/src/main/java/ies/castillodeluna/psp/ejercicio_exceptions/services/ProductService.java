package ies.castillodeluna.psp.ejercicio_exceptions.services;

import java.util.List;
import java.util.Optional;

import ies.castillodeluna.psp.ejercicio_exceptions.models.domains.Product;

public interface ProductService {
 
    Optional<Product> findById(Long id);
    List<Product> findAll();
    Optional<Product> findByPrice(Double price);

}
