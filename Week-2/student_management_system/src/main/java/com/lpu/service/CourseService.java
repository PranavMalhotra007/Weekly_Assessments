package com.lpu.service;
import java.util.List;

import com.lpu.dao.CourseDao;
import com.lpu.entity.Course;
import com.lpu.entity.Student;

public class CourseService {
		private CourseDao coursedao = new CourseDao();
		public Course registerCourse(String name, String trainer ) {
			Course c = new Course(name,trainer);
			coursedao.saveCourse(c);
			return c;
		}
		public Course getCourse(int id){
			Course course = coursedao.findCourseByID(id);
			if(course==null) {
				throw new IllegalArgumentException("course not found");
			}
			return course;
		}
		public void updateTrainer(int id, String trainer) {
			coursedao.updatetrainer(id, trainer);
		}
		public void deleteCourse(int id) {
			coursedao.deleteCourseByID(id);
		}
		public void addStudents(int id,List<Student>studentList) {
			for(Student s:studentList) {
				coursedao.giveStudentToCourse(id, s);
			}
		}
		public void addStudent(int id,Student s) {
			coursedao.giveStudentToCourse(id, s);
		}
		public List<Course> allCourse(){
			return coursedao.getallCourses();
		}
}