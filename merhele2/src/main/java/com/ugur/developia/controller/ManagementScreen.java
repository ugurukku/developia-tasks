package com.ugur.developia.controller;

import com.ugur.developia.businessLayer.StudentService;
import com.ugur.developia.entity.Sector;
import com.ugur.developia.entity.Student;
import com.ugur.developia.security.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.jws.soap.SOAPBinding;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RequestMapping("/management/students")
public class ManagementScreen {

    private final StudentService studentService;

    public ManagementScreen(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView getById(@PathVariable("id") Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        if (User.isActive){
        Student student = studentService.getById(id);
        modelAndView.addObject("student", student);
        modelAndView.setViewName("edit");}
        else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public RedirectView editById(@PathVariable("id") Integer id, String ad, String soyad, String tevellud, String sektor) throws ParseException {
        if (User.isActive) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(formatter.parse(tevellud).getTime());

            studentService.updateById(new Student(ad, soyad, date, new Sector(Integer.parseInt(sektor))), id);

            return new RedirectView("/management/students/all");
        }
        return new RedirectView("/management/students/login");

    }


    @PostMapping("/add")
    public RedirectView addStudent(String ad, String soyad, String tevellud, String sektor) throws ParseException {
        if (User.isActive) {
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date date = new Date(formatter.parse(tevellud).getTime());

            studentService.add(new Student(ad, soyad, date, new Sector(Integer.parseInt(sektor))));

            return new RedirectView("/management/students/all");
        }
        return new RedirectView("/management/students/login");
    }

    @GetMapping("/all")
    public ModelAndView getView() {
        ModelAndView modelAndView = new ModelAndView();
        if (User.isActive) {
            List<Student> students = studentService.getAll();
            modelAndView.addObject("students", students);
            modelAndView.setViewName("index");
        } else {
            modelAndView.setViewName("login");
        }
        return modelAndView;
    }

    @PostMapping("/delete/{id}")
    public RedirectView deleteStudent(@PathVariable Integer id) {
        if (User.isActive) {
            studentService.removeById(id);
        }
        return new RedirectView("/management/students/all");
    }

    @GetMapping("/login")
    public String getLogin() {
        return "login";
    }

    @PostMapping("/login")
    public RedirectView login(String email, String password) {

        if (User.email.equals(email) && User.password.equals(password)) {
            User.isActive = true;
            return new RedirectView("/management/students/all");
        } else {
            return new RedirectView("/management/students/login");
        }

    }
}
