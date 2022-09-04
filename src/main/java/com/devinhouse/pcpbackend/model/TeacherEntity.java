package com.devinhouse.pcpbackend.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.devinhouse.pcpbackend.enums.SkillEnum;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

@Entity
@Table(name = "tb_teacher")
public class TeacherEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String phone;

    @Column(nullable = false)
    private String email;

    @ElementCollection(fetch = FetchType.LAZY, targetClass = SkillEnum.class)
    @JoinTable(
            name = "teacher_skill",
            joinColumns = @JoinColumn(name = "teacher_id")
    )
    @Enumerated(EnumType.STRING)
    private List<SkillEnum> skills = new ArrayList<>();

    @Column(nullable = false)
    private Boolean archived = false;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TeacherEntity that)) return false;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getPhone().equals(that.getPhone()) && getEmail().equals(that.getEmail()) && getSkills().equals(that.getSkills()) && getArchived().equals(that.getArchived());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhone(), getEmail(), getSkills(), getArchived());
    }
}
