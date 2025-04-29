package com.java.springboot.subject;

import com.java.springboot.student.Student;
import com.java.springboot.student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubjectService {
    @Autowired
    private SubjectRepository subjectRepository;

    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    public Subject getSubjectById(int subjectId) {
        return subjectRepository.findById(subjectId).get();
    }

    public Subject saveSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

    public Subject updateSubject(Subject subject) {
        return subjectRepository.save(subject);
    }

}
