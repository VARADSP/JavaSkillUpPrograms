package com.uks.kailas.core.day3;

import java.text.ParseException;
import java.util.Scanner;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: Date and Time Program
 *
 * @author Kailas
 */
public class TestDateAndTime {

	// it contains main method
	public static void main(String args[]) throws ParseException {

		String stringDate = "";
		// to get user input from keyboard
		Scanner objScanner = new Scanner(System.in);

		// create object of DateAndTime to call dateFormatter() method
		DateAndTime objDateAndTime = new DateAndTime();

		System.out.println("Date Format are yyyy-MM-dd \n dd-MM-YYYY \n MM/dd/yyyy");
		System.out.println("Enter Your Date Format");
		String stringDateFormat = objScanner.next();
		System.out.println("Want To Provide Date Y|N");
		String stringAnswer = objScanner.next();

		if (stringAnswer.equals("Y")) {
			// call DateFormatter() method and pass Date format and input date
			System.out.println("Enetr Date");
			objDateAndTime.dateFormater(stringDateFormat, objScanner.next());

		} else {
			objDateAndTime.dateFormater(stringDateFormat, stringDate);

		}
		objScanner.close();
	}
}
