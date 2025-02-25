package ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.services;



import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.models.Product;


@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private List<Product> products;

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
