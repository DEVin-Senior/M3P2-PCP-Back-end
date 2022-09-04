package com.devinhouse.pcpbackend.converter;

import com.devinhouse.pcpbackend.dto.UserDto;
import com.devinhouse.pcpbackend.model.UserEntity;

public class UserConverter {

    private UserConverter() {}

    public static UserEntity converterUser(UserDto userDto) {
        UserEntity user = new UserEntity();

        user.setName(userDto.getName());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());

        return user;
    }
    
}
