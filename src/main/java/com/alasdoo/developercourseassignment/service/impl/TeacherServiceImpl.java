package com.alasdoo.developercourseassignment.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.entity.Teacher;
import com.alasdoo.developercourseassignment.mapper.TeacherMapper;
import com.alasdoo.developercourseassignment.repository.TeacherRepository;
import com.alasdoo.developercourseassignment.service.TeacherService;

@Service
public class TeacherServiceImpl implements TeacherService {

	@Autowired
	private TeacherRepository teacherRepository;

	@Autowired
	private TeacherMapper teacherMapper;

	@Override
	public TeacherDTO findOne(Integer id) {
		return null;
	}

	@Override
	public List<TeacherDTO> findAll() {
		return null;
	}

	@Override
	public TeacherDTO save(TeacherDTO teacherDTO) {
		Teacher teacher = teacherMapper.transformToEntity(teacherDTO);
        return teacherMapper.transformToDTO(teacherRepository.save(teacher));
	}

	@Override
	public void remove(Integer id) throws IllegalArgumentException {
	}

	@Override
	public TeacherDTO update(Integer id, TeacherDTO teacherDTO) {
		return null;
	}

	public TeacherDTO findByTeacherNameAndTeacherSurname(String name, String surname) {
		return null;
	}

	public TeacherDTO findByTeacherEmail(String email) {
		return null;
	}
}
