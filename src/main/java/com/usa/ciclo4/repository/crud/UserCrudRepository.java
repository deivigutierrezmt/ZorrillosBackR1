package com.usa.ciclo4.repository.crud;

import com.usa.ciclo4.model.User;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;

public interface UserCrudRepository extends CrudRepository<User, Integer>{
    
    Optional<User> findByEmail(String email);
    
    Optional<User> findByEmailAndPassword(String email, String password);
}
