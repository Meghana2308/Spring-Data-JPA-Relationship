package com.java.springboot.student;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.java.springboot.subject.Subject;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Student_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int studentId;

    private String name;

    // Many-to-Many with Subjects
    @ManyToMany
    @JoinTable(
            name = "student_enrolled_subject",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "subject_id")
    )
    private Set<Subject> enrolledSubjects = new HashSet<>();

    public void enrollSubject(Subject subject) {
        this.enrolledSubjects.add(subject);
    }
}
