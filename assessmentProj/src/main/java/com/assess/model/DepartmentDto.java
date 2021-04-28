package com.assess.model;



public class DepartmentDto {

	private Department department;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public DepartmentDto(Department departments) {
		
		this.department = department;
	}
	
	public DepartmentDto() {
		
	}

	@Override
	public String toString() {
		return "DepartmentDto [departments=" + department + "]";
	}

	
	

	

	
	
	
	
}
