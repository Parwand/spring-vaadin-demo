package com.example.application.infrastructure.db;


import com.example.application.domain.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDao extends CrudRepository<User, Long> {
    User findUserByUsername(String username);
}
