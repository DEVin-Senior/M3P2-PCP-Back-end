package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.model.User;
import com.devinhouse.pcpbackend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user){
        try {
            return userRepository.save(user);
        }catch (Exception e){
            throw ApiException.badRequestException("Erro ao salvar no banco de dados");
        }

    }

    public void deleteById(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw ApiException.badRequestException("Não foi possível deletar usuário");
        }
    }

}
