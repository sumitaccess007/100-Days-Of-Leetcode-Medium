package com.sumitaccess007.TopKFrequentElements_006;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

/**
* Top K Frequent Elements - BruteForce Implementation
* STEP-1 => Traverse Array and Store in HashMap with Frequency
* STEP-2 => Sort HashMap using ArrayList (Collections.sort, Comparator)
* STEP-3 => Copy Sorted List to LinkedHashMap
* STEP-4 => Convert KeySet to Array and Print Top K Frequent Elements
* @author  Sumit Sharma
* @version 1.0
*/

public class TopKFrequentElements_BruteForce {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter number of elelements :- ");
		int n = scanner.nextInt();
		
		System.out.println("Enter value of K :- ");
		int k = scanner.nextInt();
		
		int[] nums = new int[n];
		System.out.println("Enter elements of Array :- ");
		for(int i=0; i<n; i++){
			 nums[i] = scanner.nextInt();
		}
		
		System.out.println("Elements of array are :- ");
		printArrayElements(n, nums);
		
		Map<Integer, Integer> freqMap = new HashMap<>();
		System.out.println("Calculating Frequency and Storing in HashMap");
		storeFreqInMap(n, nums, freqMap);
		
		System.out.println("Elements of HashMap are  :- ");
		printHashMap(freqMap);
		
		System.out.println("Sorting HashMap based on Value (In Desc Order) :- ");
		Map<Integer, Integer> sortedMap = sortHashMap(freqMap);
		
		System.out.println("Printing Sorted HashMap :- ");
		printHashMap(sortedMap);
		
		Object[] topKFreqArray = null;
		topKFreqArray = convertMapToArray(sortedMap, topKFreqArray);
		
		System.out.println("Top " + k + " frequent elements are - ");
		for(int i=0; i<k; i++){
			System.out.print(topKFreqArray[i] + "\t");
		}
	}

	private static Object[] convertMapToArray(Map<Integer, Integer> sortedMap, Object[] topKFreqArray) {
		return sortedMap.keySet().toArray();
	}

	private static Map<Integer, Integer> sortHashMap(Map<Integer, Integer> freqMap) {
		List<Entry<Integer, Integer>> list = new ArrayList<Map.Entry<Integer,Integer>>();
		for(Entry<Integer, Integer> entry : freqMap.entrySet()){
			list.add(entry);
		}
		
		Collections.sort(list, new Comparator<Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		Map<Integer, Integer> sortedHashMap = new LinkedHashMap<>();
		for(Entry<Integer, Integer> entry : list){
			sortedHashMap.put(entry.getKey(), entry.getValue());
		}
		
		return sortedHashMap;
	}

	private static void printHashMap(Map<Integer, Integer> freqMap) {
		for(Entry<Integer, Integer> entry : freqMap.entrySet()){
			System.out.println(entry.getKey() + " " + entry.getValue());
		}
		
	}

	private static void storeFreqInMap(int n, int[] nums, Map<Integer, Integer> freqMap) {
		for(int element : nums){
			freqMap.put(element, freqMap.getOrDefault(element, 0)+1);
		}
	}	

	private static void printArrayElements(int n, int[] nums) {
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println("\t");
	}

}
