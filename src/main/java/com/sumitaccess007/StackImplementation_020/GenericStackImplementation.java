package com.sumitaccess007.StackImplementation_020;

import java.util.ArrayList;
import java.util.List;

/**
* StackImplementation - Generic Implementation
* ArrayList Implementation
* @author  Sumit Sharma
* @version 1.0
*/

public class GenericStackImplementation {

	public static class CustomStack<T>{
		public static final int DEFAULT_CAPACITY = 4;
		List<T> stack;
		int top;

		public CustomStack() {
			stack = new ArrayList<T>(DEFAULT_CAPACITY);
			top = -1;
		}
		
		void push(T x){
			if(top + 1 == DEFAULT_CAPACITY){
				System.out.println("Stack Overflow");
			} else {
				top++;
				// Once List is full, start replacing the elements using set() method
				if(stack.size() > top){
					stack.set(top, x);
				} else {
					stack.add(x);
				}
			}
		}
		
		void pop(){
			if(top == -1){
				System.out.println("Stack Underflow");
			} else {
				top--;
			}
		}
		
		T top(){
			if(top == -1){
				System.out.println("Stack Underflow");
				return null;
			} else {
				return stack.get(top); 
			}
		}
		
		boolean isEmpty(){
			return top == -1;
		}
		
		@Override
		public String toString() {
			String result = "";
			for(int i=0; i<=top; i++){
				result += String.valueOf(stack.get(i) + "->");
			}
			return result;
		}
		
	}
	
	public static void main(String[] args) {
		// Integer Stack
		CustomStack<Integer> customStack1 = new CustomStack<Integer>();
		customStack1.push(10);
		customStack1.push(20);
		customStack1.push(30);
		customStack1.push(40);
		System.out.println("After Pushing 10, 20, 30, 40, 50 => " + customStack1);
		customStack1.push(50);
		System.out.println("After Pushing 10, 20, 30, 40, 50 => " + customStack1);
		customStack1.pop();
		customStack1.push(50);
		System.out.println("After Pushing 10, 20, 30, 40, 50 => " + customStack1);
		customStack1.push(60);
		customStack1.pop();
		customStack1.push(70);
		customStack1.pop();
		customStack1.push(80);
		customStack1.pop();
		customStack1.pop();
		customStack1.push(90);
		customStack1.push(100);
		System.out.println("Stack size is -> " + customStack1.stack.size());
		System.out.println("Stack After Pop => " + customStack1);
		
		CustomStack<String> customStack2 = new CustomStack<String>();
		customStack2.push("A");
		customStack2.push("B");
		customStack2.push("C");
		System.out.println("After Pushing A, B, C => " + customStack2);
		customStack2.pop();
		System.out.println("Stack After Pop => " + customStack2);
		System.out.println("Top Element => " + customStack2.top());
		
		CustomStack<Float> customStack3 = new CustomStack<Float>();
		customStack3.push(10.40f);
		customStack3.push(20.40f);
		customStack3.push(30.40f);
		System.out.println("After Pushing 10.40, 20.40, 30.40 => " + customStack3);
		customStack3.pop();
		System.out.println("Stack After Pop => " + customStack3);
		System.out.println("Top Element => " + customStack3.top());
		
	}

}
