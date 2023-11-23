package Dsa_Practice.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewTree {

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
	
	
	static int heightOfTree(Node rootNode) {
		
		if(rootNode == null) {
			return 0;
		}
		
		
		int leftHeight = heightOfTree(rootNode.leftNode);
		int rightHeight = heightOfTree(rootNode.rightNode);
		
		return Math.max(leftHeight, rightHeight) + 1;
	}
	
	
	static void printRightView1(Node rootNode) {
		
		if(rootNode == null) {
			return;
		}
		

		Queue<Node> queue = new LinkedList<>();
		
		queue.add(rootNode);
		queue.add(null);
		
		while(!queue.isEmpty()) {
			
			Node currNode = queue.remove();
			
			if(currNode == null) {
				if(queue.isEmpty()) {
					break;
				}
				else {
					queue.add(null);
				}
			}
			else {
				if(queue.peek() == null) {
					System.out.print(currNode.data + " ");
				}
				
				if(currNode.leftNode != null) {
					queue.add(currNode.leftNode);
				}
				if(currNode.rightNode != null) {
					queue.add(currNode.rightNode);
				}
			}
		}
		
		System.out.println();
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {4,7,-1,-1,6,-1,2,5,-1,-1,1,3,-1,-1,-1};
		
		Node rootNode = builtTree(arr);
		
		
		printRightView1(rootNode);
		
	}
}
