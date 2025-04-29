package com.java.springboot.teacher;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}
