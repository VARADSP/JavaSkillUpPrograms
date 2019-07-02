package com.uks.jvs.day3.ass5;

import java.text.ParseException;

/**
 * Date:20/06/2019
 * Assignment: Day 3
 * Task: Add the given number to the specified
 * date and show the result.
 *
 * @author Kailas
 */
public class TestDateAdd {

	// it contains main method
	public static void main(String args[]) throws ParseException {

		// create DateAdd class object to invoked addDate method
		DateAdd objDateAdd = new DateAdd();
		objDateAdd.addDate(args[0],args[1],args[2]);

	}

}
