package com.dsasheet450.MaxMinInArray_002;

import java.util.Scanner;

/**
* Array - Max and Min of an Array - With Minimum Comparsions - 002
* - Tournament Method
* - Time Complexity - O(N)
* - Space Complexity - O(1)
* - Best Case - When Ascending Array - 1+(n-2) Comparsions
* - Worst Case - When Descending Array - 1+2(n-2) Comparsions
* @author  Sumit Sharma
* @version 1.0
*/


public class MaxMinInArray_03 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Size Of Array - ");
		int numOfElements = scanner.nextInt();
		
		int[] nums = new int[numOfElements];
		System.out.println("Enter Array Elements - ");
		for(int i=0; i<numOfElements; i++){
			nums[i] = scanner.nextInt();
		}
		
		Pair pair = new Pair();

		printArrayElements(nums);
		
		Pair minmax = getMinMaxInArray(nums, pair);
		
		System.out.println("Minimum Element is - " + minmax.min);
		System.out.println("Maximum Element is - " + minmax.max);
		
	}
	
	private static Pair getMinMaxInArray(int[] nums, Pair pair) {
		// If Array contains only one element
		if(nums.length == 1){
			pair.min = nums[0];
			pair.max = nums[0];
			return pair;
		}
		
		// If array contains more than one element
		if(nums[0] < nums[1]){
			pair.min = nums[0];
			pair.max = nums[1];
		} else {
			pair.min = nums[1];
			pair.max = nums[0];
		}
		
		for(int i=2; i<nums.length; i++){
			if(nums[i] > pair.max){
				pair.max = nums[i];
			} else if(nums[i] < pair.min){
				pair.min = nums[i];
			}
		}
		return pair;
	}

	public static void printArrayElements(int[] nums){
		System.out.println("Array Elements are - ");
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println();
	}
	
	public static class Pair{
		int min;
		int max;
	}
}
