package com.assess.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assess.model.Department;


public interface DepartmentRepo extends JpaRepository<Department,Integer>{

	@Query("select d.depName, d.address, e.fname,e.lname,e.age,e.profession,e.salary from Department d join d.employee e")
	List<String> getAllInfo();

}
