package com.mycompany._spring_boot_crud.dao;

import com.mycompany._spring_boot_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
