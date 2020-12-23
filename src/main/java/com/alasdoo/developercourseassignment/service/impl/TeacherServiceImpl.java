package com.alasdoo.developercourseassignment.service.impl;

import com.alasdoo.developercourseassignment.dto.TeacherDTO;
import com.alasdoo.developercourseassignment.service.TeacherService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

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
        return null;
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
