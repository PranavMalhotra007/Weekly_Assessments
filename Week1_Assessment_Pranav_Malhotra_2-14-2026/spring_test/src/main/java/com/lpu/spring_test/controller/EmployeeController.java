package com.lpu.spring_test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lpu.spring_test.entity.Employee;
import com.lpu.spring_test.service.EmployeeService;
@RequestMapping("/api/employees")
@RestController
public class EmployeeController {
	@Autowired
	private EmployeeService employeeService;
	@PostMapping
	public Employee saveEmployee(@RequestBody Employee e) {
		return employeeService.saveEmployee(e);
	}
	@GetMapping
	public List<Employee> findAllEmployee(){
		return employeeService.allEmployees();
	}
	@GetMapping(params = "id")
	public Employee findEmployeeById(@RequestParam int id) {
		return employeeService.findEmployeeById(id);
	}
	@PutMapping
	public Employee updateEmployee(@RequestBody Employee e) {
		return employeeService.updateEmployee(e);
	}
	@DeleteMapping
	public String deleteEmployee(@RequestParam int id) {
		return employeeService.deleteEmployee(id);
	}
	@GetMapping(value = "/search" , params = "name" )
	public List<Employee> searchByName(@RequestParam String name){
		return employeeService.getEmployeeByName(name);
	}
	@GetMapping(value = "/search" , params = "department" )
	public List<Employee> searchByDepartemnt(@RequestParam String department){
		return employeeService.getEmployeeByDepartment(department);
	}
	@GetMapping(value = "/search" , params = "phone" )
	public List<Employee> searchByPhone(@RequestParam long phone){
		return employeeService.getEmployeeByPhone(phone);
	}
	@GetMapping(value = "/search" , params = "email" )
	public List<Employee> searchByEmail(@RequestParam String email){
		return employeeService.getEmployeeByEmail(email);
	}
	@GetMapping("/search/max")
	public List<Employee> searchMax(){
		return employeeService.maxSalaryEmployee();
	}
	@GetMapping("/search/min")
	public List<Employee> searchMin(){
		return employeeService.minSalaryEmployee();
	}
	@GetMapping(value = "/search" , params = "salary" )
	public List<Employee> searchByEmail(@RequestParam double salary){
		return employeeService.aboveSalary(salary);
	}
	@GetMapping(value = "/search" , params = {"min","max"})
	public List<Employee> searchByEmail(@RequestParam double min, @RequestParam double max){
		return employeeService.rangeSalary(min, max);
	}
}
