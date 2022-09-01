package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.model.User;
import com.devinhouse.pcpbackend.repository.UserRepository;
import com.devinhouse.pcpbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/loginRegister")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void loginRegister(@RequestBody @Valid User user) {
        try {
            userService.saveUser(user);
        } catch (Exception e) {
            throw ApiException.badRequestException("Erro ao salvar usuário");
        }
    }

}
