package com.devinhouse.pcpbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Email(message = "Email inválido")
    @Column(unique = true)
    private String email;

    @Length(min=6, message="A senha deve conter no mínimo 6 caracteres")
    @Column(nullable = false)
    private String password;

}
