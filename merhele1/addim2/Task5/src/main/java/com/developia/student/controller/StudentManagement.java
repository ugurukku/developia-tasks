package com.developia.student.controller;

import com.developia.student.dataAccess.StudentService;
import com.developia.student.entity.Student;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
@RequestMapping("/students")
public class StudentManagement {

    public final StudentService studentService;

    public StudentManagement(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public ModelAndView getView() {
        List<Student> students = studentService.getAll();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("students", students);
        modelAndView.setViewName("index");
        return modelAndView;
    }


    @PostMapping ("/add")
    public RedirectView addStudent(String studentName, String surname, Integer age) {
        studentService.addStudent(new Student(studentName,surname,age));
        return new RedirectView("/students/");
    }

    @PostMapping("/delete/{id}")
    public RedirectView deleteStudent(@PathVariable("id") Integer id){
        studentService.deleteStudent(id);
        return new RedirectView("/students/");
    }




}
