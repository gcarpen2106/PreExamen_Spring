package ies.castillodeluna.psp.horario.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class AppController {
    
    @GetMapping("/foo")
    public ResponseEntity<?> foo(HttpServletRequest request){

        Map<String , String> data = new HashMap<>();
        data.put("Title","Welcome to the system of client management");
        data.put("time", new Date().toString());

        return ResponseEntity.ok(data);

    }

}
