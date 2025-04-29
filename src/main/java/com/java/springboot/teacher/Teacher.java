package com.java.springboot.teacher;

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
@Table(name="Teacher_Table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int teacherId;

        private String name;

        @JsonIgnore
        @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
        private Set<Subject> subjects = new HashSet<>();

        public void assignSubject(Subject subject) {
                subjects.add(subject);
                subject.setTeacher(this);
        }
}
