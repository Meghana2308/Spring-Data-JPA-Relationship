package com.java.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getStudent")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getStudent/{studentId}")
    public Student getStudentByNumber(@RequestParam int studentId) {
        return studentService.getStudentById(studentId);
    }

    @PostMapping("/addStudent")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }


}
