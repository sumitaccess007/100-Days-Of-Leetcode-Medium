package com.sumitaccess007.StackImplementation_020;

public class StackImplementationBasic {
	public static void main(String[] args){
		CustomStack customStack = new CustomStack(6);
		
		customStack.push(10);
		customStack.push(20);
		customStack.push(30);
		customStack.push(40);
		System.out.println(customStack.peek());
		System.out.println(customStack.pop());
		System.out.println(customStack.empty());
		System.out.println("Stack Elements - " + customStack.toString());
	}
	
	public static class CustomStack{
		private int[] customStack;
		private int capacity;
		private int top;
		
		public CustomStack(int capacity) {
			this.customStack = new int[capacity];
			this.capacity = capacity;
			this.top = -1;
		}
		
		public void push(int element){
			if(top == capacity - 1){
				throw new RuntimeException("Stack is Full");
			}
			customStack[++top] = element;
		}
		
		public int pop(){
			if(top == -1){
				throw new RuntimeException("Stack is Empty");
			}
			return customStack[top--];
		}
		
		public int peek(){
			if(top == -1){
				throw new RuntimeException("Stack is Empty");
			}
			return customStack[top];
		}
		
		public boolean empty(){
			return top == -1;
		}
		
		public String toString(){
			String result = "";
			for(int i=0; i<=top; i++){
				result += customStack[i] + " -> ";
			}
			return result;
		}
	}

}
