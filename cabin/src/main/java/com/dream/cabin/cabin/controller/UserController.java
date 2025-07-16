package com.dream.cabin.cabin.controller;

import com.dream.cabin.cabin.model.User;
import com.dream.cabin.cabin.service.UserService;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletPath;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    private UserService userService;

    UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<User>> getAll() {
        List<User> userList = this.userService.getAll();
        return ResponseEntity.ok(userList);
    }

    @PostMapping("/create")
    public ResponseEntity<User> createUser(@RequestBody User user) {
        User savedUser = this.userService.createUser(user);
        String currentUri = ServletUriComponentsBuilder.fromCurrentRequestUri().toUriString();
        URI uri = URI.create(currentUri.replace("/create", String.format("/%d", savedUser.getId())));
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") long userId) {
        User user = this.userService.getUserById(userId);
        return ResponseEntity.ok(user);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteUser(@PathVariable("id") long userId) {
        this.userService.deleteUser(userId);
        return ResponseEntity.ok(Map.of("hasDeleted", true));
    }
}
