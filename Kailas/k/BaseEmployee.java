package com.uks.jvs.day4.ass3;


/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Abstract class & overriding
 *
 * @author Kailas
 */
public abstract class BaseEmployee {

	private String firstName = null;
	private String lastName = null;
	protected String basicSalary = null;
	private String empType = null;

	/**
	 * Description : doWork method is abstract means it has no method definition
	 *
	 */
	abstract void doWork();

	// // parameterized constructor to get employee details
	public BaseEmployee(String firstName, String lastName, String empType, String basicSalary) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setEmpType(empType);
		this.basicSalary = basicSalary;

		// display all data of employee
		System.out.println("\n Employee First Name :" + firstName + "\n Employee Last Name :" + lastName
				+ "\n Employee Type :" + empType + "\n Basic Salary :" + basicSalary);
	}

	// getter method to get employee name
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

}
