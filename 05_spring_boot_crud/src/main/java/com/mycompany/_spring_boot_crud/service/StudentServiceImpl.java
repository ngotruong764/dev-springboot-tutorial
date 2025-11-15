package com.mycompany._spring_boot_crud.service;

import com.mycompany._spring_boot_crud.dao.StudentDAO;
import com.mycompany._spring_boot_crud.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService{
    private StudentDAO studentDAO;

    public StudentServiceImpl(StudentDAO studentDAO){
        this.studentDAO =studentDAO;
    }
    @Override
    public List<Student> findAll() {

        return studentDAO.findAll();
    }

    @Override
    public Student findById(int id) {
        return studentDAO.findById(id);
    }

    @Override
    public Student save(Student student) {
        return studentDAO.save(student);
    }

    @Override
    public void delete(int id) {
        studentDAO.delete(id);
    }
}
