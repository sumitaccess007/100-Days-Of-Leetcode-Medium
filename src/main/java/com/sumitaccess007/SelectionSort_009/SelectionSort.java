package com.sumitaccess007.SelectionSort_009;

import java.util.Scanner;

/**
* Sorting Algorithm - Selection Sort
* Keep Finding Minimum Element and Put at the beginning of the array
* - It is In-Place Sorting Algorithm
* - Default Implementation of Selection Sorting Algorithm is not Stable
* - Time Complexity - O(N*N)
* @author  Sumit Sharma
* @version 1.0
*/

public class SelectionSort {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("Enter Number of Elements - ");
		int numOfElements = scanner.nextInt();
		System.out.println("");
		
		int[] nums = new int[numOfElements];
		System.out.print("Enter Elements of Array - ");
		for(int i=0; i<numOfElements; i++){
			nums[i] = scanner.nextInt();
		}
		System.out.print("\t");
		
		printArrayElements(nums);

		System.out.println("Sorting Array -");
		selectionSort(nums);
		
		System.out.println("Sorted Array is -");
		printArrayElements(nums);

	}

	private static void selectionSort(int[] nums) {
		int min_index;
		int temp;
		for(int i=0; i<nums.length; i++){
			min_index = i;
			for(int j=i+1; j<nums.length; j++){
				if(nums[j] < nums[min_index]){
					min_index = j;
				}
			}
			temp = nums[min_index];
			nums[min_index] = nums[i];
			nums[i] = temp;
		}
		
	}

	private static void printArrayElements(int[] nums) {
		System.out.println("Elements of array are -");
		for(int element : nums){
			System.out.print(element + "\t");
		}
	}

}
