package com.mugdha.practice.datastructure;

public class Stack {
	
	private int[] stack;
	
	private int top;
	
	Stack(int size){
		stack = new int[size];
		top = 0;
	}
	public void push(int data) {
		if(getSize() == stack.length) {
			System.out.println("Stack is full");
		}else {
			stack[top] = data;
			top++;
		}
	}
	
	public void pop() {
		if(!isEmpty()) {
			--top;
			stack[top] = 0;
		}else {
			System.out.println("Stack is Empty");
		}
	}
	
	public int getSize() {
		return top;
	}
	
	public boolean isEmpty() {
		if(top == 0) {
			return true;
		}
		return false;
	}

}
