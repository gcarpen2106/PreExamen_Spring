package ies.castillodeluna.psp.ejercicio_exceptions.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ies.castillodeluna.psp.ejercicio_exceptions.exceptions.NumberFormatException;
import ies.castillodeluna.psp.ejercicio_exceptions.exceptions.ProductNotFoundException;
import ies.castillodeluna.psp.ejercicio_exceptions.models.domains.Product;
import ies.castillodeluna.psp.ejercicio_exceptions.services.ProductService;

@RestController
@RequestMapping("/api")
public class AppController {
 
    @Autowired
    private ProductService productService;

    @GetMapping("/product/{id}")
    public Product show(@PathVariable(name = "id") Long id) {

        return productService.findById(id).orElseThrow(() -> new ProductNotFoundException("Producto no encontrado"));

    }

    @GetMapping("/products/{price}")
    public Product showPrice(@PathVariable(name ="price") Double price){

        return productService.findByPrice(price).orElseThrow(() -> new NumberFormatException("Precio no encontrado"));

    }

}   
