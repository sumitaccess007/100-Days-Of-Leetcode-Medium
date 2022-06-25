package com.dsasheet450.MaxMinInArray_002;

import java.util.Scanner;

/**
* Array - Max and Min of an Array - With Minimum Comparsions - 002
* - Tournament Method - Divide Array in Two Parts and get Max, Min of each of the parts
* - Algorithm Technique - Divide And Conquer
* - Time Complexity - O(N)
* - Space Complexity - O(logn) - Because of recursive calls
* - Number of Comparsions -
* - T(n) = 2T(n/2) + 2 => 3n/2 - 2
* @author  Sumit Sharma
* @version 1.0
*/


public class MaxMinInArray_02 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Size Of Array - ");
		int numOfElements = scanner.nextInt();
		
		int[] nums = new int[numOfElements];
		System.out.println("Enter Array Elements - ");
		for(int i=0; i<numOfElements; i++){
			nums[i] = scanner.nextInt();
		}

		printArrayElements(nums);
		
		Pair minmax = getMinMaxInArray(nums, 0, nums.length-1);
		
		System.out.println("Minimum Element is - " + minmax.min);
		System.out.println("Maximum Element is - " + minmax.max);
		
	}
	
	private static Pair getMinMaxInArray(int[] nums, int low, int high) {
		Pair pair = new Pair();
		Pair leftHalf = new Pair();
		Pair rightHalf = new Pair();
		int mid;

		// If Array contains only one element
		if(low == high){
			pair.min = nums[low];
			pair.max = nums[low];
			return pair;
		}
		
		// If Array contains two elements
		if(high == low + 1){
			if(nums[low] < nums[high]){
				pair.min = nums[low];
				pair.max = nums[high];
			} else {
				pair.min = nums[high];
				pair.max = nums[low];
			}
			return pair;
		}
		
		// If array contains more than two element
		mid = (low + high) / 2;
		leftHalf = getMinMaxInArray(nums, low, mid);
		rightHalf = getMinMaxInArray(nums, mid+1, high);
		
		// Compare minimums of two half
		if(leftHalf.min < rightHalf.min){
			pair.min = leftHalf.min;
		} else {
			pair.min = rightHalf.min;
		}

		// Compare maximums of two half
		if(leftHalf.max < rightHalf.max){
			pair.max = rightHalf.max;
		} else {
			pair.max = leftHalf.max;
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
