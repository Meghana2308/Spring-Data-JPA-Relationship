package com.java.springboot.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/getData")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @GetMapping("/getbynumber")
    public Student getStudentByNumber(@RequestParam int number) {
        return studentService.getStudentById(number);
    }

    @PostMapping("/addData")
    public Student saveStudent(@RequestBody Student student) {
        return studentService.saveStudent(student);
    }


}
