package com.TemplateUsingThymbleaf.Repositery;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.TemplateUsingThymbleaf.Entity.Employee;

@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
