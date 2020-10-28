package com.dxc.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.dxc.model.Employee;
import com.dxc.service.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("/employee")
public class EmpController 
{
	@Autowired
	private EmpService empservice;
	ObjectMapper objectmapper;

	@GetMapping("/getall")
	public List<Employee> getAllDetails()
	{
		return empservice.findAll();
	}

	@PostMapping("/add")
	public Employee addAll(@RequestBody Employee employee)
	{
		return empservice.addEmployee(employee);
	}

	@GetMapping("/getdistinct/{empId}")
	public Optional<Employee> getById(@PathVariable int empId)
	{
		return empservice.findById(empId);
	}

	@DeleteMapping("/delete/{empId}")
	public String deleteById(@PathVariable int empId)
	{
		return empservice.deleteById(empId);
	}

	@PutMapping("/update/{empId}")
	public Employee updateRecord(@PathVariable int empId,@RequestBody Employee emp) 
	{
		return empservice.updateRecord(empId, emp);
	}

}
