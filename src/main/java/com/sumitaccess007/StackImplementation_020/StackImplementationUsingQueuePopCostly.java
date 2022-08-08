package com.sumitaccess007.StackImplementation_020;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
* StackImplementation - Using Queue (Pop Operation Costly)
* Design a stack that supports push and pop operations using standard enqueue and dequeue operations of the queue.
* Two Approaches -
* 1. By making Push Operation Costly
* 	Push Operation TC - O(n)
* 	Pop Operation TC - O(1)
* 2. By making Pop Operation Costly
* 	Push Operation TC - O(1)
* 	Pop Operation TC - O(n)
* @author  Sumit Sharma
* @version 1.0
*/
public class StackImplementationUsingQueuePopCostly {

	public static void main(String[] args) {
		Scanner scanner  = new Scanner(System.in);
		CustomStack customStack = new CustomStack();
		int choice = 0;
		
		while(choice < 7){
			System.out.print("Stack Operations \n");
			System.out.print("1.) Push \n");
			System.out.print("2.) Pop \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Size \n");
			System.out.print("5.) Search \n");
			System.out.print("6.) Display \n");
			System.out.print("7.) Exit \n");
			
			System.out.print("Choose Stack Operation -\t");
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
				customStack.size();
				break;
			case 5:
				customStack.search();
				break;
			case 6:
				customStack.display();
				break;
			case 7:
				System.out.println("Exiting Program");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid, Choose another Operation");
				choice = 0;
				break;
			}
		}

	}

	public static class CustomStack{
		Scanner scanner = new Scanner(System.in);
		Queue<Integer> queue1;
		Queue<Integer> queue2;
		int size;
		int element;
		
		CustomStack(){
			queue1 = new LinkedList<>();
			queue2 = new LinkedList<>();
			size = 0;
		}
		
		public void push(){
			System.out.println("Push Operation");
			System.out.print("Enter element to Push -\t");
			element = scanner.nextInt();
			queue1.add(element);
			size++;
			System.out.println(element + " Pushed to Stack");
			display();
		}
		
		public void pop(){
			System.out.println("Pop Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is empty");
				System.out.println();
				return;
			}
			while(queue1.size() != 1){
				queue2.add(queue1.peek());
				queue1.remove();
			}
			System.out.println(queue1.peek() + " Popped from Stack");
			queue1.remove();
			System.out.println();
			while(queue2.size() != 0){
				queue1.add(queue2.peek());
				queue2.remove();
			}
			size--;
			System.out.println();
			display();
		}
		
		public void peek(){
			System.out.println("Peek Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is empty");
				System.out.println();
				return;
			}
			while(queue1.size() != 1){
				queue2.add(queue1.peek());
				queue1.remove();
			}
			System.out.println(queue1.peek() + " is peek of Stack");
			queue2.add(queue1.peek());
			queue1.remove();
			while(queue2.size() != 0){
				queue1.add(queue2.peek());
				queue2.remove();
			}
			System.out.println();
			display();
		}
		
		public void search(){
			System.out.println("Search Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is empty");
				System.out.println();
				return;
			}
			boolean elementFound = false;
			int indexTracker = 0;
			System.out.print("Enter element to Search -\t");
			element = scanner.nextInt();
			for(Integer item : queue1){
				indexTracker++;
				if(item == element){
					elementFound = true;
					System.out.println(element + " present at index " + indexTracker);
				}
			}
			if(elementFound == false){
				System.out.println("Element not found");
				System.out.println();
			}
			System.out.println();
		}
		
		public void size(){
			System.out.println("Size Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is empty");
				System.out.println();
				return;
			}
			System.out.println("Stack size is - " + size);
			System.out.println();
		}
		
		public void display(){
			System.out.println("Display Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is empty");
				System.out.println();
				return;
			}
			System.out.print("Elements of Stack -\t");
			for(Integer item : queue1){
				System.out.print(item + " -> ");
			}
			System.out.println("");
			System.out.println("");
		}
	}
}
