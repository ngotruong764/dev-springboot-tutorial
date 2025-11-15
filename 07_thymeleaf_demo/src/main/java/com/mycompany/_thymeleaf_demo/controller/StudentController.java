package com.mycompany._thymeleaf_demo.controller;

import com.mycompany._thymeleaf_demo.model.Student;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class StudentController {

    @Value("${countries}")
    private List<String> countries;

    @Value("${languages}")
    private List<String> languages;

    @Value("${os}")
    private List<String> os;

    @RequestMapping(value = "/showStudentForm", method = RequestMethod.GET)
    public String showForm(Model model){
        // create a student object
        Student student = new Student();

        // add student object to the model
        model.addAttribute("student", student);
        model.addAttribute("countries",countries);
        model.addAttribute("languages",languages);
        model.addAttribute("os",os);
        return "student-form";
    }

    @RequestMapping(value = "/processStudentForm", method = RequestMethod.POST)
    public String processForm(@ModelAttribute("student") Student student){
        // log the input data
        System.out.println(student);

        return "student-confirmation";
    }
}
