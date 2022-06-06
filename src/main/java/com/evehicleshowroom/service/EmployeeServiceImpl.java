package com.evehicleshowroom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.evehicleshowroom.entity.Employee;
import com.evehicleshowroom.exception.DuplicateEntryException;
import com.evehicleshowroom.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;

	@Override
	public Employee addEmployee(Employee employee) 
	{
		List<Employee> employeeList = employeeRepository.findAll();
		employeeList.forEach(e -> {
		if (employee.getEmployeeEmail().equals(e.getEmployeeEmail())) {
		throw new DuplicateEntryException("Email already exists");
		}
		});
		return employeeRepository.save(employee);

	}
}
