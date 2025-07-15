package com.dream.cabin.cabin.service;

import com.dream.cabin.cabin.model.User;

import java.util.List;

public interface UserService {
    List<User> getAll();

    User createUser(User user);

    User getUserById(long userId);

    void deleteUser(long userId);
}
