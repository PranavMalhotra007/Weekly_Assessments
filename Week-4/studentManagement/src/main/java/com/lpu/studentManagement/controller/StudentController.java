package com.lpu.studentManagement.controller;
import java.io.IOException;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lpu.studentManagement.entity.FileData;
import com.lpu.studentManagement.entity.Student;
import com.lpu.studentManagement.service.StudentService;
@RestController
public class StudentController {
	private StudentService studentService;
	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	@PostMapping("/register")
	public ResponseEntity<Student> saveStudnet(@RequestBody Student s) {
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(studentService.saveStudent(s));
	}
	@GetMapping("/find/{id}")
	public ResponseEntity<Student> findById(@PathVariable int id) {
		return  ResponseEntity.status(HttpStatus.FOUND)
				.body(studentService.findById(id));
	}
	@GetMapping("/find")
	public  ResponseEntity<List<Student>> allstudents(){
		return ResponseEntity.status(HttpStatus.FOUND)
				.body(studentService.allstudents());
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable int id) {
		return ResponseEntity.status(HttpStatus.GONE)
				.body(studentService.deleteStudent(id));
	}
	@PutMapping("/update")
	public  ResponseEntity<Student> updateStudent(@RequestBody Student s) {
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(studentService.updateStudent(s));
	}
	@PutMapping("/upload/{id}")
	public ResponseEntity<String> uploadProfile(@RequestParam("profilePic")MultipartFile file,@PathVariable int id )throws IOException{
		FileData profilePic = new FileData();
		profilePic.setFileName(file.getOriginalFilename());
		profilePic.setFieldType(file.getContentType());
		profilePic.setData(file.getBytes());
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(studentService.uploadProfilePic(id,profilePic));
	}
	@PutMapping("/upload/assignment/{id}")
	public ResponseEntity<String> uploadAssignment(@RequestParam("assignmentFile")MultipartFile file, @PathVariable int id )throws IOException{
		FileData assignmentFile = new FileData();
		assignmentFile.setFileName(file.getOriginalFilename());
		assignmentFile.setFieldType(file.getContentType());
		assignmentFile.setData(file.getBytes());
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(studentService.uploadAssignment(id,assignmentFile));
	}
	@GetMapping("/download/profile/{id}")
	public ResponseEntity<byte[]> downloadProfileImage(@PathVariable int id)
	{
		return ResponseEntity.ok()
				.contentType(MediaType.IMAGE_JPEG)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
				.body(studentService.downloadProfileImage(id));
	}
	@GetMapping("/download/assignment/{id}")
	public ResponseEntity<byte[]> downloadAssignmentFile(@PathVariable int id)
	{
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_PDF)
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment")
				.body(studentService.downloadAssignmentFile(id));
	}
}