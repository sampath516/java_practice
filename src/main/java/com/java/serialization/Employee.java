package com.java.serialization;


public class Employee  {

	protected String name;
	protected String id;
	protected float salary;
	protected transient Department department;
	
	public Employee() {
	}

	public Employee(String name, String id, float salary, Department department) {
		this.name = name;
		this.id = id;
		this.salary = salary;
		this.department = department;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public float getSalary() {
		return salary;
	}

	public void setSalary(float salary) {
		this.salary = salary;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

}
