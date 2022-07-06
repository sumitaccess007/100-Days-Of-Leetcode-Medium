package com.sumitaccess007.StackImplementation_020;

import java.util.Scanner;
/**
* StackImplementation - Using LinkedList
* LinkedList Implementation - is dynamic. It does not grow and shrink depending on needs at runtime.
* 1. Every New Element is Inserted as 'top' Element.
* 2. OR To implement Stack using LinkedList - We have to perform all the operations on Head or top.
* 3. The next field of the first element must be always NULL
* 4. Every newly inserted element is pointed by top.
* 5. During remove (or Pop), remove the node which is pointed by 'top' or 'head' by moving 'top' or 'head' to its previous element. 
* @author  Sumit Sharma
* @version 1.0
*/
public class StackImplementationUsingLinkedList {

	public static void main(String[] args) {
		CustomStack customStack = new CustomStack();
		Scanner scanner = new Scanner(System.in);
		int choice = 0;
		
		while(choice < 8){
			System.out.print("Stack Operations - \n");
			System.out.print("1.) Push \n");
			System.out.print("2.) Pop \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Empty \n");
			System.out.print("5.) Search \n");
			System.out.print("6.) Display \n");
			System.out.print("7.) Size \n");
			System.out.print("8.) Exit \n");
			
			System.out.print("Choose Stack Operation -\t");
			choice = scanner.nextInt();
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
				customStack.empty();
				break;
			case 5:
				customStack.search();
				break;
			case 6:
				customStack.display();
				break;
			case 7:
				customStack.size();
				break;
			case 8:
				System.out.println("Exiting Program");
				System.exit(0);
				break;
			default:
				System.out.println("Invalid Choice. Choose Another");
				choice = 0;
				break;
			}
		}
	}

	static class Node{
		int data;
		Node next;
		
		Node(int data){
			this.data = data;
		}
	}
	
	static class CustomStack{
		Scanner scanner = new Scanner(System.in);
		Node top;
		int size;
		
		CustomStack() {
			this.top = null;
			this.size = 0;
		}
		
		public void push(){
			System.out.println("Push Operation");
			System.out.print("Enter data to push -\t");
			int data = scanner.nextInt();
			
			// Create New Node
			Node newNode = new Node(data);
			
			// Make New Node as Head/Top Node
			newNode.next = top;
			size++;
			top = newNode;
			System.out.print(data + " Pushed to Stack. \n");
			System.out.println();
			display();
		}

		public void pop(){
			System.out.println("Pop Operation");
			if(top == null){
				System.out.println("Stack Empty");
				System.out.println();
				return;
			}
			Node tempNode = top;
			top = top.next;
			size--;
			System.out.println(tempNode.data + " Pop from Stack");
			System.out.println();
		}

		public void peek(){
			System.out.println("Peek Operation");
			if(top == null){
				System.out.println("Stack Empty");
				System.out.println();
				return;
			}
			int peekElement = top.data;
			System.out.println(peekElement + " is at top of the Stack");
			System.out.println();
		}

		public void empty(){
			System.out.println("Empty Operation");
			if(top == null){
				System.out.println("Stack is empty");
				System.out.println();
				return;
			}
			System.out.println("Stack is not Empty");
			System.out.println();
		}

		public void search(){
			System.out.println("Search Operation");
			if(top == null){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			int elementToSearch = scanner.nextInt();
			Node tempNode = top;
			boolean flag = false;
			int index = 0;
			while(tempNode.next != null){
				if(tempNode.data == elementToSearch){
					System.out.println(elementToSearch + " Present at Index " + index);
					flag = true;
				}
				tempNode = tempNode.next;
				index++;
			}
			if(tempNode.data == elementToSearch){
				System.out.println(elementToSearch + " Present at Index " + index);
				System.out.println();
				flag = true;
			}
			if(flag == false){
				System.out.println("Element Not Found");
				System.out.println();
			}
		}

		public void display(){
			System.out.println("Display Operation");
			if(top == null){
				System.out.println("Stack is Empty");
				System.out.println();
				return;
			}
			Node tempNode = top;
			while(tempNode.next != null){
				System.out.print(tempNode.data + "->");
				tempNode = tempNode.next;
			}
			System.out.println(tempNode.data + "->");
			System.out.println();
		}
		
		public void size(){
			System.out.println("Size Operation");
			System.out.println(size + " is size of Stack");
			System.out.println();
		}
	}
}
