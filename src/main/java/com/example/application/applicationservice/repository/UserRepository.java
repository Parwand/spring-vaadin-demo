package com.example.application.applicationservice.repository;


import com.example.application.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by mweiss on 04.10.17.
 */
@Repository
public interface UserRepository {
    User findOneByEmail(String email);

	List<User> findByFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrEmailLikeIgnoreCase(String firstNamelikeFilter,
	                                                                                      String lastNamelikeFilter, String emaillikeFilter);

	User findOneByPasswordResetToken(String token);

	User findUserByUsername(String username);

	User save(User user);

	List<User> findAll();

	User saveAndFlush(User user);

	void delete(User user);
}
