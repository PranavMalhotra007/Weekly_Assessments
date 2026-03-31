package com.lpu.service;

import java.util.List;

import com.lpu.dao.StudentDao;
import com.lpu.entity.Course;
import com.lpu.entity.Student;

public class StudentService {
	private StudentDao studentDao = new StudentDao();
	public Student registerStudent(String name, int age, double marks ) {
		if(age<18 || age>100) {
			throw new IllegalArgumentException("student age not valid age must between 18 and 100");
		}
		if(marks>100 ||  marks <0) {
			throw new IllegalArgumentException("student marks not valid marks must be between 0 and 100");
		}
		Student student = new Student(name,age,marks);
		studentDao.saveStudent(student);
		return student;
	}
	public Student getStudent(int id){
		Student student = studentDao.findStudentByID(id);
		if(student==null) {
			throw new IllegalArgumentException("student not found");
		}
		return student;
	}
	public void updateMarks(int id, double marks) {
		if(marks<0 || marks>100) {
			throw new IllegalArgumentException("student marks not valid marks must be between 0 and 100");
		}
		studentDao.updateMarks(id, marks);
	}
	public void deleteStudent(int id) {
		studentDao.deleteStudentByID(id);
	}
	public List<Student> allStudents(){
		return studentDao.getallStudents();
	}
	public void addCourse(int id,Course C) {
		studentDao.giveCourseToStudent(id, C);
	}
	public void addCourses(int id,List<Course> courseList) {
		for(Course c:courseList) {
		studentDao.giveCourseToStudent(id, c);
		}
	}
}
