package com.dxc.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.dxc.model.Employee;
import com.dxc.repo.EmpRepo;

@Service
public class EmpService 
{
	@Autowired
	private EmpRepo emprepository;

	public List<Employee> findAll()
	{
		return emprepository.findAll() ;
	}

	public Employee addEmployee(Employee employee)
	{
		emprepository.save(employee);
		return employee;
	}

	public Optional<Employee> findById(int empId)
	{
		return emprepository.findById(empId);
	}

	public String deleteById(int empId)
	{
		emprepository.deleteById(empId);
		return "deleted sucessfully";
	}

	public Employee updateRecord(int empId, Employee employee)
	{

		Optional<Employee> emp1	=emprepository.findById(empId);
		Employee emp=  emp1.get();
		System.out.println(emp);
		emp.setLocation(employee.getLocation());
		System.out.println(emp);
	return (emprepository.save(emp));
		//return emp2;
	}

}
