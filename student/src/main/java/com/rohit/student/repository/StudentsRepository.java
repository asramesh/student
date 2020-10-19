package com.rohit.student.repository;

import com.rohit.student.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentsRepository extends JpaRepository<Student, Integer> {
    List<Student> findByFirstName(String firstName);
    List<Student> findByTeacherId(int teacherId);
    List<Student> findByFirstNameAndLastName(String firstName, String lastName);

}
