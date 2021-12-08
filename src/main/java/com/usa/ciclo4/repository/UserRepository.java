package com.usa.ciclo4.repository;

import com.usa.ciclo4.model.User;
import com.usa.ciclo4.repository.crud.UserCrudRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    
    @Autowired
    private UserCrudRepository userCrudRepository;
    
    public List<User> getAll() {
        return (List<User>) userCrudRepository.findAll();
    }
    
    public Optional<User> getUser(int id) {
        return userCrudRepository.findById(id);
    }
    
    public User save(User user) {
        return userCrudRepository.save(user);
    }
    
    public Optional<User> existsByEmail(String email) {
        return userCrudRepository.findByEmail(email);
    }
    
    public Optional<User> autenticationUser(String email, String password) {
        return userCrudRepository.findByEmailAndPassword(email, password);
    }
}