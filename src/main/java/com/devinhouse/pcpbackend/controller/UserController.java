package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.model.UserEntity;
import com.devinhouse.pcpbackend.service.UserEntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/loginRegister")
public class UserController {

    @Autowired
    UserEntityService userService;

    @PostMapping
    @CrossOrigin(origins = "http://localhost:4200")
    @ResponseStatus(HttpStatus.CREATED)
    public void loginRegister(@RequestBody @Valid UserEntity user) {
        try {
            userService.saveUserEntity(user);
        } catch (ApiException e) {
            throw ApiException.badRequestException("Erro ao salvar usuário");
        }
    }

}
