package com.dxc.repo;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.dxc.model.Employee;

public interface EmpRepo  extends MongoRepository<Employee, Integer> 
{

} 


