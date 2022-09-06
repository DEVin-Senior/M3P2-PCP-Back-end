package com.devinhouse.pcpbackend.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Builder
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

    @JsonFormat(pattern = "dd/MM/yyyy")
    @Column(name= "initial_date", nullable = false)
    private LocalDate initialDate;

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
