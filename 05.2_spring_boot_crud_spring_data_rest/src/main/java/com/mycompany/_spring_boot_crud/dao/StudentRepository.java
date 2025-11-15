package com.mycompany._spring_boot_crud.dao;

import com.mycompany._spring_boot_crud.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members")
public interface StudentRepository extends JpaRepository<Student, Integer> {

}
