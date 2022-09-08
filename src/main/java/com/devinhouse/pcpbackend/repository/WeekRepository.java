package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.model.WeekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeekRepository extends JpaRepository<WeekEntity, Long>, WeekRepositoryCustom {
}
