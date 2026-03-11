package com.lpu.controller;

import com.lpu.entity.Student;
import com.lpu.service.CourseService;

public class CourseController {
	private static CourseService service = new CourseService();
	public static void main(String[]args) {
		service.registerCourse("Java","Ravi");
		service.registerCourse("SQL", "Vaishanv");
		service.updateTrainer(1, "ABC");
		Student s1 = new Student("Raju",19 ,77 );
		//System.out.println(s);
		service.addStudent(2, s1);
		service.deleteCourse(1);
		System.out.println(service.allCourse());
	}
}
