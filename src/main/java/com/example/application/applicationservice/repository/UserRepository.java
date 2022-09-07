package com.example.application.applicationservice.repository;

import com.example.application.domain.model.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository {

    User findUserByUsername(String username);
}
