package com.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.entity.Employe;

public interface EmployeRepository extends JpaRepository<Employe, Integer> {

}
