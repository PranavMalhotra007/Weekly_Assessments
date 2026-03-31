package com.lpu.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.lpu.entity.Student;
import com.lpu.service.StudentService;

public class StudentServiceTest {
    private static StudentService service;
    @BeforeAll
    static void setUp() {
        service = new StudentService();
        System.out.println("Test Started");
    }
    @AfterAll
    static void tearDown() {
        System.out.println("Test Completed");
    }
    @Test
    void testRegisterStudentSuccess() {
        Student student = service.registerStudent("Pranav", 22, 85.5);

        assertNotNull(student);
        assertEquals("Pranav", student.getName());
        assertEquals(22, student.getAge());
        assertEquals(85.5, student.getMarks());
    }
    @Test
    void testRegisterStudentInvalidAge() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.registerStudent("Rahul", 15, 80);
        });
        assertEquals("student age not valid age must between 18 and 100",
                exception.getMessage());
    }
    @Test
    void testRegisterStudentInvalidMarks() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.registerStudent("Aman", 25, 150);
        });
        assertEquals("student marks not valid marks must be between 0 and 100",
                exception.getMessage());
    }
    @Test
    void testUpdateMarks() {
        Student student = service.registerStudent("TestUser", 23, 70);
        service.updateMarks(student.getId(), 90);

        Student updated = service.getStudent(student.getId());
        assertEquals(90, updated.getMarks());
    }
    @Test
    void testUpdateMarksInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.updateMarks(1, 200);
        });

        assertEquals("student marks not valid marks must be between 0 and 100",
                exception.getMessage());
    }
    @Test
    void testGetStudentNotFound() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            service.getStudent(999999);
        });
        assertEquals("student not found", exception.getMessage());
    }
}
