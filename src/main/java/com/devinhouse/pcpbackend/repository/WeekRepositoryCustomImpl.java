package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.dto.DashboardDto;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class WeekRepositoryCustomImpl implements WeekRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<DashboardDto> dashboardList(LocalDate weekDate) {
        Query nativeQuery = entityManager.createNativeQuery("select cl.name as Turma, cl.stack as Conteudo, te.name as Docente, cl.matrix_link as Matriz, mo.name as Modulo, we.paid, we.initial_date" +
                                                                    " from tb_week we" +
                                                                    " left join tb_teacher te" +
                                                                    " on we.teacher_id = te.id" +
                                                                    " left join module_to_week mowe" +
                                                                    " on we.id = mowe.week_id" +
                                                                    " left join class_to_module clmo" +
                                                                    " on mowe.module_id = clmo.module_id" +
                                                                    " left join tb_module mo" +
                                                                    " on mowe.module_id = mo.id" +
                                                                    " left join tb_class cl" +
                                                                    " on clmo.class_id = cl.id" +
                                                                    " where we.initial_date = ?");
        nativeQuery.setParameter(1, weekDate);

        List<DashboardDto> dashboardDtoList = new ArrayList<>();

        List<Object[]> resultList = nativeQuery.getResultList();

        for (Object[] result : resultList) {
            DashboardDto dashboardDto = new DashboardDto();
            dashboardDto.setClassName(result[0].toString());
            dashboardDto.setStack(result[1].toString());
            dashboardDto.setTeacherName(result[2].toString());
            dashboardDto.setMatrixLink(result[3].toString());
            dashboardDto.setModuleName(result[4].toString());
            dashboardDto.setPaid((Boolean) result[5]);
            dashboardDto.setInitialDate(LocalDate.parse(result[6].toString()));
            dashboardDtoList.add(dashboardDto);
        }
        return dashboardDtoList;
    }
}
