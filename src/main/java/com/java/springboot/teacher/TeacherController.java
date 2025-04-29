package com.java.springboot.teacher;

import com.java.springboot.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    @GetMapping("/getTeachers")
    public List<Teacher> getAllTeachers() {
        return teacherService.getAllTeachers();
    }

    @GetMapping("/getTeacher/{teacherId}")
    public Teacher getTeacherById(@RequestParam("teacherId") int teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @PostMapping("/addTeacher")
    public Teacher saveTeacher(@RequestBody Teacher teacher) {
        return teacherService.saveTeacher(teacher);
    }



}
