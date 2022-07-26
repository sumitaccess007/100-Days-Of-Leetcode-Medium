package com.sumitaccess007.QueueImplementation_021;

import java.util.Scanner;


public class QueueImplementationUsingLinkedList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomQueue customQueue = new CustomQueue();
		int choice = 0;
		
		while(choice < 8){
			System.out.print("Queue Operations - \n");
			System.out.print("1.) Enqueue \n");
			System.out.print("2.) Dequeue \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Search \n");
			System.out.print("5.) Display \n");
			System.out.print("6.) Size \n");
			System.out.print("7.) Exit \n");
			System.out.println();
			
			System.out.print("Choose Queue Operation -\t");
			choice = scanner.nextInt();
			
			switch(choice){
				case 1:
					customQueue.enqueue();
					break;
				case 2:
					customQueue.dequeue();
					break;
				case 3:
					customQueue.peek();
					break;
				case 4:
					customQueue.search();
					break;
				case 5:
					customQueue.display();
					break;
				case 6:
					customQueue.size();
					break;
				case 7:
					System.out.println("Exiting Program");
					System.exit(0);
					break;
				default:
					System.out.println(choice + " Invalid Operation. Choose Another");
					choice = 0;
					break;
			}
		}
	}

	private static class Node{
		private int data;
		private Node next;
		
		Node(int data){
			this.data = data;
			this.next = null;
		}
	}

	static class CustomQueue{
		Scanner scanner = new Scanner(System.in);
		private Node rear;
		private Node front;
		private int size;
		private int data;
		
		CustomQueue(){
			this.rear = null;
			this.front = null;
			this.size = 0;
			this.data = 0;
		}

		public void enqueue(){
			System.out.println("Enqueue Operation");
			System.out.print("Enter data to Enqueue -\t");
			data = scanner.nextInt();

			// Create Node
			Node newNode = new Node(data);

			if(rear == null && front == null){
				rear = newNode;
				front = newNode;
			} else {
				rear.next = newNode;
				rear = newNode;
			}

			size++;
			System.out.println("Data Enqueued");
			System.out.println();
			display();
		}

		public void dequeue(){
			System.out.println("Dequeue Operation");
			if(rear == null && front == null){
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			}

			if(rear == front){
				System.out.println(rear.data + " Dequeued");
				System.out.println();
				rear = null;
				front = null;
			} else {
				System.out.println(front.data + " Dequeued");
				System.out.println();
				front = front.next;
			}
			
			size--;
			display();
		}

		public void peek(){
			System.out.println("Peek Operation");
			if(rear == null && front == null){
				System.out.println("Queue is Empty");
				System.out.println();
			} else {
				System.out.println(front.data + " is top element");
				System.out.println();
			}
		}

		public void search(){
			System.out.println("Search Operation");
			if(rear == null && front == null){
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			}
			System.out.print("Enter data to search-\t");
			data = scanner.nextInt();
			boolean elementFound = false;
			int indexTrack = 0;
			Node tempNode = front;

			while(tempNode.next != null){
				if(tempNode.data == data){
					System.out.println(tempNode.data + " Found at Index - " + indexTrack);
					elementFound = true;
				}
				tempNode = tempNode.next;
				indexTrack++;
			}
			if(tempNode.data == data){
				System.out.println(tempNode.data + " Found at Index - " + indexTrack);
				elementFound = true;
			}
			if(elementFound == false){
				System.out.println(data + " Not Found");
				System.out.println();
			}
		}

		public void display(){
			System.out.println("Display Operation");
			if(rear == null && front == null){
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			}

			Node tempNode = front;
			System.out.print("Queue is => \t");
			while(tempNode.next != null){
				System.out.print(tempNode.data + " -> ");
				tempNode = tempNode.next;
			}
			System.out.print(tempNode.data + "\t");
			System.out.println();
			System.out.println();
		}
		
		public void size(){
			System.out.println("Size Operation");
			System.out.println("Length of Queue is - " + size);
			System.out.println();
		}
	}

}
