package com.sumitaccess007.QueueImplementation_021;

import java.util.Scanner;

public class QueueImplementationUsingCircularArray {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		CustomQueue customQueue = new CustomQueue();
		int choice = 0;
		
		while(choice < 8){
			System.out.print("Queue Operations -\n");
			System.out.print("1.) Enqueue \n");
			System.out.print("2.) Dequeue \n");
			System.out.print("3.) Peek \n");
			System.out.print("4.) Search \n");
			System.out.print("5.) Display \n");
			System.out.print("6.) Size \n");
			System.out.print("7.) Exit \n");
			
			System.out.print("Choose Queue Operations -\t");
			choice = scanner.nextInt();
			System.out.println();
			
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
					System.out.println(choice + " is Invalid. Choose Another -");
					System.out.println();
					choice = 0;
					break;
			}
		}
	}
	
	public static class CustomQueue{
		static final int DEFAULT_CAPACITY = 8;
		Scanner scanner = new Scanner(System.in);
		int[] queue;
		int length;
		int front, rear;
		int size, data;
		
		CustomQueue(){
			this.queue = new int[DEFAULT_CAPACITY];
			this.length = queue.length;
			this.front = this.rear = -1;
			this.size = this.data = 0;
		}
		
		public void enqueue(){
			System.out.println("Enqueue Operation -");
			if(((rear+1)%length) == front){
				System.out.println("Queue is Full");
				System.out.println();
				return;
			}
			System.out.print("Enter element to Enqueue -\t");
			data = scanner.nextInt();
			if(rear == -1 && front == -1){
				rear++;
				front++;
			} else {
				rear = (rear+1)%length;
			}
			queue[rear] = data;
			size++;
			System.out.println(data + " Enqueued");
			System.out.println();
			display();
		}

		public void dequeue(){
			System.out.println("Dequeue Operation -");
			if(rear == -1 && front == -1){
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			}
			data = queue[front];
			if(rear == front){
				rear = front = -1;
			} else {
				front = (front+1)%length;
			}
			size--;
			System.out.println(data + " Dequeued");
			System.out.println();
			display();
		}

		public void peek(){
			System.out.println("Peek Operation -");
			if(rear == -1 && front == -1){
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			}
			System.out.println("Peek element is - " + queue[front]);
			System.out.println();
		}

		public void search(){
			System.out.println("Search Operation -");
			if(rear == -1 && front == -1){
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			}
			System.out.print("Enter element to Search -\t");
			data = scanner.nextInt();
			boolean elementFound = false;
			int indexTrack = 0;
			System.out.println("[rear, front] - [" + rear + ", " + front + "]");
			if(rear >= front){
				for(int i=front; i<=rear; i++){
					if(queue[i] == data){
						System.out.println(data + " found at index " + indexTrack);
						elementFound = true;
					}
					indexTrack++;
				}
			} else {
				for(int i=front; i<length; i++){
					if(queue[i] == data){
						System.out.println(data + " found at index " + indexTrack);
						elementFound = true;
					}
					indexTrack++;
				}
				indexTrack = 0;
				for(int i=0; i<=rear; i++){
					if(queue[i] == data){
						System.out.println(data + " found at index " + indexTrack);
						elementFound = true;
					}
					indexTrack++;
				}
			}
			System.out.println();
			if(elementFound == false){
				System.out.println(data + " not Found");
				System.out.println();
			}
		}

		public void display(){
			System.out.println("Display Operation -");
			if(rear == -1 && front == -1){
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			}
			System.out.print("Queue is => ");
			if(rear >= front){
				for(int i=front; i<=rear; i++){
					System.out.print(queue[i] + " -> ");
				}
			} else {
				for(int i=front; i<length; i++){
					System.out.print(queue[i] + " -> ");
				}
				for(int i=0; i<=rear; i++){
					System.out.print(queue[i] + " -> ");
				}
			}

			System.out.println();
			System.out.println();
		}

		public void size(){
			System.out.println("Size Operation -");
			if(rear == -1 && front == -1){
				System.out.println("Queue is Empty");
				System.out.println();
				return;
			}
			System.out.println("Queue Size is - " + size);
			System.out.println();
		}
	}

}
