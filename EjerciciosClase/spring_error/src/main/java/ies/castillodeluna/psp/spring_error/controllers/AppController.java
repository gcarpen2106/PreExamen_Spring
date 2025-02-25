package ies.castillodeluna.psp.spring_error.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ies.castillodeluna.psp.spring_error.exceptions.UserNotFoundException;
import ies.castillodeluna.psp.spring_error.models.domains.User;
import ies.castillodeluna.psp.spring_error.services.UserService;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private UserService service;

    @GetMapping
    public String index(){
        
        int value = Integer.parseInt("10xxx");
        System.out.println(value);
        return "ok 200";

    }

    @GetMapping("/show/{id}")
    public User show(@PathVariable(name = "id") Long id){

        User user = service.findById(id).orElseThrow(() -> new UserNotFoundException("El usuario no existe"));
        
        return user;

    }


}
