package com.devinhouse.pcpbackend.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Data
@NoArgsConstructor
@Table(name = "user")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Email(message = "Email inválido")
    @Column(unique = true, nullable = false)
    private String email;

    @Length(min=6, message="A senha deve conter no mínimo 6 caracteres")
    @Column(nullable = false)
    private String password;

}
