package com.rohit.student.controller;

import com.rohit.student.repository.TeachersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/info/teacher")
public class TeacherController {
    @Autowired
    TeachersRepository repository2;

    @GetMapping("/name/{name}")
    String getTeacherName(@PathVariable("name") final String name, Model model){
        model.addAttribute("teachers", repository2.findByFirstName(name));
        return "index2";
    }
    @GetMapping("/all")
    String getTeachersAll( Model model){
        model.addAttribute("teachers", repository2.findAll());
        return "index2";
    }

}
