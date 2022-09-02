package com.devinhouse.pcpbackend.controller;


import com.devinhouse.pcpbackend.converter.WeekConverter;
import com.devinhouse.pcpbackend.dto.WeekDto;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.service.WeekService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/week")
public class WeekController {

    private final WeekService service;

    public WeekController(WeekService service) {
        this.service = service;
    }

    @PostMapping
    public WeekEntity insert(@RequestBody @Valid WeekDto weekDto) {
        return service.insert(WeekConverter.converterWeek(weekDto));
    }

    @PutMapping("/{id}")
    public WeekEntity update(@RequestBody @Valid WeekDto weekDto, @PathVariable Long id) {
        return service.update(id, WeekConverter.converterWeek(weekDto));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }

    @GetMapping("/list")
    public List<WeekEntity> findAll() {
        return service.findAll();
    }

    @GetMapping("/list/{id}")
    public WeekEntity findById(@PathVariable Long id) {
        return service.findById(id);
    }

}