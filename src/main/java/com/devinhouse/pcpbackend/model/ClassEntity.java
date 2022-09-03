package com.devinhouse.pcpbackend.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.*;

import com.devinhouse.pcpbackend.enums.SkillEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "class")
public class ClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "initial_date", nullable = false)
	private LocalDate initialDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

	@ElementCollection(fetch = FetchType.LAZY, targetClass = SkillEnum.class)
	@JoinTable(
			name = "class_skill",
			joinColumns = @JoinColumn(name = "class_id")
	)
	@Enumerated(EnumType.STRING)
	private List<SkillEnum> skills = new ArrayList<>();

	@Column(name = "matrix_link", nullable = false)
	private String matrixLink;

	@Column(name = "modules", nullable = false)
	private Long modules;

	@OneToMany
	@JoinTable(
			name = "class_to_module",
			joinColumns = @JoinColumn(name = "class_id"),
			inverseJoinColumns = @JoinColumn(name = "module_id")
	)
	private List<ModuleEntity> moduleEntityList = new ArrayList<>();

	@OneToMany
	@JoinTable(
			name = "class_to_event",
			joinColumns = @JoinColumn(name = "class_id"),
			inverseJoinColumns = @JoinColumn(name = "event_id")
	)
	private List<EventEntity> eventEntityList = new ArrayList<>();

	@Override
	public int hashCode() {
		return Objects.hash(endDate, id, initialDate, matrixLink, modules, name, skills);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClassEntity other = (ClassEntity) obj;
		return Objects.equals(endDate, other.endDate) && Objects.equals(id, other.id)
				&& Objects.equals(initialDate, other.initialDate) && Objects.equals(matrixLink, other.matrixLink)
				&& Objects.equals(modules, other.modules) && Objects.equals(name, other.name)
				&& Objects.equals(skills, other.skills);
	}

}
