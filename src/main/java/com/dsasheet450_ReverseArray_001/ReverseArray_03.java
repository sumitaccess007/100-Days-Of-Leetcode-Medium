package com.dsasheet450_ReverseArray_001;

import java.util.Scanner;

/**
* Array - Reverse Array - 001
* Implemented solution is In-place
* Implemented solution is also stable
* The solution is implemented using two pointers - Recursive Solution
* - Time Complexity - O(N)
* - Space Complexity
* @author  Sumit Sharma
* @version 1.0
*/


public class ReverseArray_03 {

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
		
		System.out.println("Reversing Array - ");
		reverseArray(nums, 0, nums.length-1);
		
		printArrayElements(nums);
	}
	
	public static void reverseArray(int[] nums, int start, int end){
		if(start < end){
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			reverseArray(nums, start+1, end-1);
		} else {
			return;
		}
	}
	
	public static void printArrayElements(int[] nums){
		System.out.println("Array Elements are - ");
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println();
	}
}
