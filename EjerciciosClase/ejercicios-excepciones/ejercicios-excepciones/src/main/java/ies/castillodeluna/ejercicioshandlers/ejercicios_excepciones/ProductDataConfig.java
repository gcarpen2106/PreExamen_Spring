package ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.models.Product;



@Configuration
public class ProductDataConfig {

    @Bean
    public List<Product> products() {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Laptop", 1200.50));
        products.add(new Product(2L, "Mouse", 25.00));
        products.add(new Product(3L, "Keyboard", 45.00));
        return products;
    }
}