package ies.castillodeluna.psp.spring_error.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ies.castillodeluna.psp.spring_error.models.domains.User;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private List<User> usurios;

    @Override
    public Optional<User> findById(Long id) {
        
        // User user = null;

        // for (User u : usurios) {
        //     if (u.getId().equals(id)) {
        //         user = u;
        //         break;
        //     }
        // }

        Optional<User> user = usurios.stream().filter(p -> p.getId().equals(id)).findFirst();
        return user;

    }

    @Override
    public List<User> findAll() {

        return usurios;
    }
    
    

}
