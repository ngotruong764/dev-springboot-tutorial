package com.mycompany._spring_boot_crud.dao;

import com.mycompany._spring_boot_crud.entity.Student;

import java.util.List;

public interface StudentDAO {

    List<Student> findAll();

    Student findById(int id);

    Student save(Student student);

    void delete(int id);
}
