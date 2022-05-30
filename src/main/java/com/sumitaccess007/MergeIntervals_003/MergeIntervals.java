package com.sumitaccess007.MergeIntervals_003;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
* The MergeIntervals Problem - BruteForce Implementation
* 1. Take 2D Array as Input - Array Of Intervals
* 2. Sort all intervals based in Starting Point - Sort 2D Array (Either using Comparator, or using Lambda Expression)
*    This sorting will create two cases -
*    a. StartTime(Next Interval) < EndTime(Current Interval) = Overlap => Update EndTime of Current Interval
*    b. StartTime(Next Interval) >= EndTime(Current Interval) = No Overlap => Insert Current Interval as it is
*    First Interval will always be inserted as it is.
* 3. Traverse intervals => Merge them (if required) => and put in ArrayList
*    Why ArrayList -> Because we do not know the number of intervals which will be created after merging
* @author  Sumit Sharma
* @version 1.0
*/


public class MergeIntervals {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		// Get Number of Intervals
		System.out.println("Enter number of intervals - ");
		int numOfIntervals = scanner.nextInt();
		
		// Get Interval - StartTime and EndTime
		int[][] arrayOfIntervals = new int[numOfIntervals][2];
		for(int i=0; i<numOfIntervals; i++){
			int startTime = scanner.nextInt();
			int endTime = scanner.nextInt();
			arrayOfIntervals[i][0] = startTime;
			arrayOfIntervals[i][1] = endTime;
		}
		
		// Print Array Of Intervals
		System.out.println("Array of Intervals is - ");
		printArrayOfIntervals(arrayOfIntervals);
		
		// Sort Array Of Intervals
		System.out.println("Sorting Array Of Intervals - ");
		sortArrayOfIntervals(arrayOfIntervals);
		
		// Print Sorted Array Of Intervals
		System.out.println("Sorted Array of Intervals is - ");
		printArrayOfIntervals(arrayOfIntervals);
		
		// Merge Sorted Array Of Intervals
		System.out.println("Merged Array Of Intervals is - ");
		int[][] finalMergedIntervals = mergeArrayOfIntervals(arrayOfIntervals);
		for(int[] interval : finalMergedIntervals){
			System.out.println(interval[0] + "\t" + interval[1]);
		}
		

	}

	private static int[][] mergeArrayOfIntervals(int[][] arrayOfIntervals) {
		// Create Array List
		List<int[]> list = new ArrayList<>();
		
		// Traverse Array and put them in ArrayList
		for(int[] interval : arrayOfIntervals){
			if(list.size() == 0){
				list.add(interval);		// Add 1st Interval as it is
			} else {
				int[] prevInterval = list.get(list.size()-1);
				if(interval[0] <= prevInterval[1]){
					// Overlap
					prevInterval[1] = Math.max(interval[1], prevInterval[1]);
				} else {
					// No Overlap
					list.add(interval);
				}
			}
		}
		// Convert Array List to Array
		return list.toArray(new int[list.size()][]);
	}

	private static void sortArrayOfIntervals(int[][] arrayOfIntervals) {
		Arrays.sort(arrayOfIntervals, (a,b) -> Integer.compare(a[0], b[0]));
	}

	private static void printArrayOfIntervals(int[][] arrayOfIntervals) {
		for(int[] interval : arrayOfIntervals){
			System.out.println(Arrays.toString(interval));
		}
		System.out.println();
	}
}
