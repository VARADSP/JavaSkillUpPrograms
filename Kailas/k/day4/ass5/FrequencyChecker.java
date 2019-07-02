package com.uks.jvs.day4.ass5;

/**
 * Date:21/06/2019
 * Assignment: Day 4
 * Task: Java Map Collections & Autoboxing
 *
 * @author Kailas
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FrequencyChecker {
	/**
	 * @description - show the count of a word
	 *
	 */
	public void occurenceCheck(String args[]) {

		// convert array into String format
		String words = Arrays.toString(args).replace("[", "").replace("]", "").replace(",", "");
		System.out.println("String of words: " + words);

		// use Hash map to store words and their count
		Map<String, Integer> map = new HashMap<>();

		// using fore-each loop to get word count
		for (String eachWord : args) {
			Integer wordCount = map.get(eachWord);

			// if word count is null then word is not match
			if (wordCount == null)
				wordCount = 1;
			else
				++wordCount;
			// store words and word count to hash map
			map.put(eachWord, Integer.valueOf(wordCount));
		}

		// get the words and count using for-each loop
		for (String typeKey : map.keySet()) {
			String key = typeKey.toString();
			String value = map.get(key).toString();
			System.out.println(key + "  " + value);
		}
	}
}