package com.sumitaccess007.QueueImplementation_021;

import java.util.Scanner;

/**
 * QueueImplementation - Using Array Array Implementation - is not dynamic. It
 * does not grow and shrink depending on needs at runtime. Also it is not space
 * optimized. We can implement it in Circular Array Fashion. Insert - happens at
 * REAR End (Increment REAR and Write New Value) Delete - happens at FRONT End
 * (Read Value at FRONT and Increment FRONT) Empty Queue - is represented by
 * setting FRONT and REAR to -1
 * 
 * Real Life Usage - 1. BFS Uses a Queue to keep track of nodes to visit next 2.
 * Printers uses Queue to manage jobs - jobs are printed in the order they
 * submitted 3. Web Servers uses Queue to manage requests - page requests get
 * fulfilled in the order they received 4. Processes wait in the CPU Scheduler's
 * Queue for their turn to run
 * 
 * @author Sumit Sharma
 * @version 1.0
 */

public class QueueImplementationUsingArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomQueue customQueue = new CustomQueue();
		int choice = 0;

		while (choice < 7) {
			System.out.println();
			System.out.print("Queue Operations - \n");
			System.out.print("1.) Enqueue \n");
			System.out.print("2.) Dequeue \n");
			System.out.print("3.) Peek  \n");
			System.out.print("4.) Search  \n");
			System.out.print("5.) Display \n");
			System.out.print("6.) Exit  \n");

			System.out.print("Choose Queue Operation -\t");
			choice = scanner.nextInt();
			System.out.println();

			switch (choice) {
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
				System.out.println("Exiting Program");
				System.exit(0);
				break;
			default:
				System.out.println(choice + " Invalid Option. Choose another");
				choice = 0;
				break;
			}
		}
	}

	public static class CustomQueue {
		private static final int DEFAULT_CAPACITY = 7;
		Scanner scanner = new Scanner(System.in);
		int[] queue;
		int front, rear;

		public CustomQueue() {
			queue = new int[DEFAULT_CAPACITY];
			front = -1;
			rear = -1;
		}

		public void enqueue() {
			System.out.println("Enqueue Operation");
			if (rear >= queue.length-1) {
				System.out.println("Queue is FULL");
				System.out.println();
				return;
			} else if (front == -1 && rear == -1) {
				front = 0;
				rear = 0;
			} else {
				rear++;
			}
			System.out.print("Enter element to Insert -\t");
			int element = scanner.nextInt();
			queue[rear] = element;
			System.out.println("Element added to Queue [rear, front] -> [" + rear + " ," + front +"]");
			display();
			System.out.println();
		}

		public void dequeue() {
			System.out.println("Dequeue Operation");
			int element;
			if (front == -1 && rear == -1) {
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			} else if (front == rear) {
				element = queue[front];
				front = -1;
				rear = -1;
			} else {
				element = queue[front];
				front++;
			}
			System.out.println(element + " Dequeued from Queue [rear, front] -> [" + rear + " ," + front +"]");
			display();
			System.out.println();
		}

		public void peek() {
			System.out.println("Peek Element");
			if (front == -1 && rear == -1) {
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			} else {
				int peek = queue[front];
				System.out.println(peek + " is Peek Element in Queue");
				System.out.println();
			}
		}

		public void search() {
			System.out.println("Search Operation");
			boolean elementFound = false;
			int indexTracker = -1;
			if (front == -1 && rear == -1) {
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			} else {
				System.out.print("Enter element to Search -\t");
				int element = scanner.nextInt();
				for (int i = front; i <= rear; i++) {
					indexTracker++;
					if (queue[i] == element) {
						System.out.println(element + " is Present at index " + indexTracker);
						elementFound = true;
					}
				}
				if (elementFound == false) {
					System.out.println(element + " not found in Queue");
					System.out.println();
				}
			}
		}

		public void display() {
			System.out.println("Display Operation");
			System.out.print("Queue is =>\t");
			if (front == -1 && rear == -1) {
				System.out.println();
				return;
			} else {
				for (int i = front; i <= rear; i++) {
					System.out.print(queue[i] + " => ");
				}
			}
			
		}
	}

}
