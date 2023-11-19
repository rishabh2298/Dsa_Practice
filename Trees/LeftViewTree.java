package Dsa_Practice.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {
	
	static class Node{
		int data;
		Node leftNode;
		Node rightNode;
		
		Node(int data){
			this.data = data;
		}
	}
	
	
	static int idx = -1;
	
	static Node builtTree(int[] arr) {
		idx++;
		
		if(arr[idx] == -1) {
			return null;
		}
		
		
		Node rootNode = new Node(arr[idx]);
		
		rootNode.leftNode = builtTree(arr);
		rootNode.rightNode = builtTree(arr);
		
		return rootNode;
	}

	
	static void printLeftView(Node rootNode) {
		
		if(rootNode == null) {
			System.out.println("No elements");
			return;
		}
		
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(rootNode);
		queue.add(null);
		
		System.out.print(rootNode.data + " ");
		
		while(!queue.isEmpty()) {
			
			Node currNode = queue.remove();
			
			if(currNode == null) {
				if(queue.isEmpty()) {
					System.out.println();
					break;
				}
				else {
					System.out.print(queue.peek().data + " ");
					queue.add(null);
				}
			}
			else {
				if(currNode.leftNode != null) {
					queue.add(currNode.leftNode);
				}
				if(currNode.rightNode != null) {
					queue.add(currNode.rightNode);
				}
			}
		}
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {4,7,-1,-1};
		
		Node rootNode = builtTree(arr);
		
		printLeftView(rootNode);
	}
	
}
