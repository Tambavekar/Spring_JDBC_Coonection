package com.mindgate.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Jdbc;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.mindgate.pojo.Employee;

@Repository
public class EmployeeRepository implements EmployeeRepositoryInterface {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	static final String SELECT_ALL = "select * from employee_detail";
	static final String SELECT_ONE = "select * from employee_detail where employee_id=?";
	static final String SELECT_INSERTNEW = " insert into employee_detail values(?,?,?)";
	static final String UPDATEEMPLOYEE = " update employee_detail set name=?,salary=? where employee_id=?";
	static final String DELETEEMPLOYEE = " delete from employee_detail where employee_id=?";

	@Override
	public Boolean addNewEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Object[] param = { employee.getEmployeeId(), employee.getName(), employee.getSalary() };
		int count = jdbcTemplate.update(SELECT_INSERTNEW, param);
		if (count > 0)
			return true;
		return null;
	}

	@Override
	public boolean updateEmployee(Employee employee) {
		// TODO Auto-generated method stub
		Object[] param = { employee.getName(), employee.getSalary(), employee.getEmployeeId() };
		int count = jdbcTemplate.update(UPDATEEMPLOYEE, param);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public boolean deleteEmployee(int employeeId) {
		// TODO Auto-generated method stub
		int count = jdbcTemplate.update(DELETEEMPLOYEE,employeeId);
		if (count > 0)
			return true;
		return false;
	}

	@Override
	public Employee getEmployeeByEmployeeId(int employeeId) {
		// TODO Auto-generated method stub
		EmployeeRawMapper employeeRawMapper = new EmployeeRawMapper();
		Employee employee = jdbcTemplate.queryForObject(SELECT_ONE, employeeRawMapper, employeeId);

		return employee;
	}

	@Override
	public List<Employee> getAllEmployees() {
		// TODO Auto-generated method stub
		EmployeeRawMapper employeeRawMapper = new EmployeeRawMapper();
		List<Employee> allEmployee = jdbcTemplate.query(SELECT_ALL, employeeRawMapper);
		return allEmployee;
	}

}
