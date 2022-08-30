package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.model.User;
import com.devinhouse.pcpbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepository;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody @Valid User user){
        try{
            userRepository.save(user);
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

}
