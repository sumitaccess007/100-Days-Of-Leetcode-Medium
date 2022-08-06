package com.sumitaccess007.StackImplementation_020;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
* StackImplementation - Using Queue (Push Operation Costly)
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

public class StackImplementationUsingQueuePushCostly {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomStack customStack = new CustomStack();
		int choice = 0;
		
		while(choice < 8){
			System.out.print("Stack Operations \n");
			System.out.print("1.) Push \n");
			System.out.print("2.) Pop \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Search \n");
			System.out.print("5.) Display \n");
			System.out.print("6.) Size \n");
			System.out.print("7.) Exit \n");
			
			System.out.print("Choose Stack Operations -\t");
			choice = scanner.nextInt();
			System.out.println();
			
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
				customStack.size();
				break;
			case 7:
				System.out.println("Exiting Program");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Operation. Choose Another.");
				choice = 0;
				break;
			}
		}

	}
	
	public static class CustomStack{
		Scanner scanner;
		Queue<Integer> queue1;
		Queue<Integer> queue2;
		int size;
		int element;
		
		CustomStack(){
			scanner = new Scanner(System.in);
			queue1 = new LinkedList<>();
			queue2 = new LinkedList<>();
			size = 0;
		}
		
		public void push(){
			System.out.println("Push Operation");
			System.out.println("Enter element to Push -\t");
			element = scanner.nextInt();
			if(queue1.isEmpty()){
				queue1.add(element);
				size++;
			} else {
				while(!queue1.isEmpty()){
					queue2.add(queue1.peek());
					queue1.remove();
				}
				queue1.add(element);
				while(!queue2.isEmpty()){
					queue1.add(queue2.peek());
					queue2.remove();
				}
				size++;
			}
			System.out.println("Element Pushed");
			System.out.println();
			display();
		}
		
		public void pop(){
			System.out.println("Pop Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			element = queue1.poll();
			System.out.println(element + " Pop from Stack");
			System.out.println();
			size--;
			display();
		}
		
		public void peek(){
			System.out.println("Peek Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			System.out.println(queue1.peek() + " is Peek element");
			System.out.println();
		}
		
		public void search(){
			System.out.println("Search Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			System.out.print("Enter element to found -\t");
			element = scanner.nextInt();
			boolean elementFound = false;
			int trackIndex = 0;
			for(Integer item : queue1){
				trackIndex++;
				if(item == element){
					elementFound = true;
					System.out.println(element + " found at index - " + trackIndex);
				}
			}
			System.out.println();
			if(elementFound != true){
				System.out.println(element + " not found.");
			}
		}
		
		public void display(){
			System.out.println("Display Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			System.out.println("Elements are -> " + queue1.toString());
			System.out.println();
		}
		
		public void size(){
			System.out.println("Size Operation");
			if(queue1.isEmpty()){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			System.out.println("Size is - " + size);
			System.out.println();
		}
	}
}
