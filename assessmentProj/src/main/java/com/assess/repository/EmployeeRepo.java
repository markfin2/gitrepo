package com.assess.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.assess.model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee,Integer>{

}
