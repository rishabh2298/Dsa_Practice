package com.aptitech;

public class SinglyLinkedList {
	
	static class Node{
		String data;
		Node next;
		
		public Node(String data) {
			this.data = data;
			this.next = null;
		}
		
		public Node(String data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	
	
	Node addFirst(String data, Node head) {
		
		Node newNode = new Node(data);
		
		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
		
		return head;
	}
	
	
	void printNode(Node head) {
		
		Node currNode = head;
		
		while(currNode != null) {
			System.out.print(currNode.data + " -> ");
			currNode = currNode.next;
		}
		
		System.out.println("Null");
	}
	
	
	public static void main(String[] args) {
		
		// add First
		
		SinglyLinkedList linkedList = new SinglyLinkedList();
		
		SinglyLinkedList.Node headNode = linkedList.addFirst("a", null);
		headNode = linkedList.addFirst("b", headNode);
		headNode = linkedList.addFirst("c", headNode);
		headNode = linkedList.addFirst("d", headNode);
		linkedList.addFirst("e", headNode);
		
		linkedList.printNode(headNode);
	}
	
}
