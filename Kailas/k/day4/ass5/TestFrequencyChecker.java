package com.uks.jvs.day4.ass5;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Java Map Collections & Autoboxing Testing
 *
 * @author Kailas
 */
public class TestFrequencyChecker {

	public static void main(String args[]) {

		try {
			// create FrequencyChecker object to call occurenceCheck(args); method to pass array of words
			FrequencyChecker objFrequencyChecker = new FrequencyChecker();
			objFrequencyChecker.occurenceCheck(args);
		} catch (Exception ae) {
			System.out.println("Enter the Valid Input....!!!");
		}
	}
}
