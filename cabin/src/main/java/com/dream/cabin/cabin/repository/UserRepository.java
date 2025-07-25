package com.dream.cabin.cabin.repository;

import com.dream.cabin.cabin.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findByIsActiveTrue();

}
