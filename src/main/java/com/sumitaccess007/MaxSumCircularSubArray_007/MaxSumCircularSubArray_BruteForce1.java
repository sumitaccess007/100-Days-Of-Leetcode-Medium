package com.sumitaccess007.MaxSumCircularSubArray_007;

import java.util.Scanner;

/**
* Maximum Sum Circular Sub-Array - BruteForce Implementation
* STEP-1 => Applied Kadane's Algorithm N Times by Wrapping Around the Array
* @author  Sumit Sharma
* @version 1.0
*/

public class MaxSumCircularSubArray_BruteForce1 {

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
		
		int maxSumSubArray = getMaxSumSubArray(nums);
		System.out.println("Max Sum SubArray is - " + maxSumSubArray);
	}

	private static int getMaxSumSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int currBestSum;
		int overAllBestSum;
		
		for(int i=0; i<nums.length; i++){
			currBestSum = nums[i];
			overAllBestSum = nums[i];
			for(int j=i+1; j<((i+1)+nums.length-1); j++){
				if(currBestSum >= 0){
					currBestSum = currBestSum + nums[j % nums.length];
				} else {
					currBestSum = nums[j % nums.length];
				}
				if(currBestSum > overAllBestSum){
					overAllBestSum = currBestSum;
				}
			}
			if(overAllBestSum > maxSum){
				maxSum = overAllBestSum;
			}
		}
		
		return maxSum;
	}

	private static void printArrayElements(int[] nums) {
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println();
		
	}

}
