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

public class Member {

	public static void main(String[] args) {
		try {
			GenericsTest GenericsTest = new GenericsTest();
			HashMap<Long, String> hmap = new HashMap<Long, String>();

			hmap.put(9987123456L, "Jacob");
			hmap.put(9819123456L, "Jenny");

			// to display hash map data
			GenericsTest.printAll(hmap);

			// call addToDictionary function to pass mobile number and name
			HashMap<Long, String> list = GenericsTest.addToDictionary();
			@SuppressWarnings("resource")
			Scanner scanner = new Scanner(System.in);
			System.out.println("Enter the mobile number to search data");
			System.out.println("yes or no");
			String msg = scanner.next();
			boolean isok = msg.equalsIgnoreCase("yes");
			if (isok) {
				System.out.println("Enter the mobile number(jacob and jenny):");
				Long mobileNum = scanner.nextLong();
				GenericsTest.SearchMobile(hmap, mobileNum);
			} else {
				System.exit(0);
			}
			System.out.println("Enter the name to search");
			System.out.println("yes or no");
			String msg1 = scanner.next();
			boolean isok1 = msg1.equalsIgnoreCase("yes");
			if (isok1) {
				System.out.println("Enter the mobile number(newone):");
				Long mobileNum = scanner.nextLong();
				GenericsTest.SearchMobile(list, mobileNum);
			} else {
				System.exit(0);
			}

		} catch (Exception ex) {
			//ex.printStackTrace();
			System.out.println("EXCEPTION occured");
		}
	}
}
