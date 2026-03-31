package com.lpu.dao;

import java.util.List;

import com.lpu.entity.Course;
import com.lpu.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class StudentDao {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	public Student saveStudent(Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(student);
		et.commit();
		em.close();
		return student;
	}
	public void updateMarks(int id, double marks) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student student = em.find(Student.class, id);
		if(student!=null)
		{
			student.setMarks(marks);
			et.begin();
			em.merge(student);
			et.commit();
			em.close();
		}
		else {
			System.out.println("No Student with id = "+id+" exists");
		}
	}
	public void deleteStudentByID(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student student = em.find(Student.class, id);
		et.begin();
		if(student!=null)em.remove(student);
		et.commit();
		em.close();
	}
	public Student findStudentByID(int id) {
		EntityManager em = emf.createEntityManager();
		Student student = em.find(Student.class, id);
		em.close();
		return student;
	}
	public void giveCourseToStudent(int id, Course c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class, id);
		s.getCourseList().add(c);
		et.begin();
		em.merge(s);
		em.persist(c);
		et.commit();
		em.close();
	}
	public List<Student> getallStudents() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT s FROM Student s");
		List<Student> list = query.getResultList(); 
	    em.close();
	    return list;
	}
}
