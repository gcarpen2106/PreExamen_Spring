package ies.castillodeluna.psp.ejercicio_interceptores.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class RegionController {
    
    @GetMapping("/data")
    public ResponseEntity<?> getData(@RequestHeader("X-Region") String region){

        return ResponseEntity.ok("Bienvenido desde la region: " + region);

    }

    @GetMapping("/admin")
    public ResponseEntity<?> getAdmin(@RequestHeader("X-Region") String region){

        return ResponseEntity.ok("Acceso permitido desde la region: " + region);

    }



}
