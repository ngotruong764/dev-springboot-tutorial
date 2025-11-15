package com.mycompany._spring_boot_rest_controller.controller;

import com.mycompany._spring_boot_rest_controller.entity.Student;
import jakarta.annotation.PostConstruct;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class StudentRestController {

    private List<Student> students = new ArrayList<Student>();

    // define @PostConstruct to load the student data ... only once !
    @PostConstruct
    public void InitValue(){
        students.add(new Student("Joe", "Cold"));
        students.add(new Student("Dove", "Hard"));
        students.add(new Student("Kevin", "Heart"));
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST)
    public List<Student> ListStudent(){
        return students;
    }

    // define endpoint for "/students/{studentId}
    @RequestMapping(value = "/students/{student_id}", method = RequestMethod.POST)
    public Student GetStudentById(@PathVariable int student_id){

        // just index into the list ... keep it simple now

        // check the student_id
        if( (student_id > students.size()) || (student_id < 0) )
            throw new StudentNotFoundException("Student not found" + student_id);
        return students.get(student_id);
    }

}
