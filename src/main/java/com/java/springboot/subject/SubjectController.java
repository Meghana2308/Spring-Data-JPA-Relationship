package com.java.springboot.subject;

import com.java.springboot.student.Student;
import com.java.springboot.student.StudentService;
import com.java.springboot.teacher.Teacher;
import com.java.springboot.teacher.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectService subjectService;
    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/getSubjects")
    public List<Subject> getAllSubjects() {
        return subjectService.getAllSubjects();
    }

    @GetMapping("/getSubject/{subjectId}")
    public Subject getSubject(@PathVariable int subjectId) {
        return subjectService.getSubjectById(subjectId);
    }

    @PostMapping("/addSubject")
    public Subject saveSubject(@RequestBody Subject subject) {
        return subjectService.saveSubject(subject);
    }

    // Enroll a student to a subject
    @PutMapping("/{subjectId}/enrollStudent/{studentId}")
    public Subject enrollStudent(@PathVariable int subjectId, @PathVariable int studentId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        Student student = studentService.getStudentById(studentId);
        student.enrollSubject(subject); // Add subject to student's set
        studentService.saveStudent(student); // Save updated student
        return subject;
    }

    // Assign a teacher to a subject
    @PutMapping("/{subjectId}/assignTeacher/{teacherId}")
    public Subject assignTeacherToSubject(@PathVariable int subjectId, @PathVariable int teacherId) {
        Subject subject = subjectService.getSubjectById(subjectId);
        Teacher teacher = teacherService.getTeacherById(teacherId);
        teacher.assignSubject(subject); // Add subject to teacher, and set teacher on subject
        subjectService.saveSubject(subject); // Save updated subject
        return subject;
    }
}

