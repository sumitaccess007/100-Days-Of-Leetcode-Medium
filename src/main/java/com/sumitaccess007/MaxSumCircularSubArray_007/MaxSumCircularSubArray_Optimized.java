package com.sumitaccess007.MaxSumCircularSubArray_007;

import java.util.Scanner;

/**
* Maximum Sum Circular Sub-Array - BruteForce Implementation
* STEP-1 => Applied Kadane's Algorithm => To find Max Sum SubArray [No-Warp Around CASE]
* STEP-2 => Applied Kadane's Algorithm => To find Min Sum SubArray [Warp Around CASE]
* STEP-3 => Total Sum of Array - Min Sum SubArray
* STEP-4 => Return Max of (STEP-1, STEP-3)
* @author  Sumit Sharma
* @version 1.0
*/

public class MaxSumCircularSubArray_Optimized {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Array Size - ");
		int numOfElements = scanner.nextInt();
		System.out.println();
		
		int[] nums = new int[numOfElements];
		System.out.print("Enter Array Elements - ");
		for(int i=0; i<numOfElements; i++){
			nums[i] = scanner.nextInt();
		}
		
		System.out.println("Array Elemets are - ");
		printArrayElements(nums);
		
		System.out.println("Calculate Max Sum SubArray - ");
		int maxSumSubArray = calculateMaxSumSubArray(nums, numOfElements);
		
		System.out.println("Max Sum SubArray is - " + maxSumSubArray);
	}

	private static int calculateMaxSumSubArray(int[] nums, int numOfElements) {
		int curBest = nums[0];
		int overallBest = nums[0];
		int curWorst = nums[0];
		int overallWorst = nums[0];
		int totalSum = nums[0];
		
		for(int i=1; i<numOfElements; i++){
			totalSum = totalSum + nums[i];
			
			curBest = Math.max(nums[i], curBest + nums[i]);
			overallBest = Math.max(overallBest, curBest);
			
			curWorst = Math.min(nums[i], curWorst + nums[i]);
			overallWorst = Math.min(overallWorst, curWorst);
		}
		if(overallWorst == totalSum){
			return overallBest;
		}
		
		return Math.max(overallBest, totalSum-overallWorst);
	}

	private static void printArrayElements(int[] nums) {
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println();
		
	}

}
