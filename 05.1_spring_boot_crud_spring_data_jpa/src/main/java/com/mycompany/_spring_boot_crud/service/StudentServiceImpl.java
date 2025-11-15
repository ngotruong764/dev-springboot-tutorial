package com.mycompany._spring_boot_crud.service;

import com.mycompany._spring_boot_crud.dao.StudentRepository;
import com.mycompany._spring_boot_crud.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService{
    private StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository){
        this.studentRepository =studentRepository;
    }
    @Override
    public List<Student> findAll() {

        return studentRepository.findAll();
    }

    @Override
    public Student findById(int id) {
        Optional<Student> result = studentRepository.findById(id);

        Student student = null;

        if(result.isPresent()){
            student = result.get();
        }
        else{
            throw new RuntimeException("Did not find student id: "+id);
        }
        return student;
    }

    @Override
    public Student save(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteById(int id) {
        studentRepository.deleteById(id);
    }
}
