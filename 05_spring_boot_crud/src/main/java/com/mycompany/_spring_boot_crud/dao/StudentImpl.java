package com.mycompany._spring_boot_crud.dao;

import com.mycompany._spring_boot_crud.entity.Student;
import jakarta.persistence.EntityManager;

import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentImpl implements StudentDAO{

    // This entity manager is created automatically by Spring
    private EntityManager entityManager;

    // set up constructor injection
    @Autowired
    public StudentImpl(EntityManager entityManager){
        this.entityManager = entityManager;
    }
    @Override
    public List<Student> findAll() {
        // create a query
        TypedQuery<Student> sql = entityManager.createQuery(" FROM Student ", Student.class);

        // execute query and get result list
        List<Student> students = sql.getResultList();

        // return the result list
        return students;
    }

    // find by ID
    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class, id);
    }

    @Override
    public Student save(Student student) {
        System.out.println(student);
        return entityManager.merge(student);
    }

    @Override
    public void delete(int id) {
        // find student
        Student student = entityManager.find(Student.class, id);

        // remove student
        entityManager.remove(student);
    }
}
