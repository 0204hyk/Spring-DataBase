package com.ezen.springdb.mapper;

import java.util.List;

import com.ezen.springdb.dto.Employee;

public interface EmployeeXmlMapper {
	
	public List<Employee> getAll();
	
	public Employee get(Integer employee_id);
	
	public List<Employee> getLessSalary(Integer salary);
	
	public Integer getLastId();
	
	public Integer insert(Employee emp);
}
