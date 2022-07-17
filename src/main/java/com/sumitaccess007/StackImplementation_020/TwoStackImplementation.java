package com.sumitaccess007.StackImplementation_020;

import java.util.Scanner;
/**
* StackImplementation - Two Stacks Implementation Using One Array
* - Array is divided into two halves - and assigned to two stacks
* - Inefficient Use of Array Space
* - Stack Overflow even if other Stack has space
* Time Complexity 
* - Push Operation - O(1)
* - Pop Operation - O(1)
* @author  Sumit Sharma
* @version 1.0
*/

public class TwoStackImplementation {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomStack customStack = new CustomStack();
		int choice = 0;

		while(choice < 7){
			System.out.print("Stack Operations -\n");
			System.out.print("1.) Push \n");
			System.out.print("2.) Pop \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Display \n");
			System.out.print("5.) Search \n");
			System.out.print("6.) Empty \n");
			System.out.print("7.) Exit \n");

			System.out.print("Choose a Stack Operation -\t");
			choice = scanner.nextInt();
			System.out.println();

			switch (choice){
			case 1:
				customStack.push();
				break;
			case 2:
				customStack.pop();
				break;
			case 3:
				customStack.peek();
				break;
			case 4:
				customStack.display();
				break;
			case 5:
				customStack.search();
				break;
			case 6:
				customStack.empty();
				break;
			case 7:
				System.out.println("Exiting Program");
				System.exit(0);
				break;
			default:
				System.out.println(choice + "is Invalid Operation. Choose another.");
				choice = 0;
			}
		}
	}
	public static class CustomStack{
		Scanner scanner = new Scanner(System.in);
		public static final int DEFAULT_CAPCACITY = 7;
		int[] twoStack;
		int top1, top2, mid;
		int stack;
		
		public CustomStack() {
			twoStack = new int[DEFAULT_CAPCACITY];
			top1 = -1;
			mid = 0 + (twoStack.length - 0) / 2;
			top2 = mid - 1;
		}
		
		public void push(){
			System.out.print("Which Stack to Push (1 or 2) -\t");
			stack = scanner.nextInt();
			if(stack == 1){
				push1();
			} else if (stack == 2) {
				push2();
			} else {
				System.out.print("There are only two stacks.");
				System.out.println();
				push();
				return;
			}
		}
		
		public void push1(){
			if(top1 >= mid-1){
				System.out.println("Stack-1 Overflow");
				System.out.println();
				return;
			}
			System.out.println("Enter element to Push -\n");
			int element = scanner.nextInt();
			top1++;
			twoStack[top1] = element;
			System.out.println("Element pushed to Stack-1");
			System.out.println();
			display();
			return;
		}

		public void push2(){
			if(top2 >= twoStack.length - 1){
				System.out.println("Stack-2 Overflow");
				System.out.println();
				return;
			}
			System.out.println("Enter element to Push -\n");
			int element = scanner.nextInt();
			top2++;
			twoStack[top2] = element;
			System.out.println("Element pushed to Stack-2");
			System.out.println();
			display();
			return;
		}
		
		public void pop(){
			System.out.print("From which Stack to Pop (1 or 2) -\t");
			stack = scanner.nextInt();
			if(stack == 1){
				pop1();
			} else if (stack == 2){
				pop2();
			} else {
				System.out.print("Only two stacks are available");
				System.out.println();
				pop();
				return;
			}
		}

		public void pop1(){
			if(top1 < 0){
				System.out.print("Stack-1 Underflow");
				System.out.println();
				return;
			}
			int element = twoStack[top1];
			top1--;
			System.out.print(element + " Popped from Stack-1");
			System.out.println();
			display();
		}

		public void pop2(){
			if(top2 < mid){
				System.out.print("Stack-2 Underflow");
				System.out.println();
				return;
			}
			int element = twoStack[top2];
			top2--;
			System.out.print(element + " Popped from Stack-2");
			System.out.println();
			display();
		}

		public void peek(){
			if(top1 < 0 && top2 < mid){
				System.out.println("Both Stacks are Emoty");
				System.out.println();
				return;
			} else if (top1 < 0){
				System.out.println("Stack-1 is Empty");
				System.out.println("Stack-2 Peek - " + twoStack[top2]);
				System.out.println();
			} else if (top2 < mid) {
				System.out.println("Stack-1 Peek - " + twoStack[top1]);
				System.out.println("Stack-2 is Empty");
				System.out.println();
			} else {
				System.out.println("Stack-1 Peek - " + twoStack[top1]);
				System.out.println("Stack-2 Peek - " + twoStack[top2]);
				System.out.println();
			}
		}
		
		public void display(){
			System.out.print("Stack Elements - \n");
			System.out.print("Stack-1 => \t");
			for(int i=0; i<=top1; i++){
				System.out.print(twoStack[i] + " => ");
			}
			System.out.println();
			System.out.print("Stack-2 => \t");
			for(int i=mid; i<=top2; i++){
				System.out.print(twoStack[i] + " => ");
			}
			System.out.println();
		}

		public void search(){
			if(top1 < 0 && top2 < mid){
				System.out.println("Both Stacks are Empty");
				System.out.println();
				return;
			}
			System.out.print("Which Stack to search (1 or 2) -\t");
			stack = scanner.nextInt();
			if(stack == 1){
				search1();
			} else if (stack == 2){
				search2();
			} else {
				System.out.println("Only two stacks are available.");
				System.out.println();
				search();
			}
		}

		public void search1(){
			System.out.print("Enter element to search in Stack-1 -\t");
			int data = scanner.nextInt();
			boolean elementFound = false;
			for(int i=0; i<=top1; i++){
				if(twoStack[i] == data){
					System.out.println(data + " is present at index " + i + " of Stack-1");
					elementFound = true;
				}
			}
			if(elementFound == false){
				System.out.println(data + " not found in Stack-1");
				System.out.println();
			}
		}
		
		public void search2(){
			System.out.print("Enter element to search in Stack-2 -\t");
			int data = scanner.nextInt();
			boolean elementFound = false;
			for(int i=mid; i<=top2; i++){
				if(twoStack[i] == data){
					System.out.println(data + " is present at index " + i + " of Stack-2");
					elementFound = true;
				}
			}
			if(elementFound == false){
				System.out.println(data + " not found in Stack-2");
				System.out.println();
			}
		}

		public void empty(){
			if(top1 < 0 && top2 < mid){
				System.out.println("Stack-1 Empty");
				System.out.println("Stack-2 Empty");
				System.out.println();
			} else if (top1 < 0){
				System.out.println("Stack-1 Empty");
				System.out.println("Stack-2 Not Empty");
				System.out.println();
			} else if (top2 < mid){
				System.out.println("Stack-1  Not Empty");
				System.out.println("Stack-2 Empty");
				System.out.println();
			} else {
				System.out.println("Stack-1 Not Empty");
				System.out.println("Stack-2 Not Empty");
				System.out.println();
			}
		}

	}
}
