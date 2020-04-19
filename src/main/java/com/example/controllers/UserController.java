package com.example.controllers;

import com.example.entities.User;
import com.example.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @GetMapping(value = "/user")
    public List<User> getUsers(){
        return userRepository.findAll();
    }

    @PostMapping(value = "/user")
    public User createUser(
            @RequestParam String userName,
            @RequestParam String password){
        User user=new User();
        user.setUserName(userName);
        user.setPassword(password);
        return userRepository.save(user);
    }

    @GetMapping(value = "/")
    public String welcome(){
        return "index";
    }

}
