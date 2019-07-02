package com.uks.varad.core.day2.assignment1;
import java.util.Scanner;
/**
 * @author Varad Parlikar Day2 Assignment1
 */
public class ArrayPopulation {//
    /**
     * Class ArrayPopulation to populate array and print array
     * @author: Varad Parlikar
     * Created Date: 2019/06/19
     */
    public int[] populateArray(int[] array1, int[] array2, int size) {//
        /**
         * method to populate array and return merged array
         * @array1
         * @array2
         * @size
         * return type : int[]
         */
        Scanner sc = new Scanner(System.in);
        int resultArraySize = size * 2;
        int[] resultArray = new int[resultArraySize];//result array
        System.out.println("Enter elements for array1");
        for (int i = 0; i < size; i++) { // For reading the element of array1
            array1[i] = sc.nextInt();
        }
        System.out.println("Enter elements for array2");
        for (int i = 0; i < size; i++) { // For reading the element of array2
            array2[i] = sc.nextInt();
        }
        int iterator1 = 0; // Creating resultant array
        int iterator2 = 0;
        for (int i = 0; i < resultArraySize; i++) {
            if (i % 2 != 0) {//for odd places
                resultArray[i] = array1[iterator1++];
            } else {//for even places
                resultArray[i] = array2[iterator2++];
            }
        }
        sc.close();
        return resultArray;
    }
    public void print(int[] array) {//
        /**
         * method to print array elements
         * return type : void
         */
        for (int i : array) {
            System.out.print(i + " ,");
        }
    }
}