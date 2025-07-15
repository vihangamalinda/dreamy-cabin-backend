package com.dream.cabin.cabin.service.impl;

import com.dream.cabin.cabin.exception.ResourceNotFoundException;
import com.dream.cabin.cabin.model.User;
import com.dream.cabin.cabin.repository.UserRepository;
import com.dream.cabin.cabin.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAll() {
        return this.userRepository.findByIsActiveTrue();
    }

    @Override
    public User createUser(final User user) {
        return this.userRepository.save(user);
    }

    @Override
    public User getUserById(final long userId) {
        return this.userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException(String.format("Given User Id not found. user_id: %d", userId)));
    }

    @Override
    public void deleteUser(final long userId) {
        User oldData = this.getUserById(userId);
        oldData.setActive(false);
        this.userRepository.save(oldData);
    }
}
