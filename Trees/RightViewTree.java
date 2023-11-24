package Dsa_Practice.Trees;

import java.util.ArrayList;
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
	
	
	static void printRightView2(Node rootNode, ArrayList<Node> list, int level) {
		
		if(rootNode == null) {
			return;
		}
		
		
		list.set(level, rootNode);
		
		printRightView2(rootNode.leftNode, list, level + 1);
		printRightView2(rootNode.rightNode, list, level + 1);
		
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {4,7,-1,-1,6,-1,2,5,-1,-1,1,3,-1,-1,-1};
		
		Node rootNode = builtTree(arr);
		
		// Way-1 TC=O(N) SC= (Max elem at a particular level + null)
		printRightView1(rootNode);
		

		// Way-2 TC=O(N) SC= (H);
		int maxHeight = heightOfTree(rootNode);
		
		ArrayList<Node> list = new ArrayList();
		
		for(int i=0; i<maxHeight; i++) {
			list.add(null);
		}
		
		printRightView2(rootNode, list, 0);
		
		for(Node node : list) {
			System.out.print(node.data + " ");
		}
		System.out.println();
		
//		4 6 2 1 3 
//		4 6 2 1 3 

	}
}
