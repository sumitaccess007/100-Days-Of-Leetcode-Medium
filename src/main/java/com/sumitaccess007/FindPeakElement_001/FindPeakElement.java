package com.sumitaccess007.FindPeakElement_001;

import java.util.Scanner;

import javax.xml.validation.SchemaFactoryConfigurationError;

public class FindPeakElement {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of elements - ");
		int numOfElements = scanner.nextInt();
		int[] arrayOfElements = new int[numOfElements];

		// Putting Elements into Array
		for(int index = 0; index < numOfElements; index++){
			arrayOfElements[index] = scanner.nextInt();
		}

		printArrayElements(numOfElements, arrayOfElements);
		int peakElementIndex = findPeakElement(numOfElements, arrayOfElements);
		System.out.println("Peak Element in Array is - " + arrayOfElements[peakElementIndex]);


	}

	private static int findPeakElement(int numOfElements, int[] arrayOfElements) {
		int low = 0;
		int high = numOfElements-1;
		int mid;
		
		while(low < high){
			mid = low + (high-low)/2;
			if (arrayOfElements[mid+1] > arrayOfElements[mid]){
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

	private static void printArrayElements(int numOfElements, int[] arrayOfElements) {
		// Printing Array Elements
		System.out.print("Array Elements are - ");
		for(int index = 0; index < numOfElements; index++){
			System.out.print("\t" + arrayOfElements[index]);
		}
		System.out.println();
	}

}
