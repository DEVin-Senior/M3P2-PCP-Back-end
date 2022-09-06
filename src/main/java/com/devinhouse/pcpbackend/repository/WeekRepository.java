package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.model.WeekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeekRepository extends JpaRepository<WeekEntity, Long> {
    @Query(
            value = "SELECT * FROM tb_class",
            nativeQuery = true)
    List<WeekEntity> dashboardList();
}
