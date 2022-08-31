package com.devinhouse.pcpbackend.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/teacher")
public class UserController {

    @GetMapping
    public String getUser() {
        return "get user was called";
    }

    @PostMapping
    public String createUser() {
        return "create user was called";
    }

    @PutMapping
    public String updateUser() {
        return "update user was called";
    }

    @DeleteMapping
    public String deleteUser() {
        return "delete user was called";
    }
}
