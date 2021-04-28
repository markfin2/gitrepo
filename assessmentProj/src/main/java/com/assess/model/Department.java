package com.assess.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Department {

	   @Id 
	   @GeneratedValue( strategy=GenerationType.AUTO )
       private int depId;
	   
	   private String depName;
       private String address;
       @OneToMany(targetEntity = Employee.class, cascade=CascadeType.ALL)
       @JoinColumn(name="f_depId",referencedColumnName="depId")
   	   private List<Employee> employee;
      
       
   
	
	public List<Employee> getEmployee() {
		return employee;
	}
	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}
	public Department(int depId, String depName, String address, List<Employee> employee) {
		super();
		this.depId = depId;
		this.depName = depName;
		this.address = address;
		this.employee = employee;
		
	}
	public int getDepId() {
		return depId;
	}
	public void setDepId(int id) {
		this.depId = id;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	public Department() {
		
	}
	@Override
	public String toString() {
		return "Department [depId=" + depId + ", depName=" + depName + ", address=" + address + ", employee=" + employee
				+ "]";
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + depId;
		result = prime * result + ((depName == null) ? 0 : depName.hashCode());
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Department other = (Department) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (depId != other.depId)
			return false;
		if (depName == null) {
			if (other.depName != null)
				return false;
		} else if (!depName.equals(other.depName))
			return false;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		return true;
	}
	
	
       
       
}

