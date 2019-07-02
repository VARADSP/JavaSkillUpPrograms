package com.uks.jvs.day8.ass3;

/**
 * Date:27/06/2019
 * Assignment: Day 8
 * Task:Test Thread  in Java
 *
 * @author Kailas
 */
import java.io.IOException;

public class EmpInfoMerger {
/**
 * This method is used to take input as files
 * @param args
 * @throws IOException
 * @throws InterruptedException
 */
	public static void main(String[] args) throws IOException, InterruptedException {

		EmpInfoProperties name = new EmpInfoProperties("thread_1", "read", "C://Users/Kailas/Desktop/name.txt");
		EmpInfoProperties address = new EmpInfoProperties("thread_2", "read", "C://Users/Kailas/Desktop/address.txt");
		EmpInfoProperties merge = new EmpInfoProperties("thread_3", "write", "C://Users/Kailas/Desktop/merge.txt");
		address.start();
		name.start();
		//Thread.sleep(1000);
		merge.join();
		//thread2.sleep(1000);
		address.join();
		merge.start();
		Thread.sleep(2000);
		merge.join();
		merge.printAll();

	}
}
