/**
 * 
 */
package com.saksoft.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.saksoft.model.Employee;
import com.saksoft.repository.EmployeeRepository;

/**
 * @author HP
 *
 */
@Service
public class EmployeeService {

	@Autowired(required = true)
	private EmployeeRepository repository;
	
	public Employee saveEmployee(Employee emp) {
		return repository.save(emp);
	}
	
	public List<Employee> saveEmployees(List<Employee> emps) {
		return repository.saveAll(emps);
	}
	
	public List<Employee> getEmployee(){
		return repository.findAll();
	}
	
	public Employee getEmployeeById(int id){
		return repository.findById(id).orElse(null);
	}
	
	public Employee getEmployeeByFirstName(String firstName){
		return repository.findByFirstName(firstName);
	}
	
	public Employee getEmployeeByLastName(String lastName){
		return repository.findByLastName(lastName);
	}
	
	public String deleteEmployee(int id) {
		 repository.deleteById(id);
		 return "Data of Employees Deleted..!!";
	}
	
	public Employee updateEmployee(Employee emp) {
		Employee existingEmployee=repository.findById(emp.getId()).orElse(null);
		existingEmployee.setFirstName(emp.getFirstName());
		existingEmployee.setLastName(emp.getLastName());
		existingEmployee.seteMail(emp.geteMail());
		existingEmployee.setAge(emp.getAge());
		return repository.save(existingEmployee);
	}
}
