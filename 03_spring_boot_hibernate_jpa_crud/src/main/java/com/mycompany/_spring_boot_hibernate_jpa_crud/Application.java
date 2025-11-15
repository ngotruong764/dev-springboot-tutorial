package com.mycompany._spring_boot_hibernate_jpa_crud;

import com.mycompany._spring_boot_hibernate_jpa_crud.dao.StudentDAO;
import com.mycompany._spring_boot_hibernate_jpa_crud.dao.StudentImpl;
import com.mycompany._spring_boot_hibernate_jpa_crud.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	/**
	 * CommandLineRunner froms Spring Boot
	 *
	 * @effects Executed after the Spring Beans have been loaded
	 */
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner ->{
			System.out.println("dost");
//			studentDAO.save( new Student("ngo", "truong", "ngotruong@gmail.com"));

			createMultipleStudent(studentDAO);
//
//			readStudent(studentDAO);

//			retrieveAll(studentDAO);

//			readByName(studentDAO);

//			updateStudent(studentDAO);

//			deleteById(studentDAO);

//			deleteAllStudent(studentDAO);
		};
	}

	private void deleteAllStudent(StudentDAO studentDAO) {
		System.out.println("Delete all student ....");

		int del_students = studentDAO.deleteAll();
		System.out.println("Number of student deleted: "+ del_students);
	}

	private void deleteById(StudentDAO studentDAO) {
		int id = 6;

		System.out.println("Deleting student ...");

		studentDAO.deleteStudent(id);
	}

	private void updateStudent(StudentDAO studentDAO) {
		String first_name = "Boob";

		Student student = studentDAO.update(first_name);

		System.out.println(student);
	}

	private void readByName(StudentDAO studentDAO) {
		String last_name = "Maguire";

		List<Student> students = studentDAO.findByLastName(last_name);

		for(Student i: students){
			System.out.println(i);
		}
	}

	private void retrieveAll(StudentDAO studentDAO) {

		// get list of students
		List<Student> student = studentDAO.findAll();

		// display list of students
		for (Student i : student){
			System.out.println(i);
		}
	}

	private void createMultipleStudent(StudentDAO studentDAO) {
		// create multiple students
		System.out.println("Creating new student object...");
		Student tempStudent1 = new Student("Paul","Mogrgan", "paul@gmail.com");
		Student tempStudent2 = new Student("John","Dove", "john@gmail.com");
		Student tempStudent3 = new Student("Harry","Maguire", "harry@gmail.com");


		// save the student objects
		System.out.println("Saving the student");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void readStudent(StudentDAO studentDAO){
		// display id of the student
		int id = 6;
		// retrieve student base on the id: primary key
		Student student = studentDAO.findById(id);

		// display student
		System.out.println(student);
	}

}
