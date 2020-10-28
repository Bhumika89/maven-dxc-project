package com.dxc;

import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.dxc.model.Employee;
import com.dxc.repo.EmpRepo;
import com.dxc.service.EmpService;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
@SpringBootTest
public class EmployeeMockitoTest 
{
	@Autowired
	private EmpService empservice;

	@MockBean
	private EmpRepo emprepository;

	@Test
	public void getEmployeeTest()
	{
		Employee emp=new Employee(113,"Nikhil",20000.00,"gokak");
		Employee emp1=new Employee(114,"Nikhil",20000.00,"gokak");
		when(emprepository.findAll())
		.thenReturn(Stream.of(emp,emp1).collect(Collectors.toList()));
		assertEquals(2,empservice.findAll().size());
		verify(emprepository).findAll();
		verify(emprepository,atLeastOnce()).findAll();
		verify(emprepository,times(1)).findAll();
	}

	@Test 
	public void saveEmployeeTest()
	{
		Employee emp=new Employee(113,"Nikhil",20000.00,"gokak");
		when(emprepository.save(emp)).thenReturn(emp);
		assertEquals(emp,empservice.addEmployee(emp));

	}
	@Test
	public void empIdTest()
	{ 
		Optional<Employee> emp=Optional.of(new Employee(113,"Nikhil",20000.00,"gokak"));
		when(emprepository.findById(113)).thenReturn(emp);
		assertEquals(emp,empservice.findById(113));

	}
	@Test
	public void  empDelId()
	{
		//Optional<Employee> emp=Optional.of(new Employee(113,"Nikhil",20000.00,"gokak"));
		Optional<Employee> emp=Optional.of(new Employee(113,"Nikhil",20000.00,"gokak"));
		String str="deleted sucessfully";
		when(emprepository.findById(113)).thenReturn(emp);

		assertEquals(str,empservice.deleteById(113));

	}
	@Test
	public void updateDataTest()
	{
		Optional<Employee> emp=Optional.of(new Employee(113,"Nikhil",20000.00,"gokak"));
		when(emprepository.findById(113)).thenReturn(emp);
		Employee emp2=emp.get();
		emp2.setLocation("goa");
		emprepository.save(emp2);
		Optional<Employee> emp3=Optional.of(new Employee(113,"Nikhil",20000.00,"gokak"));
		when(emprepository.findById(113)).thenReturn(emp3);
		Employee emp4=emp.get();
	     assertEquals(	emp2,empservice.updateRecord(113,emp4));
		
    }
	


}
