package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.dto.DashboardDto;

import java.util.List;

public interface WeekRepositoryCustom {
    List<DashboardDto> dashboardList();
}
