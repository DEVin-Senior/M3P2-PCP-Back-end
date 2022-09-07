package com.devinhouse.pcpbackend.repository;

import com.devinhouse.pcpbackend.dto.DashboardDto;
import com.devinhouse.pcpbackend.model.WeekEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public interface WeekRepository extends JpaRepository<WeekEntity, Long>, WeekRepositoryCustom {
}
