package com.springboot.service;

import java.util.List;
import com.springboot.entity.Employe;

public interface EmployeService {
	
	//add employee details
	Employe create(Employe employe);
	
	//get employee details by id 
	Employe getEmployeById(int id);
	
	//get all employee
	List<Employe> getEmploye();
	
	//update employee details
	Employe update(Employe employe,int id);
	
	//delete Employee details
	void delete(int id);
	
	
}
