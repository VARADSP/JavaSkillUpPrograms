package com.uks.jvs.day4.ass3;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: extending class PLEmployee from base Abstract class
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
		this.basicSalary = basicSalary;
		mobileNumber = mobileNo;

		System.out.println("\n Employee First Name :" + empFirstName + "\n Employee Last Name :" + empLastName
				+ "\n Employee Mobile No :" + mobileNumber + "\n Employee Type :" + getEmpType()
				+ "\n Employee basic salary :" + basicSalary);
	}

	private void assignTaskToJunior() {
		System.out.println("assign Task to Junior");
	}

	private void collectReportFromJunior() {
		System.out.println("collect Report From Junior");
	}

	private void reportToSenior() {
		System.out.println("report To Senior");
	}

	/**
	 * @description - implement the doWork method of BasicEmployee class
	 */
	@Override
	void doWork() {
		assignTaskToJunior();
		collectReportFromJunior();
		reportToSenior();
	}

}