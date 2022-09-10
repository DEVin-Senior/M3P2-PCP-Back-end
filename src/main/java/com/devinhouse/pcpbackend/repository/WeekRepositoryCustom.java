package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.dto.DashboardDto;

import java.time.LocalDate;
import java.util.List;

public interface WeekRepositoryCustom {
    List<DashboardDto> dashboardList(LocalDate dayOfWeek);
}
