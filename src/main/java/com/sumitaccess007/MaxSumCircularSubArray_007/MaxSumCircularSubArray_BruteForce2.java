package com.sumitaccess007.MaxSumCircularSubArray_007;

import java.util.Scanner;

/**
* Maximum Sum Circular Sub-Array - BruteForce Implementation
* STEP-1 => Applied Kadane's Algorithm N Times by Wrapping Around the Array
* @author  Sumit Sharma
* @version 1.0
*/

public class MaxSumCircularSubArray_BruteForce2 {

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
		
		System.out.println("Create New Array of Twice Size - ");
		int[] nums2 = new int[numOfElements*2];
		for(int i=0; i<numOfElements*2; i++){
			nums2[i] = nums[i % numOfElements];
		}
		System.out.println("New Array Elemets are - ");
		printArrayElements(nums2);
		
		int maxSumSubArray = getMaxSumSubArray(nums2);
		System.out.println("Max Sum SubArray is - " + maxSumSubArray);
	}

	private static int getMaxSumSubArray(int[] nums2) {
		int currBestSum = Integer.MIN_VALUE;
		int overAllBestSum = Integer.MIN_VALUE;
		int left = 0;
		int right = 0;
		
		for(int i=0; i<nums2.length; i++){
			if((right - left + 1) == nums2.length){
				currBestSum = currBestSum + nums2[left];
				if(currBestSum > 0){
					currBestSum = currBestSum + nums2[right];
				} else {
					currBestSum = nums2[right];
				}
				if(currBestSum > overAllBestSum){
					overAllBestSum = currBestSum;
				}
				left++;
				right++;
			} else {
				
			}
			
		}
		return overAllBestSum;
	}

	private static void printArrayElements(int[] nums) {
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println();
		
	}

}
