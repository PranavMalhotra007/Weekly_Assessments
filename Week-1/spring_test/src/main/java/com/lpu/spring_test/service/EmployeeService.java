package com.lpu.spring_test.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lpu.spring_test.entity.Employee;
import com.lpu.spring_test.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	public Employee saveEmployee(Employee e) {
		return employeeRepository.save(e);
	}
	public List<Employee> allEmployees(){
		return employeeRepository.findAll();
	}
	public String deleteEmployee(int id) {
		employeeRepository.deleteById(id);
		return "employee deleted";
	}
	public Employee findEmployeeById(int id) {
		return employeeRepository.findById(id).orElse(null);
	}
	public List<Employee> getEmployeeByName(String name){
		return employeeRepository.getEmployeeByName(name);
	}
	public List<Employee> getEmployeeByDepartment(String department){
		return employeeRepository.getEmployeeByDepartemtn(department);
	}
	public List<Employee> getEmployeeByPhone(long phone){
		return employeeRepository.getEmployeeByPhone(phone);
	}
	public List<Employee> getEmployeeByEmail(String email){
		return employeeRepository.getEmployeeByEmail(email);
	}
	public Employee updateEmployee(Employee e) {
		return employeeRepository.save(e);
	}
	public List<Employee> maxSalaryEmployee(){
		return employeeRepository.getEmployeeWithMaxSalary();
	}
	public List<Employee> minSalaryEmployee(){
		return employeeRepository.getEmployeeWithMinSalary();
	}
	public List<Employee> rangeSalary(double min,double max){
		return employeeRepository.getEmployeesWithinRange(min, max);
	}
	public List<Employee> aboveSalary(double salary){
		return employeeRepository.getEmployeesWithSalaryAbove(salary);
	}
 }
