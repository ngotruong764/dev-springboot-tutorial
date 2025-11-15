package com.mycompany._spring_boot_hibernate_jpa_crud.dao;

import com.mycompany._spring_boot_hibernate_jpa_crud.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentImpl implements StudentDAO  {

    /**
     * define field for entity manager
     */
    private EntityManager entityManager;

    /**
     * inject entity manager using constructor injection
     */
    @Autowired
    public StudentImpl(EntityManager entityManager){
        this.entityManager = entityManager;
        System.out.println("Inside constructor: "+getClass().getSimpleName());
    }

    /**
     * implement save method
     * @param student
     */
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    /**
     * implement find by id
     */
    @Override
    public Student findById(Integer id){
        Student find_student = entityManager.find(Student.class,id );

        return find_student;
    }

    @Override
    public List<Student> findAll(){
        // create query
        TypedQuery<Student> sql = entityManager.createQuery("FROM Student order by last_name", Student.class);

        // return query result
        return sql.getResultList();
    }

    @Override
    public List<Student> findByLastName(String last_name){

        // create sql statement
        TypedQuery<Student> sql = entityManager.createQuery("from Student where last_name=: data", Student.class);
        sql.setParameter("data", last_name);

        // return
        return sql.getResultList();
    }

    @Override
    @Transactional
    public Student update(String first_name){

        // find the object
        Student find_student = entityManager.find(Student.class, 8);

        // change the state of student
        find_student.setFirst_name(first_name);

        //merge student
        entityManager.merge(find_student);

        // return
        return find_student;
    }

    @Override
    @Transactional
    public void deleteStudent(Integer id){
        // find student object
        Student del_student = entityManager.find(Student.class,id);

        // delete student
        entityManager.remove(del_student);
    }

    @Override
    @Transactional
    public int deleteAll() {
        int del_students = entityManager.createQuery("delete from Student ").executeUpdate();
        return del_students;
    }
}
