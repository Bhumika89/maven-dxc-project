package com.dxc;
import java.util.List;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.dxc.controller.EmpController;
import com.dxc.model.Employee;
import com.dxc.service.EmpService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(EmpController.class)
public class MockitoControllerTest 
{
	@Autowired
	MockMvc mockmvc;
	@MockBean
	private EmpService empservice;

	@Autowired
	ObjectMapper objectmapper;
	@Test
	public void getAllEmTest() throws Exception
	{
		mockmvc.perform(get("/employee/getall")
				.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
		verify(empservice).findAll();

	}
	@Test
	public void Posttest() throws Exception 
	{
		Employee emp=new Employee(113,"Bhumika",6788448.00,"gokak");

		mockmvc.perform(post("/employee/add")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(objectmapper.writeValueAsString(emp)))
		
		.andExpect(status().isCreated());
	}

	@Test

	public void getDetailId() throws Exception
	{
		//.andExpect(content().string("Welcome to  RestFull  webservices"));
		Employee emp=new Employee();
		mockmvc.perform(get("/employee/getdistinct/{empId}",99)
				.accept(MediaType.APPLICATION_JSON)
				.content(objectmapper.writeValueAsString(emp)))
		.andExpect(status().isOk());
	}

    /*  @Test
      public void delDetailIdTest() throws Exception
      {
    	
    	 // Employee emp=new Employee();
    	  mockmvc.perform(get("/employee/delete/{empId}",99)
    				
    						.accept(MediaType.APPLICATION_JSON)
    						.andExpect(content().string("Welcome to  RestFull  webservices")))
    				//.andExpect(status().isOk());
      }*/





}
