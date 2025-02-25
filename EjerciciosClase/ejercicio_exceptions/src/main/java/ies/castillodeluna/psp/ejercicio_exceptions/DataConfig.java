package ies.castillodeluna.psp.ejercicio_exceptions;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ies.castillodeluna.psp.ejercicio_exceptions.models.domains.Product;

@Configuration
public class DataConfig {
    
    @Bean
    List<Product> products(){
        return List.of(
            new Product(1L, "Product 1", 12.5),
            new Product(2L, "Product 2", 22.5),
            new Product(3L, "Product 3", 32.5),
            new Product(4L, "Product 4", 42.5),
            new Product(5L, "Product 5", 52.5)
        );
    }

}
