package com.devinhouse.pcpbackend.dto;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Getter
@Setter
public class UserDto {

    @NotBlank
    private String name;

    @Email(message = "E-mail informado inválido")
    private String email;

    @Length(min=6, message="A senha deve conter no mínimo 6 caracteres")
    @NotBlank
    private String password;

}
