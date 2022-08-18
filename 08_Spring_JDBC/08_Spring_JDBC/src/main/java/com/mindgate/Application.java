package com.mindgate;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.mindgate.pojo.Employee;
import com.mindgate.service.EmployeeService;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(Application.class, args);
		EmployeeService employeeService = applicationContext.getBean("employeeService", EmployeeService.class);

		// getEmployeeByEmployeeId
//		Employee employee=employeeService.getEmployeeByEmployeeId(1);
//		System.out.println(employee);

		// addNewEmployee
//		Employee employee = new Employee(36, "Rohan", 80001.1);
//		boolean result = employeeService.addNewEmployee(employee);
//		if (result)
//			System.out.println("Add successful");
//		else
//			System.out.println("Faild to Insert");

		// UPDATE_Employee
//		Employee employee = new Employee(36, "Updated Value", 80001.1);
//		boolean result = employeeService.updateEmployee(employee);
//		if (result)
//			System.out.println("Add successful");
//		else
//			System.out.println("Faild to Insert");

		boolean result = employeeService.deleteEmployee(36);
		if (result)
			System.out.println("Delete successful");
		else
			System.out.println("Faild to Delete");

		// getAllEmployees
//		List<Employee> allEmployees = employeeService.getAllEmployees();
//		for (Employee employee : allEmployees) {
//			System.out.println(employee);
//		}
	}

}
