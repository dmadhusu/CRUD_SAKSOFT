/**
 * 
 */
package com.saksoft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saksoft.model.Employee;
import com.saksoft.service.EmployeeService;

/**
 * @author HP
 *
 */
@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService service;
	
	@PostMapping("/addEmployee")
	public Employee addEmployee(@RequestBody Employee emp) {
		return service.saveEmployee(emp);
	}
	
	@PostMapping("/addEmployees")
	public List<Employee> addEmployees(@RequestBody List<Employee> emps) {
		return service.saveEmployees(emps);
	}
	
	@GetMapping("/employees")
	public List<Employee> findAllEmployees(){
		return service.getEmployee();
	}
	
	@GetMapping("/employee/{id}")
	public Employee findEmployeeById(@PathVariable int id) {
		return service.getEmployeeById(id);
	}
	
	@GetMapping("/employee/{firstName}")
	public Employee findEmployeeByFirstName(@PathVariable String firstName) {
		return service.getEmployeeByFirstName(firstName);
	}
	
	@GetMapping("/employee/{lastName}")
	public Employee findEmployeeByLastName(@PathVariable String lastName) {
		return service.getEmployeeByLastName(lastName);
	}
	
	@PutMapping("/addEmployee")
	public Employee updateEmployee(@RequestBody Employee emp) {
		return service.updateEmployee(emp);
	}
	
	@DeleteMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable int id) {
		return service.deleteEmployee(id);
	}
}
