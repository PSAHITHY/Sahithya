package com.evehicleshowroom.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.evehicleshowroom.entity.Employee;
import com.evehicleshowroom.repository.EmployeeRepository;

@SpringBootTest
 class EmployeeServiceTest {
	@InjectMocks
	private EmployeeService employeeService = new EmployeeServiceImpl();

	@Mock
	private EmployeeRepository employeeRepository;

	@Test
 void testAddEmployeeDetails() {
		Employee emp = new Employee();
		emp.setEmployeeId(1);
		emp.setEmployeeName("Meghana");
		emp.setEmployeePhone("123456");
		emp.setEmployeeEmail("meghana@gmail.com");
		emp.setEmployeeDesignation("Analyst");
		emp.setEmployeeAddress("Hyderabad");

		when(employeeRepository.save(emp)).thenReturn(emp);
		Employee employee = employeeService.addEmployee(emp);
		assertEquals("Meghana", employee.getEmployeeName());
		assertEquals("Hyderabad", employee.getEmployeeAddress());
	}

}
