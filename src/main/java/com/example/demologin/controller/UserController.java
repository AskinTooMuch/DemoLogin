package com.example.demologin.controller;

import com.example.demologin.entity.User;
import com.example.demologin.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("api/")
public class UserController {
    @Autowired
    private UserRepository repo;

    @GetMapping("users")
    public List<User> getUsers(){
        return this.repo.findAll();
    }
}
