package com.example.controller;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/user")
    public List<User> getUser(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/user")
    public User createUser(
            @RequestParam String userName,
            @RequestParam String password){
        User user =new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userRepository.save(user);
    }
}
