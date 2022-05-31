package com.sumitaccess007.SumOfTwoIntegers_004;

import java.util.Scanner;

public class SumOfTwoIntegers {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter First Number - ");
		int firstNum = scanner.nextInt();
		System.out.println("Enter Second Number - ");
		int secondNum = scanner.nextInt();
		int sumOfNum = sumOfTwoIntegers(firstNum, secondNum);
		System.out.println("Sum of " + firstNum + " and " + secondNum + " is " + sumOfNum);
	}

	private static int sumOfTwoIntegers(int firstNum, int secondNum) {
		int sum = firstNum ^ secondNum;
		int carry = firstNum & secondNum;
		while(carry != 0){
			carry = carry << 1;
			int tempSum = sum ^ carry;
			int tempCarry = sum & carry;
			sum = tempSum;
			carry = tempCarry;
		}
		return sum;
	}
}
