package com.dsasheet450.ReverseArray_001;

import java.util.Scanner;

/**
* Array - Reverse Array - 002
* Implemented solution is In-place
* Implemented solution is also stable
* The solution is implemented using two pointers
* - Time Complexity - O(N)
* - Space Complexity
* @author  Sumit Sharma
* @version 1.0
*/


public class ReverseArray_02 {

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
		
		reverseArray(nums);
		
		printArrayElements(nums);
	}
	
	public static void reverseArray(int[] nums){
		System.out.println("Reversing Array - ");
		int start = 0;
		int end = nums.length-1;
		while(start < end){
			if(nums[start] != nums[end]){
				int temp = nums[start];
				nums[start] = nums[end];
				nums[end] = temp;
			}
			start++;
			end--;
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
