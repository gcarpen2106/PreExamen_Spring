package ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.controllers;



import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.exceptions.InvalidProductIdException;
import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.exceptions.ProductNotFoundException;
import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.models.Product;
import ies.castillodeluna.ejercicioshandlers.ejercicios_excepciones.services.ProductService;


@RestController
@RequestMapping("/products")
public class ProductAppController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        if (id < 0) {
            throw new InvalidProductIdException("El ID del producto no puede ser negativo");
        }
        return productService.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Producto con ID " + id + " no encontrado"));
    }
    
    @GetMapping("/parse-error")
    public String triggerParseError() {
        Double price = Double.parseDouble("invalid-price");
        return "Precio: " + price;
    }
        
}
