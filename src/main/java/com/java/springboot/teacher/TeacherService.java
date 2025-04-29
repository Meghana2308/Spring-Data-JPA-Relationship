package com.java.springboot.teacher;

import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {
    @Autowired
    private TeacherRepository teacherRepository;

    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    public Teacher getTeacherById(int teacherId) {
        return teacherRepository.findById(teacherId).get();
    }
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }
}
