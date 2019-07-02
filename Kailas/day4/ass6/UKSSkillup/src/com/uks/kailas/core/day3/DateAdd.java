package com.uks.kailas.core.day3;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Date:20/06/2019 Assignment: Day 3 Task: Add the given number to the specified
 * date and show the result
 *
 * @author Kailas
 */
public class DateAdd {

	public void addDate(String inputDate, String addType, String addNumber) throws ParseException {
		String stringDate = inputDate;
		String stringAddType = addType;
		int intAddDay = Integer.parseInt(addNumber);
		// get string in date format using DateFormat class
		DateFormat formatter = new SimpleDateFormat("dd/mm/yyyy");
		// here we have to convert string into date object
		Date objDate = (Date) formatter.parse(stringDate);

		// get string Add type and call that case
		switch (stringAddType) {
		case "year":
			addYear(objDate, intAddDay);
			break;

		case "month":
			addMonth(objDate, intAddDay);
			break;

		case "date":
			addDay(objDate, intAddDay);
			break;

		}
	}

	// this method will get date and number of day which we want to add in date
	public static void addDay(Date date, int addDay) throws ParseException {
		Calendar objcal = Calendar.getInstance();
		objcal.setTime(date);
		objcal.add(Calendar.DAY_OF_YEAR, addDay);
		final String OLD_FORMAT = "dd/MM/YYYY"; // wants t convert date in this
												// format
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		Date d = newDateFormat.parse(newDateFormat.format(objcal.getTime()));

		// apllyPattern function will convert date format into specified format
		newDateFormat.applyPattern(OLD_FORMAT);
		String new_date = newDateFormat.format(d);
		System.out.println("after adding new days new date is :" + new_date);
	}

	// this method will get date and number of day which we want to add in month
	public static void addMonth(Date date, int addDay) throws ParseException {
		//
		Calendar objcal = Calendar.getInstance();
		objcal.setTime(date);
		objcal.add(Calendar.MONTH, addDay);
		final String OLD_FORMAT = "dd/MM/YYYY"; // wants t convert date in this
												// format
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		Date d = newDateFormat.parse(newDateFormat.format(objcal.getTime()));
		newDateFormat.applyPattern(OLD_FORMAT);
		String new_date = newDateFormat.format(d);
		System.out.println("after adding month new date is :" + new_date);

	}

	// this method will get date and number of day which we want to add in year
	public static void addYear(Date date, int addDay) throws ParseException {
		Calendar objcal = Calendar.getInstance();
		objcal.setTime(date);
		objcal.add(Calendar.YEAR, addDay); // here is add function to add the
											// given day in year using calendar
											// class
		final String OLD_FORMAT = "dd/MM/YYYY"; // wants t convert date in this
												// format
		SimpleDateFormat newDateFormat = new SimpleDateFormat("dd-MM-yy HH:mm:ss");
		Date d = newDateFormat.parse(newDateFormat.format(objcal.getTime()));

		// apllyPattern function will convert date format into specified format
		newDateFormat.applyPattern(OLD_FORMAT);
		String new_date = newDateFormat.format(d);
		System.out.println("after adding year new date is :" + new_date);

	}

}
