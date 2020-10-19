package com.rohit.student.controller;

import com.rohit.student.model.Student;
import com.rohit.student.repository.StudentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller //Thymeleaf works only with @Controller, not @RestController
@RequestMapping("/info/student")
public class StudentController {
@Autowired
StudentsRepository repository;

@GetMapping("/name/{name}")
String getStudents(@PathVariable("name") final String name, Model model){
    System.out.println("inside getStudents method");
    model.addAttribute("students", repository.findByFirstName(name));
    return "index";
}

@GetMapping("/all")
String getList(Model model) {
    System.out.println("inside getList method");
    model.addAttribute("students", repository.findAll());
    return "index";
}

@GetMapping("/teacherId/{teacherId}")
List<Student> getStudentTeachId(@PathVariable("teacherId") final int teacherID){
    return repository.findByTeacherId(teacherID);
}

@GetMapping("/specific-name/{name}-{name2}")
String getByName(@PathVariable("name") final String name, @PathVariable("name2") final String name2, Model model){
    System.out.println("inside getStudents method");
    model.addAttribute("students", repository.findByFirstNameAndLastName(name, name2));
    return "index";
}

}
