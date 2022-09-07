package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.dto.DashboardDto;
import com.devinhouse.pcpbackend.dto.WeekDto;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;

import javax.persistence.*;
import java.util.List;

public class WeekRepositoryCustomImpl implements WeekRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<DashboardDto> dashboardList() {
        TypedQuery<DashboardDto> query = entityManager.createQuery("select new com.devinhouse.pcpbackend.dto.DashboardDto(ce.name, ce.stack, te.name, ce.matrixLink, we.content)" +
                                                                            " from WeekEntity we" +
                                                                            " left join TeacherEntity te" +
                                                                            " on we.teacherEntity = te.id" +
                                                                            " left join ClassEntity ce" +
                                                                            " on we.classEntity = ce.id"
                                                                            , DashboardDto.class);
        return query.getResultList();
    }
}
