package com.devinhouse.pcpbackend.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.devinhouse.pcpbackend.common.exception.ApiException;
import com.devinhouse.pcpbackend.model.TeacherEntity;
import com.devinhouse.pcpbackend.repository.TeacherRepository;

@Service
public class TeacherService {

	private final TeacherRepository repository;

	public TeacherService(TeacherRepository repository) {
		this.repository = repository;
	}

	public TeacherEntity insert(TeacherEntity teacher) {
		return repository.save(teacher);
	}

	public TeacherEntity update(Long id, TeacherEntity teacher) {
		try {
			TeacherEntity updatedTeacher = repository.findById(id).get();

			updatedTeacher.setName(teacher.getName());
			updatedTeacher.setPhone(teacher.getPhone());
			updatedTeacher.setEmail(teacher.getEmail());
			updatedTeacher.setSkills(teacher.getSkills());
			updatedTeacher.setArchived(teacher.getArchived());

			return repository.save(updatedTeacher);

		} catch (Exception e) {
			throw ApiException.entityNotFoundException("Teacher", id.toString());
		}
	}

	public void delete(Long id) {
		try {
			repository.findById(id).get();
		} catch (Exception e) {
			throw ApiException.entityNotFoundException("Teacher", id.toString());
		}

		repository.deleteById(id);
	}

	public List<TeacherEntity> findAll() {
		return repository.findAll();
	}

	public TeacherEntity findById(Long teacherId) {
		return repository.findById(teacherId).get();
	}

}
