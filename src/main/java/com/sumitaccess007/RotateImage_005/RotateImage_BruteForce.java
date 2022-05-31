package com.sumitaccess007.RotateImage_005;

import java.util.Arrays;
import java.util.Scanner;

/**
* Rotate Image Problem - BruteForce Implementation
* STEP-1 => Reverse the columns in 2D Array [Reverse Matrix Row-wise]
* STEP-2 => Transpose of resultant Matrix
* @author  Sumit Sharma
* @version 1.0
*/

public class RotateImage_BruteForce {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the size of Matrix - ");
		int n = scanner.nextInt();
		
		// Get Matrix Elements
		int[][] matrix = new int[n][n];
		System.out.println("Enter the elements of Matrix - ");
		for(int i=0; i<n; i++){
			for(int j=0; j<n; j++){
				matrix[i][j] = scanner.nextInt();
			}
		}
		
		// Print Matrix Elements
		System.out.println("Matrix Elements are - ");
		printMatrixElements(n, matrix);
		System.out.println("[STEP-1] Reversing Column of Matrix");
		reverseMatrixColumns(n, matrix);
		System.out.println("[STEP-2] Transpose Matrix");
		transposeMatrix(n, matrix);
		System.out.println("Rotated 90 degree Matrix is - ");
		printMatrixElements(n, matrix);
	}

	private static void transposeMatrix(int n, int[][] matrix) {
		for(int i=0; i<n; i++){
			for(int j=i+1; j<matrix[i].length; j++){
				int temp = matrix[i][j];
				matrix[i][j] = matrix[j][i];
				matrix[j][i] = temp;
			}
		}
	}

	private static void reverseMatrixColumns(int n, int[][] matrix) {
		for(int i=0; i<n; i++){
			int start = 0;
			int end = n-1;
			while(start < end){
				swapElements(i, start, end, matrix);
				start++;
				end--;
			}
		}
	}

	private static void swapElements(int i, int start, int end, int[][] matrix) {
		int temp = matrix[start][i];
		matrix[start][i] = matrix[end][i];
		matrix[end][i] = temp;
	}

	private static void printMatrixElements(int n, int[][] matrix) {
		for(int[] array : matrix){
			System.out.println(Arrays.toString(array));
		}
		System.out.println();
	}

}
