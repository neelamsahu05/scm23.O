package com.TemplateUsingThymbleaf.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.TemplateUsingThymbleaf.Entity.Employee;
import com.TemplateUsingThymbleaf.Repositery.EmpRepo;
@Service
public class EmpService  {
	
     @Autowired
	private EmpRepo repo;
	
     
     
	public void addEmp(Employee emp) {
	   repo.save(emp);
	}
	
	
	public List<Employee> getAllEmp(){
		return repo.findAll(); 
		
	}
	
	public Employee EdidEmp(int id) {
		Optional<Employee> empid =  repo.findById(id);
		
		if(empid.isPresent()) {
		return	empid.get();
		}
		return null;
		
	}
	
	public void Deletemp(int id) {
		
		repo.deleteById(id);
	}
}
     
  
