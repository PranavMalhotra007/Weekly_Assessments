package com.lpu.studentManagement.service;
import java.util.List;
import com.lpu.studentManagement.entity.FileData;
import com.lpu.studentManagement.entity.Student;
public interface StudentService {
	Student saveStudent(Student s) ;
	Student findById(int id);
	List<Student> allstudents();
	String deleteStudent(int id) ;
	Student updateStudent(Student s) ;
	String uploadProfilePic(int id, FileData profilePic);
	String uploadAssignment(int id, FileData assignmentFile);
	byte[] downloadAssignmentFile(int id);
	byte[] downloadProfileImage(int id);
}
