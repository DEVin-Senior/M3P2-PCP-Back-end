package com.devinhouse.pcpbackend.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "module")
public class ModuleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany
    @JoinTable(
            name = "module_to_week",
            joinColumns = @JoinColumn(name = "module_id"),
            inverseJoinColumns = @JoinColumn(name = "week_id")
    )
    private List<WeekEntity> weekEntityList = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ModuleEntity that)) return false;
        return getId().equals(that.getId()) && getName().equals(that.getName()) && getWeekEntityList().equals(that.getWeekEntityList());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getWeekEntityList());
    }
}
