/*Author: Nilesh Singh, George Mason University, MS Computer Science
 * Date: March, 9th, 2013.
 * 
 * Topic: Given an array of integers, write some code to find all the integers that appear more
 * than once in the array, sorted by which appears most often to least often (once)
 * 
 */

package com.orderSort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import com.orderSort.sortMapbyValue;

/*
 * This program takes an array of Integer as input and then count the Occurances of the Integer.
 * Based on this count value it sorts the Integers with the occurance more than 1 and stores the
 * Sorted value in ArrayList. 
 */

public class sortingArray {

	public void sortByCount(int[] arr) {
		// Requires : An integer Array
		// Effects: Sorts the Integers on the basis of their occurrence in the array.
		

		// HashMap to store the integer value and its counts.
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

		int i;

		System.out.print("Input Array is: ");

		// run a loop to traverse through the array element and count the, occurrences and store in hashmap.
		

		for (i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "\t");

			if (map.containsKey(arr[i])) {

				map.put(arr[i], map.get(arr[i]) + 1);
			} else

				map.put(arr[i], 1);
		}

		System.out.println("\n");

		// Sort the HashMap by Count Values and store the result in LinkedHashMap
		LinkedHashMap<Integer, Integer> sortedMap = sortMapbyValue.sortHashMapByValuesD(map);

		// Take an Iterator over LinkedHashMap to iterate over the sorted
		// Integer Elements.
		// We can directly print it or store in an any Data Structure . I am
		// using ArrayList.

		Iterator<?> it = sortedMap.entrySet().iterator();

		ArrayList<Integer> sortedCounts = new ArrayList<Integer>();

		ArrayList<Integer> sortedIntegers = new ArrayList<Integer>();

		while (it.hasNext()) {

			Entry<Integer, Integer> entry = (Entry<Integer, Integer>) it.next();
			int key = (int) entry.getKey();
			// System.out.println("key: " + key);

			int value = (int) entry.getValue();

			// Do not store the integer instances whose occurance is 1.
			if (value > 1) {

				sortedCounts.add(value);
				sortedIntegers.add(key);
			}

		}

		System.out.println("Sorted Integer based on number of Occurance\n");

		for (i = 0; i < sortedIntegers.size(); i++) {
			System.out.print(" " + sortedIntegers.get(i) + " ("
					+ sortedCounts.get(i) + "  times)|\t");
		}

	}

	public static void main(String[] args) {

		int[] arr = { 84, 54, 65, 77, 84, 56, 55, 98, 99, 23, 56, 3, 44, 84,
				23, 77, 77, 77, 77 };

		sortingArray s = new sortingArray();

		s.sortByCount(arr);
	}
}
