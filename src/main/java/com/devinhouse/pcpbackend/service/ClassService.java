package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.repository.ClassRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor

@Service
public class ClassService {

    private ClassRepository classRepository;
}
