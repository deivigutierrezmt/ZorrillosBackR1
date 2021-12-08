package com.usa.ciclo4.service;

import com.usa.ciclo4.model.User;
import com.usa.ciclo4.repository.UserRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAll() {
       return userRepository.getAll();
    }
    
    public Optional<User> getUser(int id) {
        return userRepository.getUser(id);
    }
    
    public boolean ExistsEmail(String email) {
        Optional<User> userAux = userRepository.existsByEmail(email);
        return !userAux.isEmpty(); // True - false
    }
    
    public User registerUser(User user) {
        if (user.getId() == null) {
            if (ExistsEmail(user.getEmail()) == false) {
                return userRepository.save(user);
            }
        }      
        return user;       
    }
    
    public User autenticationUser(String email, String password) {
        Optional<User> userAux = userRepository.autenticationUser(email, password);
        
        if (userAux.isEmpty()) {
            return new User(email, password, "NO DEFINIDO");
        }
        return userAux.get();
    }        
}
