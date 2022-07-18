package com.sumitaccess007.StackImplementation_020;

import java.util.Scanner;
/**
* StackImplementation - Two Stacks Implementation Using One Array
* - Two Stacks are started from two extreme corners of Array
* - Stack-1 starts from left most corner
* - Stack-2 starts from right most corner
* - Space Optimized Implementation
* - Both stacks grows (or shrinks) in opposite direction
* - Does not cause Overflow if there is space available in Array
* Time Complexity
* - Push Operation - O(1)
* - Pop Operation - O(1)
* @author  Sumit Sharma
* @version 1.0
*/

public class TwoStackImplementationSpaceOptimized {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomStack customStack = new CustomStack();
		int choice = 0;

		while (choice < 7) {

			System.out.print("Stack Operations - \n");
			System.out.print("1.) Push \n");
			System.out.print("2.) Pop \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Search \n");
			System.out.print("5.) Display \n");
			System.out.print("6.) Empty \n");
			System.out.print("7.) Exit \n");

			System.out.print("Choose Stack Operation - \t");
			choice = scanner.nextInt();

			switch(choice){
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
				customStack.search();
				break;
			case 5:
				customStack.display();
				break;
			case 6:
				customStack.empty();
				break;
			case 7:
				System.out.println("Exiting Program");
				System.exit(0);
			default:
				System.out.println("Invalid Operation. Choose Another.");
				choice = 0;
				break;
			}
		}
	}

	public static class CustomStack{
		Scanner scanner = new Scanner(System.in);
		static final int DEFAULT_CAPACITY = 7;
		int top1, top2, stack;
		int[] twoStack;

		public CustomStack() {
			twoStack = new int[DEFAULT_CAPACITY];
			top1 = -1;
			top2 = twoStack.length;
		}
		
		public void push(){
			System.out.print("Which Stack To Push (1 or 2) - \t");
			stack = scanner.nextInt();
			if(stack == 1){
				push1();
			} else if (stack == 2){
				push2();
			} else {
				System.out.println("Only two stacks are available");
				System.out.println();
				push();
			}
		}
		
		public void push1(){
			if(top2 == top1+1){
				System.out.println("Stack-1 Overflow");
				System.out.println();
				return;
			}
			System.out.print("Enter element to Push -\t");
			int element = scanner.nextInt();
			top1++;
			twoStack[top1] = element;
			System.out.println("Element Pushed to Stack-1");
			System.out.println();
			display();
		}
		
		public void push2(){
			if(top2 == top1+1){
				System.out.println("Stack-2 Overflow");
				System.out.println();
				return;
			}
			System.out.print("Enter element to Push -\t");
			int element = scanner.nextInt();
			top2--;
			twoStack[top2] = element;
			System.out.println("Element Pushed to Stack-2");
			System.out.println();
			display();
		}
		
		public void pop(){
			System.out.print("From Which Stack To Pop (1 or 2) - \t");
			stack = scanner.nextInt();
			if(stack == 1){
				pop1();
			} else if (stack == 2){
				pop2();
			} else {
				System.out.println("Only two stacks are available");
				System.out.println();
				pop();
			}
		}
		
		public void pop1(){
			if(top1 < 0){
				System.out.println("Stack-1 Underflow");
				System.out.println();
				return;
			}
			int element = twoStack[top1];
			top1--;
			System.out.println(element + " Popped from Stack-1");
			System.out.println();
			display();
		}

		public void pop2(){
			if(top2 > twoStack.length-1){
				System.out.println("Stack-2 Underflow");
				System.out.println();
				return;
			}
			int element = twoStack[top2];
			top2++;
			System.out.println(element + " Popped from Stack-2");
			System.out.println();
			display();
		}
		
		public void peek(){
			if(top1 < 0 && top2 > twoStack.length-1){
				System.out.println("Both Stacks are empty");
				System.out.println();
			} else if (top1 < 0){
				System.out.println("Stack-1 is Empty");
				System.out.println("Stack-2 Peek - " + twoStack[top2]);
			} else if (top2 > twoStack.length){
				System.out.println("Stack-1 Peek - " + twoStack[top1]);
				System.out.println("Stack-2 is Empty");
			} else {
				System.out.println("Stack-1 Peek - " + twoStack[top1]);
				System.out.println("Stack-2 Peek - " + twoStack[top2]);
			}
		}
		
		public void search(){
			if(top1 < 0 && top2 > twoStack.length-1){
				System.out.println("Both stacks are Empty");
				return;
			}
			System.out.print("Which Stack to Search (1 or 2) -\t");
			stack = scanner.nextInt();
			System.out.print("Enter Element to Search - \t");
			int data = scanner.nextInt();
			boolean elementFound = false;
			if(stack == 1){
				for(int i=0; i<=top1; i++){
					if(twoStack[i] == data){
						System.out.println(data + " is present at index " + i);
						elementFound = true;
					}
				}
				 if(elementFound == false){
					 System.out.println(data + " not found in Stack-1");
					 System.out.println();
				 }
			} else if(stack == 2){
				 for(int i=twoStack.length-1; i>=top2; i--){
					 if(twoStack[i] == data){
						System.out.println(data + " is present at index " + (twoStack.length-i-1));
						elementFound = true;
					 }
				 }
				 if(elementFound == false){
					 System.out.println(data + " not found in Stack-2");
					 System.out.println();
				 }
			} else {
				System.out.println("Only two stacks are available");
				System.out.println();
				search();
			}
		}
		
		public void empty(){
			if(top1 < 0 && top2 > twoStack.length-1){
				System.out.println("Stack-1 Empty");
				System.out.println("Stack-2 Empty");
				System.out.println();
			} else if(top1 < 0){
				System.out.println("Stack-1 Empty");
				System.out.println("Stack-2 Not Empty");
				System.out.println();				
			} else if (top2 > twoStack.length){
				System.out.println("Stack-1 Not Empty");
				System.out.println("Stack-2 Empty");
				System.out.println();
			} else {
				System.out.println("Stack-1 Not Empty");
				System.out.println("Stack-2 Not Empty");
				System.out.println();
			}
		}
		
		public void display(){
			System.out.print("Stack-1 =>\t");
			for(int i=0; i<=top1; i++){
				System.out.print(twoStack[i] + " => ");
			}
			System.out.println();
			System.out.print("Stack-2 =>\t");
			for(int i=twoStack.length-1; i>=top2; i--){
				System.out.print(twoStack[i] + " => ");
			}
			System.out.println();
		}
		
	}
	
	
}
