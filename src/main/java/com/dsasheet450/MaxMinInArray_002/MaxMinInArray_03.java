package com.dsasheet450.MaxMinInArray_002;

import java.util.Scanner;

/**
* Array - Max and Min of an Array - With Minimum Comparsions - 002
* - Compare In Pairs
* - Time Complexity - O(N)
* - Space Complexity - O(1)
* - #n = Odd - 3(n-1)/2 Comparsions
* - #n = Even - 3n/2 - 2 Comparsions
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
		int i;

		// If  num of elements are odd
		if(nums.length % 2 != 0){
			pair.min = nums[0];
			pair.max = nums[1];
			i = 1;
		} else {
			if(nums[0] < nums[1]){
				pair.min = nums[0];
				pair.max = nums[1];
			} else {
				pair.min = nums[1];
				pair.max = nums[0];
			}
			i = 2;
		}
		
		while(i < nums.length - 1){
			if(nums[i] > nums[i+1]){
				if(nums[i] > pair.max){
					pair.max = nums[i];
				}
				if(nums[i+1] < pair.min){
					pair.min = nums[i+1];
				}
			} else {
				if(nums[i] < pair.min){
					pair.min = nums[i];
				}
				if(nums[i+1] > pair.max){
					pair.max = nums[i+1];
				}
			}
			i += 2;
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
