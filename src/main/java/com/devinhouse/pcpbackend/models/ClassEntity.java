package com.devinhouse.pcpbackend.models;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "initial_date", nullable = false)
	private LocalDate initialDate;

	@Column(name = "end_date", nullable = false)
	private LocalDate endDate;

	@Enumerated(EnumType.STRING)
	@ElementCollection(fetch = FetchType.LAZY, targetClass = SkillEnum.class)
	@Column(name = "stack", nullable = false)
	private List<SkillEnum> skills;

	@Column(name = "matrix_link", nullable = false)
	private String matrixLink;

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
				&& Objects.equals(name, other.name) && Objects.equals(skills, other.skills);
	}

	@Override
	public int hashCode() {
		return Objects.hash(endDate, id, initialDate, matrixLink, name, skills);
	}

}
