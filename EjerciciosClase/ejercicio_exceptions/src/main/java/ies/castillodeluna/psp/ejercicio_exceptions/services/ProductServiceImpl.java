package ies.castillodeluna.psp.ejercicio_exceptions.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.castillodeluna.psp.ejercicio_exceptions.models.domains.Product;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private List<Product> products;


    @Override
    public Optional<Product> findById(Long id) {
       
        Optional<Product> product = products.stream().filter(p -> p.getId().equals(id)).findFirst();

        return product;

    }

    @Override
    public List<Product> findAll() {
        return products;
    }

    @Override
    public Optional<Product> findByPrice(Double price) {
        
        Optional<Product> product = products.stream().filter(p -> p.getPrice().equals(price)).findFirst();

        return product;

    }

}
