package com.assess.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
public class Employee {
	
	@Id 
//	@GeneratedValue( strategy=GenerationType.AUTO )
    int eid;
	
	private String fname;
	private String lname;
	private int age;
	private String profession;
	private double salary;
	
	public int getEid() {
		return eid;
	}
	public void setEid(int eid) {
		this.eid = eid;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getLname() {
		return lname;
	}
	public void setLname(String lname) {
		this.lname = lname;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getProfession() {
		return profession;
	}
	public void setProfession(String profession) {
		this.profession = profession;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public Employee(int eid, String fname, String lname, int age, String profession, double salary) {
		super();
		this.eid = eid;
		this.fname = fname;
		this.lname = lname;
		this.age = age;
		this.profession = profession;
		this.salary = salary;
		
		
	}
	public Employee() {
	}
	@Override
	public String toString() {
		return "Employee [eid=" + eid + ", fname=" + fname + ", lname=" + lname + ", age=" + age + ", profession="
				+ profession + ", salary=" + salary + "]";
	}
	
	
	
}
