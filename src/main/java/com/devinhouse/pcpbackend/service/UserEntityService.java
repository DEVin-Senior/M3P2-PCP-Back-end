package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.common.DefaultMessageHelper;
import com.devinhouse.pcpbackend.common.constants.DefaultMessageConstants;
import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.model.UserEntity;
import com.devinhouse.pcpbackend.repository.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    @Autowired
    private UserEntityRepository userRepository;

    public UserEntity saveUserEntity(UserEntity user){
        Boolean exists = userRepository.existsByEmail(user.getEmail());
        if(exists){
            throw ApiException.notPermittedException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ENTITY_NOT_FOUND));
        }
        return userRepository.save(user);

    }

    public void deleteById(Integer id) {
        try {
            userRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw ApiException.badRequestException(DefaultMessageHelper.getMessage(DefaultMessageConstants.ERROR_DELETE_DATA_BY_ID));
        }
    }

}
