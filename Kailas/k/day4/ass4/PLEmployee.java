package com.uks.jvs.day4.ass4;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: extending class PLEmployee from base
 * class implemented by interfaces
 *
 * @author Kailas
 */
// extending class
class PLEmployee extends BaseEmployee {
	private String mobileNumber;

	public PLEmployee(String firstName, String lastName, String empType, String basicSalary) {
		super(firstName, lastName, empType, basicSalary);
		// TODO Auto-generated constructor stub
	}

	// display PLEmployee data
	public void showPLdata(String empFirstName, String empLastName, String basicSalary, String mobileNo) {
		setFirstName(empFirstName);
		setLastName(empLastName);
		setEmpType("PL");
		this.setBasicSalary(basicSalary);
		mobileNumber = mobileNo;
		System.out.println("\n Employee First Name :" + empFirstName + "\n Employee Last Name :" + empLastName
				+ "\n Employee Mobile No :" + mobileNumber + "\n Employee Type :" + getEmpType()
				+ "\n Employee basic salary :" + basicSalary);
	}

	private void setLastName(String empLastName) {
		// TODO Auto-generated method stub

	}

	private void setFirstName(String empFirstName) {
		// TODO Auto-generated method stub

	}

	// Below are the different methods for different behaviour which would be
	// called by needed class
	public void assignTaskToJunior() {
		System.out.println("Assign task to junior!");
	}

	public void collectReportFromJunior() {
		System.out.println("Collect Report from Junior");
	}

	public void doWork() {
		System.out.println("Dowork() method called from interface implemented in BaseEmployee class");
		assignTaskToJunior();
		collectReportFromJunior();
	}

	public void reportToSenior() {
		System.out.println("ReportToSenior method called from interface implemented in BaseEmployee class ");
	}

}