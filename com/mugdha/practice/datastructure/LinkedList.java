package com.mugdha.practice.datastructure;

public class LinkedList {
	
	Node head;
	
	public static class Node{
		int data;
		Node next;
		
		public Node() {
			
		}
		public Node(int data) {
			this.data = data;
			this.next = null;
		}
		
		public static LinkedList insert(LinkedList list, int data) {
			Node newNode = new Node(data);
			
			//if the list is empty make the head as the newNode
			if(list.head == null) {
				list.head = newNode;
			}else {
				//else traverse till the end
				Node last = list.head;
				while(last.next != null) {
					last = last.next;
				}
				last.next = newNode;
			}
			return list;
		}
		
		public static void main(String args[]) {
			LinkedList list = new LinkedList();
			
			insert(list, 1);
			insert(list, 2);
			
			Node currentNode = list.head;
			while(currentNode.next != null) {
				System.out.println( currentNode.data);
				currentNode = currentNode.next;
			}
		}
	}

}
