package com.java.springboot.subject;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.springboot.student.Student;
import com.java.springboot.teacher.Teacher;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name="Subject_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int subjectId;

    private String subjectName;

    // Many-to-Many with Students
    @ManyToMany(mappedBy = "enrolledSubjects")
    @JsonIgnore
    private Set<Student> enrolledStudents = new HashSet<>();

    // Many-to-One with Teacher
    @ManyToOne
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    @JsonIgnore
    private Teacher teacher;

}


