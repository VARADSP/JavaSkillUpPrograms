package com.uks.kailas.core.day3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: Date and Time Program
 *
 * @author Kailas
 */
public class DateAndTime {

	/**
	 * Description : this method contain two arguments date format and date
	 *
	 * @param stringDateFormat
	 * @param stringDate
	 * @throws ParseException
	 */
	public void dateFormater(String stringDateFormat, String stringDate) throws ParseException {
		SimpleDateFormat objDateFormat = new SimpleDateFormat(stringDateFormat);
		// check date parameter is empty or not
		if (stringDate.isEmpty()) {
			Date objDate = new Date(); // to access date related classes and
										// methods
			// here we can print formatted date using SimplDateFormat class and
			// format(0 method to display date
			System.out.println("Your given formatted Todays Date " + objDateFormat.format(objDate));

		} else {

			DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");

			Date objDate = (Date) formatter.parse(stringDate);// here we have to
																// convert
																// string into
																// date object
			SimpleDateFormat objsdf = new SimpleDateFormat("yyyy/mm/dd");
			String date_final = objsdf.format(objDate);
			System.out.println("date is:" + date_final);
		}
	}

}
