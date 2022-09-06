package com.devinhouse.pcpbackend;

import com.devinhouse.pcpbackend.model.ClassEntity;
import com.devinhouse.pcpbackend.model.ModuleEntity;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.model.WeekEntity;
import com.devinhouse.pcpbackend.repository.ClassRepository;
import com.devinhouse.pcpbackend.repository.ModuleRepository;
import com.devinhouse.pcpbackend.repository.TeacherRepository;
import com.devinhouse.pcpbackend.repository.WeekRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.util.List;

@EnableJpaRepositories
@SpringBootApplication
public class PcpBackendApplication {

	@Autowired
	WeekRepository weekRepository;

	@Autowired
	ClassRepository classRepository;

	@Autowired
	TeacherRepository teacherRepository;

	@Autowired
	ModuleRepository moduleRepository;

	@Bean
	public CommandLineRunner runner(){
		return args -> {

			TeacherEntity teacher1 = TeacherEntity.builder()
					.name("Neva Deckow")
					.phone("(11) 51253-4700")
					.email("neva_deckow44@yahoo.com").build();

			TeacherEntity teacher2 = TeacherEntity.builder()
					.name("Cesar Williamson")
					.phone("(27) 85658-6286")
					.email("cesar.williamson20@yahoo.com").build();

			WeekEntity week1 = WeekEntity.builder()
					.content("JAVA week1")
					.initialDate(LocalDate.of(2022,9,11))
					.teacherEntity(teacher1)
					.build();

			WeekEntity week2 = WeekEntity.builder()
					.content("PYTHON week2")
					.initialDate(LocalDate.of(2022,9,18))
					.teacherEntity(teacher2)
					.build();

			ModuleEntity module1 = ModuleEntity.builder()
					.name("Modulo 1")
					.weekEntityList(List.of(week1, week2))
					.build();

			ModuleEntity module2 = ModuleEntity.builder()
					.name("Modulo 2")
					.weekEntityList(List.of(week1, week2))
					.build();

			ClassEntity class1 = ClassEntity.builder()
					.name("TURMA 1")
					.initialDate(LocalDate.of(2022,9,11))
					.endDate(LocalDate.of(2022,9,30))
					.stack("JAVA/PYTHON")
					.matrixLink("www.google.com")
					.archive(false)
					.moduleEntityList(List.of(module1, module2)).build();

			ClassEntity class2 = ClassEntity.builder()
					.name("TURMA 2")
					.initialDate(LocalDate.of(2022,9,11))
					.endDate(LocalDate.of(2022,9,30))
					.stack("JAVA/PYTHON 2")
					.matrixLink("www.yahoo.com")
					.archive(false)
					.moduleEntityList(List.of(module1, module2)).build();

			teacherRepository.saveAll(List.of(teacher1, teacher2));
			weekRepository.saveAll(List.of(week1, week2));
			moduleRepository.saveAll(List.of(module1, module2));
			classRepository.saveAll(List.of(class1, class2));


		};
	}

	public static void main(String[] args) {
		SpringApplication.run(PcpBackendApplication.class, args);
	}

}
