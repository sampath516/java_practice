package com.java.treeset;

public class Employee implements Comparable<Employee> {

	private int empID;
	private int salary;

	public Employee(int empID, int salary) {
		this.empID = empID;
		this.salary = salary;
	}

	public int getEmpID() {
		return empID;
	}

	public void setEmpID(int empID) {
		this.empID = empID;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public int compareTo(Employee o) {

		if (this.salary < o.salary) {
			return -1;
		} else if (this.salary > o.salary) {
			return 1;
		}
		return 0;
	}

}
