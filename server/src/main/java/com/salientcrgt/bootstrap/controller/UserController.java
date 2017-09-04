package com.salientcrgt.bootstrap.controller;

import com.salientcrgt.bootstrap.dao.UserRepository;
import com.salientcrgt.bootstrap.model.User;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

@RestController
public class UserController {

    private UserRepository repository;

    public UserController(UserRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/users")
    @CrossOrigin(origins = "http://localhost:4200")
    public Collection<User> getUsers() {
        return repository.findAll();
    }
}
