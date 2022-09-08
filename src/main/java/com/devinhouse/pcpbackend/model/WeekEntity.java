package com.devinhouse.pcpbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_week")
public class WeekEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String content;

    @Column(name= "initial_date", nullable = false)
    private LocalDate initialDate;

    @Column(nullable = false)
    private Boolean paid;

    @OneToOne
    @JoinColumn(name = "teacher_id")
    private TeacherEntity teacherEntity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof WeekEntity that)) return false;
        return getId().equals(that.getId()) && getContent().equals(that.getContent()) && getInitialDate().equals(that.getInitialDate()) && getTeacherEntity().equals(that.getTeacherEntity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getContent(), getInitialDate(), getTeacherEntity());
    }
}
