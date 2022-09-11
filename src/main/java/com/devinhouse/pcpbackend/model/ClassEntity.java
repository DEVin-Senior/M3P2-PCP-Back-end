package com.devinhouse.pcpbackend.model;

import java.time.LocalDate;
import java.util.List;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "tb_class")
public class ClassEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 60)
	@NotBlank(message = "Nome não pode estar vazio")
	private String name;

	@Column(name = "initial_date", nullable = false)
	@NotNull(message = "Data inicial não pode estar vazia")
	private LocalDate initialDate;

	@Column(name = "end_date", nullable = false)
	@NotNull(message = "Data final não pode estar vazia")
	private LocalDate endDate;

	@Column(nullable = false, length = 60)
	@NotBlank(message = "Stack não pode estar vazia")
	private String stack;

	@Column(name = "matrix_link", nullable = false, length = 80)
	@NotBlank(message = "Link da matriz curricular não pode estar vazia")
	private String matrixLink;

	@Column(nullable = false)
	private boolean archive;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "class_to_module",
			joinColumns = @JoinColumn(name = "class_id"),
			inverseJoinColumns = @JoinColumn(name = "module_id")
	)
	private List<ModuleEntity> moduleEntityList;

}
