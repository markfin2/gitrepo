package com.assess.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assess.model.Department;
import com.assess.model.Employee;
import com.assess.repository.DepartmentRepo;
import com.assess.repository.EmployeeRepo;

/**
 * @author Mark
 * intermediate layer to back end
 */
@Service
public class AssesmentService {
      
	@Autowired
	DepartmentRepo drepo;
	
	@Autowired
	EmployeeRepo erepo;

	public Department saveToRep(Department department) {
		// TODO Auto-generated method stub
		return drepo.save(department);
	}

	public List<String> getAllInfoIn() {
		// TODO Auto-generated method stub
		return drepo.getAllInfo();
	}

	public List<Employee> findAllEmp() {
		// TODO Auto-generated method stub
		return erepo.findAll();
	}

	public List<Department> findAllDep() {
		// TODO Auto-generated method stub
		return drepo.findAll();
	}

	public Optional<Department> findById(Integer id) {
		// TODO Auto-generated method stub
		return drepo.findById(id);
	}

	public void deleteById(int depId) {
		drepo.deleteById(depId);
		
	}

	
}
