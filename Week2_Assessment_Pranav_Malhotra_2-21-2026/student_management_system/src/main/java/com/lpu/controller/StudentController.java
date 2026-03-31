package com.lpu.controller;

//import com.lpu.entity.Student;
import com.lpu.service.StudentService;

public class StudentController {
	private static StudentService service = new StudentService();
	public static void main(String[]args) {
		//service.registerStudent("XYZ",99 ,35.55 );
		//service.updateMarks(1, 200);
		//Student s = service.getStudent(1);
		//System.out.println(s);
		service.deleteStudent(1);
		
	}
}
