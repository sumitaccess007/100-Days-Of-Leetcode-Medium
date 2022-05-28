package com.sumitaccess007.SubArraySumEqualsK_002;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

import javax.xml.validation.SchemaFactoryConfigurationError;

public class SubArraySumEqualsK {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter number of elements - ");
		int numOfElements = scanner.nextInt();
		int[] arrayOfElements = new int[numOfElements];
		// Putting Elements into Array
		for (int index = 0; index < numOfElements; index++) {
			arrayOfElements[index] = scanner.nextInt();
		}
		int k = scanner.nextInt();
		System.out.println("K value is - " + k);
		
		printArrayElements(numOfElements, arrayOfElements);
		int countSubArrays = countSubArraysSumEqualsK(numOfElements, arrayOfElements, k);
		System.out.println("Number of Sub-Arrays having Sum equals " + k + " is - " + countSubArrays);

	}

	private static int countSubArraysSumEqualsK(int numOfElements, int[] arrayOfElements, int k) {
		int count = 0;
		int prefixSum = 0;
		int remainingSum;
		Map<Integer, Integer> frequencyHashMap = new HashMap<>();
		frequencyHashMap.put(0, 1);
		for(int i=0; i<numOfElements; i++){
			prefixSum += arrayOfElements[i];
			remainingSum = prefixSum - k;
			if(frequencyHashMap.containsKey(remainingSum)){
				count += frequencyHashMap.getOrDefault(remainingSum, 0);
			}
			frequencyHashMap.put(prefixSum, frequencyHashMap.getOrDefault(prefixSum, 0) + 1);
		}
		
		return count;
	}

	private static void printArrayElements(int numOfElements, int[] arrayOfElements) {
		// Printing Array Elements
		System.out.print("Array Elements are - ");
		for (int index = 0; index < numOfElements; index++) {
			System.out.print("\t" + arrayOfElements[index]);
		}
		System.out.println();
	}

}
