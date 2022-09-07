package com.example.application.infrastructure.db;


import com.example.application.applicationservice.repository.UserRepository;
import com.example.application.domain.model.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {
    private final UserDao userDao;

    public UserRepositoryImpl(UserDao userDao) {
        this.userDao = userDao;
    }


    @Override
    public User findOneByEmail(String email) {
        return userDao.findOneByEmail(email);
    }

    @Override
    public List<User> findByFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrEmailLikeIgnoreCase(String firstNamelikeFilter, String lastNamelikeFilter, String emaillikeFilter) {
        return userDao.findByFirstNameLikeIgnoreCaseOrLastNameLikeIgnoreCaseOrEmailLikeIgnoreCase(firstNamelikeFilter, lastNamelikeFilter, emaillikeFilter);
    }

    @Override
    public User findOneByPasswordResetToken(String token) {
        return userDao.findOneByPasswordResetToken(token);
    }

    @Override
    public User findUserByUsername(String username) {
        return userDao.findUserByEmail(username);
    }

    @Override
    public User save(User user) {
        return userDao.save(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User saveAndFlush(User user) {
        return userDao.saveAndFlush(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }
}
