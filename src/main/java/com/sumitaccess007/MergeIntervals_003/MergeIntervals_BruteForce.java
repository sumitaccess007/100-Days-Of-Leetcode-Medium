package com.sumitaccess007.MergeIntervals_003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
* The MergeIntervals Problem - BruteForce Implementation
* 1. Take 2D Array as Input - Array Of Intervals
* 2. Sort all intervals based in Starting Point - Sort 2D Array (Either using Comparator, or using Lambda Expression)
*    This sorting will create two cases -
*    a. StartTime(Next Interval) < EndTime(Current Interval) = Overlap => Update EndTime of Current Interval
*    b. StartTime(Next Interval) >= EndTime(Current Interval) = No Overlap => Insert Current Interval as it is
*    First Interval will always be inserted as it is.
* 3. Traverse intervals => Merge them (if required) => and put in ArrayList => But this solution is implemented using Stack
*    Why ArrayList -> Because we do not know the number of intervals which will be created after merging
* @author  Sumit Sharma
* @version 1.0
*/

public class MergeIntervals_BruteForce {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter Number of Intervals - ");
		int numOfIntervals = scanner.nextInt();
		
		int[][] arrayOfIntervals = new int[numOfIntervals][2];
		System.out.println("Enter intervals start and end time - ");
		for(int i=0; i<numOfIntervals; i++){
			int startTime = scanner.nextInt();
			int endTime = scanner.nextInt();
			arrayOfIntervals[i][0] = startTime;
			arrayOfIntervals[i][1] = endTime;
		}
		
		System.out.println("Array of Intervals is - ");
		printArrayOfIntervals(numOfIntervals, arrayOfIntervals);
		
		System.out.println("Sorting Array of Intervals");
		sortArrayOfIntervals(arrayOfIntervals);
		
		System.out.println("Sorted Array of Intervals is - ");
		printArrayOfIntervals(numOfIntervals, arrayOfIntervals);
		
		System.out.println("Merged Intervals are - ");
		mergeIntervals(numOfIntervals, arrayOfIntervals);
	}

	private static void mergeIntervals(int numOfIntervals, int[][] arrayOfIntervals) {
		// Stack Creation
		Stack<int[]> stack = new Stack<>();
		
		// Traverse Sorted Array => And add intervals in Stack
		for(int[] interval : arrayOfIntervals){
			if(stack.empty()){
				stack.push(interval);
			} else {
				int[] topInterval = stack.peek();
				if(interval[0] <= topInterval[1]){
					topInterval[1] = Math.max(interval[1], topInterval[1]);
				} else {
					stack.push(interval);
				}
			}
		}
		
		// Transfer Intervals from One Stack to Another Stack => To get ascending order
		Stack<int[]> finalStack = new Stack<>();
		while(stack.size() > 0){
			finalStack.push(stack.pop());
		}
		
		// Print Merged Intervals
		while(finalStack.size() > 0){
			int[] resArray = finalStack.pop();
			System.out.print(resArray[0] + "\t" + resArray[1]);
			System.out.println();
		}
	}

	private static void sortArrayOfIntervals(int[][] arrayOfIntervals) {
		// Comparator - With Anonymous Class Implementation
		Comparator<int[]> comparator = new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]){
					return -1;
				}
				return 0;
			}
		};
		
		// Sort Array using Comparator Interface
		Arrays.sort(arrayOfIntervals, comparator);
	}

	private static void printArrayOfIntervals(int numOfIntervals, int[][] arrayOfIntervals) {
		// Print Array of Intervals
		for(int[] interval : arrayOfIntervals){
			System.out.println(Arrays.toString(interval));
		}
		System.out.println("");
		
	}

}
