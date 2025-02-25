package ies.castillodeluna.psp.spring_error;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ies.castillodeluna.psp.spring_error.models.domains.User;

@Configuration
public class DataConfig {

    @Bean
    List<User> UserServiceImpl(){

        List<User> usurios = new ArrayList<>();

        usurios.add(new User(1L, "Pepe", "Garcia"));
        usurios.add(new User(2L, "Pepa", "Lopez"));
        usurios.add(new User(3L, "Inma", "Perez"));

        return usurios;

    }

}
