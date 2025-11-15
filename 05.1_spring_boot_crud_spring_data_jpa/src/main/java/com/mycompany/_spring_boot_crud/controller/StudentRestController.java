package com.mycompany._spring_boot_crud.controller;

import com.mycompany._spring_boot_crud.entity.Student;
import com.mycompany._spring_boot_crud.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="api")
public class StudentRestController {

    private StudentService studentService;

    @Autowired
    public StudentRestController(StudentService studentService){
        this.studentService = studentService;
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET)
    public List<Student> getAllStudent(){
        List<Student> students = studentService.findAll();
        return students;
    }

    @RequestMapping(value = "/students/{student_id}", method = RequestMethod.GET)
    public Student findStudent(@PathVariable int student_id){
        Student student = studentService.findById(student_id);

        if(student == null)
            throw new RuntimeException("Student not found");

        return studentService.findById(student_id);
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public Student addStudent(@RequestBody Student student){
        student.setId(0);
        return studentService.save(student);
    }

    @RequestMapping(value = "/students", method = RequestMethod.PUT)
    public Student saveStudent(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(value = "/students/{student_id}", method = RequestMethod.DELETE)
    public void deleteStudent(@PathVariable int student_id){
        studentService.deleteById(student_id);
    }
}
