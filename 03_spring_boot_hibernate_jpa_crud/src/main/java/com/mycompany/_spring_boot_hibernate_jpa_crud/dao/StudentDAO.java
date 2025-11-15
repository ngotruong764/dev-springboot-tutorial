package com.mycompany._spring_boot_hibernate_jpa_crud.dao;

import com.mycompany._spring_boot_hibernate_jpa_crud.entity.Student;

import java.util.List;

public interface StudentDAO{

    void save(Student student);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String student);

    Student update(String first_name);

    void deleteStudent(Integer id);

    int deleteAll();
}
