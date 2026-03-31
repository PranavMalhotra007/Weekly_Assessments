package com.lpu.studentManagement.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.lpu.studentManagement.entity.Student;
import com.lpu.studentManagement.repository.StudentRepository;

@Service
public class StudentUserDetailsService implements UserDetailsService {
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Optional<Student> student = studentRepository.findByEmail(email);
		return new StudentUserDetails(student.get());
	}

}
