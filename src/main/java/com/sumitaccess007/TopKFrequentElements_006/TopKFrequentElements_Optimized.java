package com.sumitaccess007.TopKFrequentElements_006;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
* Top K Frequent Elements - BruteForce Implementation
* STEP-1 => Traverse Array and Store in HashMap
* STEP-2 => 
* @author  Sumit Sharma
* @version 1.0
*/

public class TopKFrequentElements_Optimized {

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
		
		System.out.println("Create Priority Queue (i.e. Min Heap) of Size" + k + " :- ");
		PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
				return o1.getValue() - o2.getValue();
			}
		});
		
		System.out.println("Store in MinHeap :- ");
		buildMinHeap(minHeap, freqMap, k);
		
		System.out.println("Print MinHeap :-");
		printMinHeap(minHeap);
		

		
		System.out.println("Store MinHeap in array of size " + k + " - ");
		int[] topKFreElement = new int[k];
		topKFreElement = storeMinHeapInArray(topKFreElement, minHeap, k);
		
		System.out.println("Top " + k + " frequent elemts are - ");
		printArrayElements(n, topKFreElement);
	}



	private static int[] storeMinHeapInArray(int[] topKFreElement, PriorityQueue<Entry<Integer, Integer>> minHeap,
			int k) {
		int[] result = new int[k];
		for(int i=0; i<k; i++){
			result[i] = minHeap.poll().getKey();
		}
		return result;
	}



	private static void printMinHeap(PriorityQueue<Entry<Integer, Integer>> minHeap) {
		Iterator<Map.Entry<Integer, Integer>> iterator = minHeap.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
		
	}



	private static void buildMinHeap(PriorityQueue<Entry<Integer, Integer>> minHeap, Map<Integer, Integer> freqMap,
			int k) {
		for(Entry<Integer, Integer> entry : freqMap.entrySet()){
			minHeap.add(entry);
			if(minHeap.size() > k){
				minHeap.poll();
			}
		}
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
