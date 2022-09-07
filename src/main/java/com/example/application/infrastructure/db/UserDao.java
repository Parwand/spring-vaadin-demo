package com.example.application.infrastructure.db;


import com.example.application.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDao extends JpaRepository<User, Long> {
    User findUserByEmail(String email);
    User findOneByEmail(String email);

    List<User> findByFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrEmailLikeIgnoreCase(String firstNamelikeFilter,
                                                                                          String lastNamelikeFilter, String emaillikeFilter);

    User findOneByPasswordResetToken(String token);
}
