package com.mindgate.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindgate.pojo.Employee;
import com.mindgate.repository.EmployeeRepositoryInterface;

@Service
public class EmployeeService implements EmployeeServiceInterface {

	@Autowired
	private EmployeeRepositoryInterface employeeRepositoryInterface;

	@Override
	public Boolean addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.addNewEmployee(employee);
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.updateEmployee(employee);
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.deleteEmployee(employeeId);
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.getEmployeeByEmployeeId(employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		return employeeRepositoryInterface.getAllEmployees();
	}

}
