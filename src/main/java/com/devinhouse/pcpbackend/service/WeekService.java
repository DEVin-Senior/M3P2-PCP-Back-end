package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.dto.DashboardDto;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeekService {
    private final WeekRepository repository;

    public WeekService(WeekRepository repository) {
        this.repository = repository; //
    }

    public WeekEntity insert(WeekEntity week) {
        return repository.save(week); //
    }

    public WeekEntity update(Long id, WeekEntity week) {
        WeekEntity updatedWeek = repository.findById(id).get();
        updatedWeek.setContent(week.getContent());
        updatedWeek.setInitialDate(week.getInitialDate());
        return repository.save(updatedWeek);
    }
    public void delete(Long id) {
        repository.deleteById(id);
    }
    public List<WeekEntity> findAll() {
        return repository.findAll();
    }
    public WeekEntity findById(Long weekId) {
        return repository.findById(weekId).get();
    }

    public List<DashboardDto> dashboardList() {
        return repository.dashboardList();
    }
}
