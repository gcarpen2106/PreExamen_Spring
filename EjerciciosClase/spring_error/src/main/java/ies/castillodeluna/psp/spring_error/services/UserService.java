package ies.castillodeluna.psp.spring_error.services;

import java.util.List;
import java.util.Optional;

import ies.castillodeluna.psp.spring_error.models.domains.User;

public interface UserService {
    
    Optional<User> findById(Long id);
    List<User> findAll();

}
