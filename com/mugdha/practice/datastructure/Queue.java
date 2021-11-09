package com.mugdha.practice.datastructure;

public class Queue {
	
	private int size;
	private int front;
	private int rear;
	private int[] queue;
	
	Queue(int size){
		queue = new int[size];
		this.size = size;
		front = 0;
		rear = 0;
	}
	
	public void dequeue() {
		if(!isEmpty()) {
			front = (front + 1)%size;
			size--;
		}else {
			System.out.println("queue is empty");
		}
	}
	
	public void enqueue(int data) {
		if(!isFull()) {
			queue[rear] = data;
			rear = (rear + 1)%size;
			size++;}
		else {
			System.out.println("queue is full");
		}
	}
	
	public boolean isFull(){
		return size == queue.length;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public void printQueue() {
		for(int i = 0; i< rear; i++) {
			System.out.print(queue[(front + i)%size] + " ");
		}
	}

}
