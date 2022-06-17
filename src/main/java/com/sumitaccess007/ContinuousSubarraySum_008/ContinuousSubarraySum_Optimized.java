package com.sumitaccess007.ContinuousSubarraySum_008;

import java.util.Scanner;

public class ContinuousSubarraySum_Optimized {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Value of K :-");
		int k = scanner.nextInt();
		
		System.out.println("Enter Number of Elements :-");
		int numOfElements = scanner.nextInt();
		
		int[] nums = new int[numOfElements];
		System.out.println("Enter Elements of Array :-");
		for(int i=0; i<numOfElements; i++){
			nums[i] = scanner.nextInt();
		}
		
		System.out.println("Elements of Array are :-");
		printArrayElements(nums);
		
		boolean hasContinuosSubarraySum = getContinuousSubarraySum(nums, k);
		System.out.println("Given Array has Continuous Subarray Sum - " + hasContinuosSubarraySum);

	}

	private static boolean getContinuousSubarraySum(int[] nums, int k) {
		boolean result = false;
		for(int i=0; i<nums.length; i++){
			for(int j=i+1; j<nums.length; j++){
				if((nums[i] + nums[j]) % k == 0){
					result = true;
					break;
				}
			}
		}
		return result;
	}

	private static void printArrayElements(int[] nums) {
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println();
	}

}
