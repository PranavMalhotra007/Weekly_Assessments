package com.lpu.dao;

import java.util.ArrayList;
import java.util.List;
import com.lpu.entity.Course;
import com.lpu.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class CourseDao {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("dev");
	public Course saveCourse(Course c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(c);
		et.commit();
		em.close();
		return c;
	}
	public void updatetrainer(int id, String trainer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Course c = em.find(Course.class, id);
		if(c!=null)
		{
			c.setTrainer(trainer);;
			et.begin();
			em.merge(c);
			et.commit();
			em.close();
		}
		else {
			System.out.println("No course with id = "+id+" exists");
		}
	}
	public void deleteCourseByID(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Course c = em.find(Course.class, id);
		et.begin();
		if(c!=null)em.remove(c);
		et.commit();
		em.close();
	}
	public Course findCourseByID(int id) {
		EntityManager em = emf.createEntityManager();
		Course c = em.find(Course.class, id);
		em.close();
		return c;
	}
	public void giveStudentToCourse(int id,Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Course c = em.find(Course.class, id);
		c.getStudentList().add(student);
		et.begin();
		em.merge(c);
		em.persist(student);
		et.commit();
		em.close();
	}
	public List<Course> getallCourses() {
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery("SELECT c FROM Course c");
		List<Course> list = query.getResultList();
	    em.close();   
	    return list;
	}
}

