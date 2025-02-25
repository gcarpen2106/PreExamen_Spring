package ies.castillodeluna.psp.interceptor.controllers;

import java.util.Collections;
import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class AppController {
    
    @GetMapping("/show1")
    public Map<String , String> show1(){

        return Collections.singletonMap("message", "hadler 1 del controlador");

    }

    @GetMapping("/show2")
    public Map<String , String> show2(){

        return Collections.singletonMap("message", "hadler 2 del controlador");

    }

    @GetMapping("/show3")
    public Map<String , String> show3(){

        return Collections.singletonMap("message", "hadler 3 del controlador");

    }

}
