package com.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.dao.EmployeRepository;
import com.springboot.entity.Employe;

@Service
public class EmployeServiceImpl implements EmployeService {
	
	@Autowired
	EmployeRepository employeRepository;
	
	public EmployeServiceImpl(EmployeRepository employeRepository) {
		super();
		this.employeRepository = employeRepository;
	}

	@Override
	public Employe create(Employe employe) {
		return this.employeRepository.save(employe);
	}

	@Override
	public Employe getEmployeById(int id) {
		Employe emp=this.employeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
		return emp;
	}

	@Override
	public List<Employe> getEmploye() {
		return this.employeRepository.findAll();
	}

	@Override
	public Employe update(Employe employe, int id) {
		Employe emp=this.employeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee Not found."));
		emp.setName(employe.getName());
		emp.setCity(employe.getCity());
		emp.setAge(employe.getAge());
		
		Employe save=this.employeRepository.save(emp);
		return save;
	}

	@Override
	public void delete(int id) {
		Employe emp=this.employeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee not found"));
		this.employeRepository.delete(emp);
		
	}

}
