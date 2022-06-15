package com.sumitaccess007.MaxSumCircularSubArray_007;

import java.util.Scanner;

/**
* Maximum Sum Circular Sub-Array - BruteForce Implementation
* STEP-1 => Applied Kadane's Algorithm => To find Max Sum SubArray
* STEP-2 => Invert Sign of Array Elements
* STEP-2 => Applied Kadane's Algorithm => To find Max Sum SubArray
* STEP-3 => Total Sum of Array + Max Sum SubArray
* STEP-4 => Return Max of (STEP-1, STEP-3)
* @author  Sumit Sharma
* @version 1.0
*/

public class MaxSumCircularSubArray_BruteForce3 {

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
		int totalSum = 0;
		int maxSumOfOriginal = kadaneAlgorithm(nums);
		for(int i=0; i<numOfElements; i++){
			totalSum = totalSum + nums[i];
			nums[i] = -nums[i];
		}
		int maxSumOfInverted = kadaneAlgorithm(nums);
		if(totalSum + maxSumOfInverted == 0){
			return maxSumOfOriginal;
		}
		return Math.max(maxSumOfOriginal, totalSum + maxSumOfInverted);
	}

	private static int kadaneAlgorithm(int[] nums) {
		int curBest = nums[0];
		int overallBest = nums[0];
		for(int i=1; i<nums.length; i++){
			curBest = Math.max(curBest + nums[i], nums[i]);
			overallBest = Math.max(curBest, overallBest);
			
		}
		return overallBest;
	}

	private static void printArrayElements(int[] nums) {
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println();
		
	}

}
