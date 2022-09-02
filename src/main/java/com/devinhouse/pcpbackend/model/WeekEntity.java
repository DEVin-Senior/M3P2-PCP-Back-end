package com.devinhouse.pcpbackend.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "week")
public class WeekEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(name= "initial_date", nullable = false)
    private LocalDate initialDate;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;

    //@OneToOne
    //private ModuleEntity moduleEntity;
    private Long moduleId;

}
