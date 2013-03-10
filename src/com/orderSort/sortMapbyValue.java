/*Author: Nilesh Singh, George Mason University, MS Computer Science
 * Date: March, 9th, 2013.
 * 
 * Topic: Helper class to the main Class. It takes the HashMap as input and sorts the HashMap by decending values.
 * 
 */

package com.orderSort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;

public class sortMapbyValue {

	public static LinkedHashMap<Integer, Integer> sortHashMapByValuesD(
			HashMap<Integer, Integer> passedHashMap) {
		// Requires: HashMap as input
		// Effects: returns a sorted LinkedHashMap by descending values.

		// Use 2 arraylist to store the keys and values of the Map.
		ArrayList<Integer> mapKeys = new ArrayList<Integer>(
				passedHashMap.keySet());
		ArrayList<Integer> mapValues = new ArrayList<Integer>(
				passedHashMap.values());

		// Used Java`s collection method to sort the arraylist in ascending
		// order and then reversed it to get the descending order sort.
		Collections.sort(mapValues);
		Collections.reverse(mapValues);

		Collections.sort(mapKeys);
		Collections.reverse(mapKeys);

		LinkedHashMap<Integer, Integer> sortedMap = new LinkedHashMap<Integer, Integer>();

		// Iterator over the mapValue ArrayList
		Iterator<Integer> valueItr = (mapValues).iterator();

		while (valueItr.hasNext()) {
			int val = (int) valueItr.next();

			// Iterator over Key ArrayList
			Iterator<Integer> keyItr = (mapKeys).iterator();

			while (keyItr.hasNext()) {
				int key = (int) keyItr.next();

				String comp1 = String.valueOf(passedHashMap.get(key));
				String comp2 = String.valueOf(val);

				if (comp1.equals(comp2)) {
					passedHashMap.remove(key);

					sortedMap.put(key, val);
					break;
				}

			}

		}
		return sortedMap; // return the Descending order sorted by Values LinkedHashMap
							 
	}
}
