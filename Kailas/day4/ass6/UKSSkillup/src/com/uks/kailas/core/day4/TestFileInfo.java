package com.uks.kailas.core.day4;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Testing File Details
 *
 * @author Kailas
 */
import com.uks.kailas.core.day4.FrequencyChecker;

public class TestFileInfo {

	public static void main(String args[]) {

		try {
			// create FrequencyChecker object to call occurenceCheck(args);
			// method to pass array of words
			FileInfo objFrequencyChecker = new FileInfo();
			objFrequencyChecker.getDetails(args);
		} catch (Exception ae) {
			System.out.println("Enter the Valid Input....!!!");
		}
	}
}