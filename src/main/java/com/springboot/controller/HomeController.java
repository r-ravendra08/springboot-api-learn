package com.springboot.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springboot.entity.Employe;
import com.springboot.service.EmployeService;


@RestController
public class HomeController {

	@Autowired
	private EmployeService employeService;
	
	
	//add employee controller
	@PostMapping("/add-employee")
	public ResponseEntity<Employe> add(@RequestBody Employe employe) {
		Date date=new Date();
		employe.setDate(date);//set current date
		Employe emp=this.employeService.create(employe);
		
		return new ResponseEntity<Employe>(emp,HttpStatus.CREATED) ;
	}
	
	//get-all employee controller
	@GetMapping("/get-employee")
	public ResponseEntity<List<Employe>> getAllEmploye(){
		List<Employe> emp=this.employeService.getEmploye();
		return new ResponseEntity<>(emp,HttpStatus.OK);
	}
	
	//get employee details by id 
	@GetMapping("/get-employe/{id}")
	public ResponseEntity<Employe>getEmpById(@PathVariable int id){
		Employe emp=this.employeService.getEmployeById(id);
		return new ResponseEntity<Employe>(emp,HttpStatus.OK);
	}
	//delete employee controller
	@DeleteMapping("delete-employe/{id}")
	public ResponseEntity<Map<String,String>>deleteEmploye(@PathVariable int id){
		this.employeService.delete(id);
		Map<String,String>message=Map.of("message","employee deleted successfully");
		return new ResponseEntity<>(message,HttpStatus.OK);
	}
	
	//update employee controller
	@PutMapping("/update-employe/{id}")
	public ResponseEntity<Employe>updateEmploye(@RequestBody Employe employe,@PathVariable int id){
		Employe emp=this.employeService.update(employe, id);
		return new ResponseEntity<Employe>(emp,HttpStatus.OK);	
	}
}
