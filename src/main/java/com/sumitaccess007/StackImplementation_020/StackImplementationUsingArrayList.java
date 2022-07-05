package com.sumitaccess007.StackImplementation_020;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StackImplementationUsingArrayList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomStack customStack = new CustomStack(6);
		int choice = 0;
		while(choice < 7){
			System.out.print("Stack Operations :- \n");
			System.out.print("1.) Push \n");
			System.out.print("2.) Pop \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Search \n");
			System.out.print("5.) Display \n");
			System.out.print("6.) Empty \n");
			System.out.print("7.) Exit \n");
			
			System.out.print("Choose Stack Operations :- \n");
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
				System.out.println("Invalid Stack Operation.");
				choice = 0;
			}
		}

	}
	
	public static class CustomStack{
		int capacity;
		int top;
		List<Integer> stack;
		Scanner scanner = new Scanner(System.in);
		
		public CustomStack(int capacity) {
			this.capacity = capacity;
			this.top = -1;
			this.stack = new ArrayList<>(capacity);
		}
		
		public void push(){
			System.out.println("Push Operation Selected");
			System.out.print("Enter Element to Push -\t");
			int element = scanner.nextInt();
			if(top >= capacity-1){
				System.out.println("Stack Overflow");
				System.out.println();
				return;
			}
			top++;
			if(stack.size() > top){
				stack.set(top, element);
				System.out.println("Pushed to Stack");
				display();
				System.out.println();
			} else {
				stack.add(element);
				System.out.println("Pushed to Stack");
				display();
				System.out.println();
			}
		}
		
		public void pop(){
			System.out.println("Pop Operation Selected");
			if(top == -1){
				System.out.println("Stack Underflow");
				System.out.println();
				return;
			}
			int element = stack.get(top);
			System.out.println(element + " Pop from Stack");
			System.out.println();
			top--;
		}
		
		public void peek(){
			System.out.println("Peek Operation Selected");
			if(top == -1){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			int element = stack.get(top);
			System.out.println("Top element is - " + element);
			System.out.println();
		}
		
		public void search(){
			System.out.println("Search Operation Selected");
			if(top == -1){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			System.out.print("Enter element to search -\t");
			int element = scanner.nextInt();
			if(stack.indexOf(element) <= top && stack.indexOf(element) >= 0){
				System.out.println(element + " is present at Index " + stack.indexOf(element));
				System.out.println();
			} else {
				System.out.println("Element Not Found");
				System.out.println();
			}
		}
		
		public void display(){
			System.out.println("Display Operation Selected");
			if(top == -1){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			System.out.print("Elements are -\t");
			for(int i=0; i<=top; i++){
				System.out.print(stack.get(i) + "  ->  ");
			}
			System.out.println();
		}
		
		public void empty(){
			System.out.println("Empty Operation Selected");
			if(top == -1){
				System.out.println("Stack is Empty");
				System.out.println();
			} else {
				System.out.println("Stack is not Empty");
				System.out.println();
			}
		}
	}

}
