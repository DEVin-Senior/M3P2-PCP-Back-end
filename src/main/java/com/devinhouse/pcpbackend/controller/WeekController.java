package com.devinhouse.pcpbackend.controller;


import com.devinhouse.pcpbackend.converter.WeekConverter;
import com.devinhouse.pcpbackend.dto.DashboardDto;
import com.devinhouse.pcpbackend.dto.WeekDto;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.service.WeekService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/week")
public class WeekController {

    @Autowired
    WeekService service;

    @PostMapping
    public WeekEntity insert(@RequestBody @Valid WeekDto weekDto) {
        return service.insert(WeekConverter.converterWeek(weekDto));
    }

    @PutMapping("/{id}")
    public WeekEntity update(@RequestBody @Valid WeekDto weekDto, @PathVariable Long id) {
        return service.update(id, WeekConverter.converterWeek(weekDto));
    }

    @PutMapping("payment/{id}")
    public void updatePayment(@PathVariable Long id) {
        service.updatePayment(id);
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

    @GetMapping("/dashboard")
    public List<DashboardDto> dashboardList() {
        return service.dashboardList(); //
    }
}
