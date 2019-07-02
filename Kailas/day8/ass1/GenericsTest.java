package com.uks.jvs.day8.ass1;

/**
 * Date:27/06/2019
 * Assignment: Day 8
 * Task: Generic classes in Java
 *
 * @author Kailas
 */
import java.util.HashMap;
import java.util.Scanner;


public class GenericsTest {
	/**
	 * This method is used to perform addToDictionary
	 *
	 * @return
	 */
	public HashMap<Long, String> addToDictionary() {

		// create instance of hashmap
		HashMap<Long, String> hmap = new HashMap<Long, String>();

		hmap.put(9987123456L, "Jacob");
		hmap.put(9819123456L, "Jenny");

		hmap.put(9819123456L, "Jenny");
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter how many name to add");
		int choice = scanner.nextInt();

		for (int i = 0; i < choice; i++) {
			System.out.println("Enter the mobile number:");
			Long mobileNum = scanner.nextLong();
			//String mobNo = Long.toString(mobileNum);
			System.out.println("Enter the name:");
			String firstName = scanner.next();

			// when i am trying to add mobile number in string it bwill give compilation error
			//hmap.put(mobileNum, firstName);
			hmap.put(mobileNum, firstName);

		}
		// print message to view to contact
		System.out.println("print data yes or no");
		String msg = scanner.next();
		boolean isok = msg.equalsIgnoreCase("yes");
		if (isok)
			printAll(hmap);
		else
			System.exit(0);
		return hmap;


	}

	/**
	 * This method is used to perform searching
	 *
	 * @param hmap
	 * @param mobileNum
	 */
	public void SearchMobile(HashMap<Long, String> hmap, Long mobileNum) {
		for (Long Mobno : hmap.keySet()) {
			boolean isok = Mobno.equals(mobileNum);
			if (isok) {
				System.out.println("name:" + hmap.get(mobileNum));
			}
		}
	}

	/**
	 * This method is used to perform print operation
	 *
	 * @param hmap
	 */
	public void printAll(HashMap<Long, String> hmap) {
		for (Long mobNo : hmap.keySet()) {
			System.out.println("Name:" + hmap.get(mobNo));
			System.out.println("Mobile:" + mobNo);
		}
	}
}
