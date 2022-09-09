package com.devinhouse.pcpbackend.service;

import com.devinhouse.pcpbackend.dto.DashboardDto;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

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
        LocalDate weekDate = LocalDate.now();
        DayOfWeek dayOfWeek = LocalDate.now().getDayOfWeek();

        while (!DayOfWeek.MONDAY.equals(dayOfWeek)) {
            dayOfWeek = dayOfWeek.minus(1);
            weekDate = weekDate.minusDays(1);
        }
        return repository.dashboardList(weekDate);
    }

    public void updatePayment(Long id){
        WeekEntity updatePaymentdWeek = repository.findById(id).get();
        if(updatePaymentdWeek.getPaid()==false){
            updatePaymentdWeek.setPaid(true);
        }else{
            updatePaymentdWeek.setPaid(false);
        }
    }
}
