package com.sumitaccess007.QueueImplementation_021;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.sumitaccess007.QueueImplementation_021.QueueImplementationUsingArray.CustomQueue;

public class QueueImplementationUsingArrayList {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomQueue customQueue = new CustomQueue();
		int choice = 0;

		while(choice < 7){
			System.out.println();
			System.out.print("Queue Operations -\n");
			System.out.print("1.) Enqueue \n");
			System.out.print("2.) Dequeue \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Search \n");
			System.out.print("5.) Display \n");
			System.out.print("6.) Exit \n");
			
			System.out.println();
			System.out.print("Choose Queue Operations -\t");
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
				System.out.println("Esiting Program");
				System.exit(0);
				break;
			default:
				System.out.println(choice + " Invalid Option. Choose Another -");
				choice = 0;
				break;
			}
		}
	}
		public static class CustomQueue{
			Scanner scanner = new Scanner(System.in);
			static final int DEFAULT_CAPACITY = 7;
			int front, rear;
			List<Integer> queue;
			
			CustomQueue(){
				this.queue = new ArrayList<Integer>();
				this.front = -1;
				this.rear = -1;
			}
			
			public void enqueue(){
				System.out.println("Enqueue Operation");
				if(rear >= DEFAULT_CAPACITY - 1){
					System.out.println("Queue is Full");
					System.out.println();
					return;
				} else if (front == -1 && rear == -1){
					front = 0;
					rear = 0;
				} else {
					rear++;	
				}
				System.out.print("Enter element to insert -\t");
				int element = scanner.nextInt();
				if(queue.size() > rear){
					queue.set(rear, element);
				} else {
					queue.add(element);
				}
				System.out.println(element + " Added to Queue - [front, rear] -> [" + front + ", " + rear + "]");
				display();
				System.out.println();
			}

			public void dequeue(){
				System.out.println("Dequeue Operation");
				int element;
				if(front == -1 && rear == -1){
					System.out.println("Empty Queue");
					System.out.println();
					return;
				} else if (front == rear){
					element = queue.get(front);
					front = -1;
					rear = -1;
				} else {
					element = queue.get(front);
					front++;
				}
				System.out.println(element + " Dequeued from Queue - [front, rear] -> [" + front + ", " + rear + "]");
				display();
				System.out.println();
			}

			public void peek(){
				System.out.println("Peek Operation");
				if(front == -1 && rear == -1){
					System.out.println("Empty Queue");
					System.out.println();
					return;
				} else {
					System.out.println("Peek element - " + queue.get(front));
					System.out.println();
				}
			}

			public void search(){
				System.out.println("Search Operation");
				int element;
				boolean elementFound = false;
				int indexTracker = -1;
				if(front == -1 && rear == -1){
					System.out.println("Empty Queue");
					return;
				} else {
					System.out.print("Enter element to Search -\t");
					element = scanner.nextInt();
					for(int i=front; i<=rear; i++){
						indexTracker++;
						if(queue.get(i) == element){
							System.out.println(element + " is Present at index " + indexTracker);
							elementFound = true;
						}
					}
					if(elementFound == false){
						System.out.println(element + " Not Found");
						System.out.println();
					}
				}
			}

			public void display(){
				System.out.println("Display Operation");
				System.out.print("Queue is =>\t");
				if(front == -1 && rear == -1){
					System.out.println();
				} else {
					for(int i=front; i<=rear; i++){
						System.out.print(queue.get(i) + " => ");
					}
				}
				System.out.println();
			}
		}
}
