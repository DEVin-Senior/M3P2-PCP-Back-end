package com.devinhouse.pcpbackend.controller;

import com.devinhouse.pcpbackend.dto.AllocationDto;
import com.devinhouse.pcpbackend.dto.ClassUpdateDto;
import com.devinhouse.pcpbackend.service.AllocationService;
import com.devinhouse.pcpbackend.service.ClassService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/allocation")
@RestController
public class AllocationController {

    @Autowired
    private AllocationService allocationService;

    private ModelMapper modelMapper;

    @PutMapping
    public ClassUpdateDto allocation(@RequestBody AllocationDto allocationDto) {
        return allocationService.allocationService(allocationDto);
    }

    @GetMapping("/class/{id}")
    public ClassUpdateDto findById(@PathVariable Long id) {
        return allocationService.findById(id);
    }

}
