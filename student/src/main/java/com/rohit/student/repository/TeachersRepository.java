package com.rohit.student.repository;


import com.rohit.student.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeachersRepository extends JpaRepository<Teacher, Integer> {
    List<Teacher> findByFirstName(String firstName);

}
