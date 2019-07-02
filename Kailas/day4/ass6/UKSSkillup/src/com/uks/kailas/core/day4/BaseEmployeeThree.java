package com.uks.kailas.core.day4;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: using interfaces
 *
 * @author Kailas
 */

interface IWork {

	static void doWork() {

	}
}

/**
 * @description - IReport is an interface
 * @author - Kailas
 */
interface IReport {

	/**
	 * @description mehtod which is abstract
	 */

	// private void reportToSenior(); Illegal modifier for the interface method
	// reportToSenior; only public, abstract, default, static and strictfp are
	// permitted
	public void reportToSenior();

	void doWork();
}

public class BaseEmployeeThree implements IReport, IWork {
	String firstName = null;
	String lastName = null;
	String empType = null;
	/**
	 * Description : doWork method is abstract means it has no method definition
	 *
	 */

	private String basicSalary;

	// // parameterized constructor to get employee details
	public BaseEmployeeThree(String firstName, String lastName, String empType, String basicSalary) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.empType = empType;
		this.setBasicSalary(basicSalary);

		// display all data of employee
		System.out.println("\n Employee First Name :" + firstName + "\n Employee Last Name :" + lastName
				+ "\n Employee Type :" + empType + "\n Basic Salary :" + basicSalary);
	}

	public void setBasicSalary(String basicSalary2) {
		// TODO Auto-generated method stub

	}

	// getter method to get employee name
	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public String getEmpType() {
		return empType;
	}

	public void setEmpType(String empType) {
		this.empType = empType;
	}

	@Override
	public void doWork() {
		// TODO Auto-generated method stub

	}

	@Override
	public void reportToSenior() {
		// TODO Auto-generated method stub

	}

}
