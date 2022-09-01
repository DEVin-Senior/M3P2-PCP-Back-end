package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.model.UserEntity;
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
    public void loginRegister(@RequestBody @Valid UserEntity userEntity) {
        try {
            userService.saveUser(userEntity);
        } catch (Exception e) {
            throw ApiException.badRequestException("Erro ao salvar usuário");
        }
    }

}
