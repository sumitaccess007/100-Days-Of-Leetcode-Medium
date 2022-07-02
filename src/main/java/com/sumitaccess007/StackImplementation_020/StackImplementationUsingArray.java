package com.sumitaccess007.StackImplementation_020;

import java.util.Scanner;

public class StackImplementationUsingArray {

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

			System.out.print("Choose a Stack Operation - \t");
			choice = scanner.nextInt();
			System.out.println();

			switch (choice) {
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
				break;
			default:
				System.out.println(choice + " is not a valid stack operation. Please choose another.");
				choice = 0;
			}
		}

	}

	public static class CustomStack {
		Scanner scanner = new Scanner(System.in);
		public static final int DEFAULT_CAPCACITY = 6;
		int[] stack;
		int top;

		public CustomStack() {
			top = -1;
			stack = new int[DEFAULT_CAPCACITY];
		}

		public void push() {
			System.out.println("Push Operation Selected");
			System.out.print("Enter element to push - \t");
			int element = scanner.nextInt();
			if (top >= (DEFAULT_CAPCACITY - 1)) {
				System.out.println("Stack Overflow");
				System.out.println();
				return;
			} else {
				top++;
				stack[top] = element;
				System.out.println("Pushed Into Stack");
				System.out.println();
				display();
				return;
			}
		}

		public void pop() {
			System.out.println("Pop Operation Selected");
			if (top < 0) {
				System.out.println("Stack Underflow");
				System.out.println();
				return;
			} else {
				int stackElement = stack[top];
				System.out.println(stackElement + " Popped from Stack");
				System.out.println();
				top--;
				return;
			}
		}

		public void peek() {
			System.out.println("Peek Operation Selected");
			if (top < 0) {
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			} else {
				System.out.println("Top element is " + stack[top]);
				System.out.println();
				return;
			}
		}

		public void search() {
			if (top < 0) {
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			} else {
				System.out.println("Search Operation Selected");
				System.out.print("Enter Element to Search - \t");
				int element = scanner.nextInt();
				if (top < 0) {
					System.out.println("Stack is Empty");
					System.out.println();
					return;
				} else {
					for (int i = 0; i < top; i++) {
						if (stack[i] == element) {
							System.out.println(element + " is present at " + i + " index.");
						}
					}
					System.out.println();
					return;
				}
			}
		}

		public void display() {
			if (top < 0) {
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			} else {
				System.out.print("Elements of Stack are - ");
				for (int i = 0; i <= top; i++) {
					System.out.print(stack[i] + "\t");
				}
				System.out.println();
				return;
			}
		}

		public void empty() {
			System.out.println("Empty Operation Selected");
			if (top < 0) {
				System.out.println("Stack is Empty");
			} else {
				System.out.println("Stack is not Empty");
			}
			System.out.println();
			return;
		}
	}
}
