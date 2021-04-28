package com.assess.controller;

import java.util.List;
import java.util.Optional;

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

import com.assess.model.DepartmentDto;
import com.assess.model.Employee;
import com.assess.model.Department;
import com.assess.repository.DepartmentRepo;
import com.assess.repository.EmployeeRepo;
import com.assess.service.AssesmentService;
import com.assess.util.ResponseErrorClass;

/**
 * @author Mark
 *End point class to reach data base
 */
@RestController
public class AssessController {
	
	@Autowired
	AssesmentService service;
	
	@PostMapping("save")
	public Department saveData(@RequestBody DepartmentDto departmentDto ) {
		System.out.println(departmentDto);
		return  service.saveToRep(departmentDto.getDepartment());
	//	return drepo.save(departmentDto.getDepartment());
	}
	
	@GetMapping("getAllInfo")
	public List<String> getInfo() {
		List<String> l = service.getAllInfoIn(); 
			System.out.println(l);
	
		return l;
	}
	
	@GetMapping("getAllEmp")
	public List<Employee> getAllEmployee(){
		return service.findAllEmp();
	}
	
	@GetMapping("getAllDep")
	public List<Department> getAllDepartment(){
		return service.findAllDep();
	}
	
	@GetMapping("getDepById/{id}")
	public Optional<Department> getDepartmentById(@PathVariable Integer id){
		return service.findById(id);
	}
	
	@PutMapping("changData/{depId}")
	public ResponseEntity<Department>  updateData(@PathVariable("depId") int depId, @RequestBody Department dep) {
		 Department depOut = service.findById(depId).get();
		 if(depOut==null) {
			 ResponseErrorClass err = new ResponseErrorClass("NO Record with id "+depId);
				throw err; 
		 }
		depOut.setAddress("New One");
		System.out.println("IN PUT "+depOut);
		service.saveToRep(depOut);
		return new ResponseEntity(depId, HttpStatus.OK);
	}
	
	@DeleteMapping("delete/{depId}")
	public ResponseEntity<Department> deleteData(@PathVariable("depId") int depId) {
		
		Optional<Department> depOut =service.findById(depId);
		if(depOut.isEmpty()) {
			ResponseErrorClass err = new ResponseErrorClass("NO Record with id "+depId);
			throw err;
		
		}
		service.deleteById(depId);
		
		
		
		return new ResponseEntity(depId, HttpStatus.OK);
	}

}
