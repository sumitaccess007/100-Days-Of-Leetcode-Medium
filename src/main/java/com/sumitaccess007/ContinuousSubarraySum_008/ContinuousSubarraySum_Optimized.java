package com.sumitaccess007.ContinuousSubarraySum_008;

import java.util.HashMap;
import java.util.Map;
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
		Map<Integer, Integer> remainderMap = new HashMap<>();
		
		remainderMap.put(0, -1);
		int runningSum = 0;
		int minLen = 2;
		
		for(int index=0; index<nums.length; index++){
			runningSum = runningSum + nums[index];
			if(k != 0){
				runningSum = runningSum % k;
			}
			if(remainderMap.containsKey(runningSum)){
				if((index - remainderMap.get(runningSum)) > minLen){
					System.out.println("RunningSum is :- " + runningSum);
					System.out.println("From HashMap :- " + remainderMap.get(runningSum));
					System.out.println("Index is :- " + index);
					return true;
				}
			} else {
				remainderMap.put(runningSum, index);
			}
		}
		return false;

	}

	private static void printArrayElements(int[] nums) {
		for(int element : nums){
			System.out.print(element + "\t");
		}
		System.out.println();
	}

}
