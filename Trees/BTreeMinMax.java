package Dsa_Practice.Trees;

import java.util.Scanner;

public class BTreeMinMax {

	static Scanner sc;
	
	static class Node{
		int data;
		Node leftNode, rightNode;
		
		Node(int data){
			this.data = data;
		}
	}
	
	
	static Node createBinaryTree() {
		
		Node rootNode = null;
		
		System.out.println("Enter your Node = ");
		int value =  sc.nextInt();
		
		if(value == -1) {
			return null;
		}
		
		rootNode = new Node(value); 
		
		System.out.println("Enter leftNode of "+ value+" =");
		rootNode.leftNode = createBinaryTree();
		
		System.out.println("Enter rightNode of "+ value + " =");
		rootNode.rightNode = createBinaryTree();
		
		return rootNode;
	}
	
	
	static int minOfTree(Node rootNode) {
		
		if(rootNode == null) {
			return Integer.MAX_VALUE;
		}
		
		
		int leftMin = minOfTree(rootNode.leftNode);
		int rightMin = minOfTree(rootNode.rightNode);
		
		return Math.min(Math.min(leftMin, rightMin), rootNode.data);
	}
	
	
	static int maxOfTree(Node rootNode) {
		
		if(rootNode == null) {
			return Integer.MIN_VALUE;
		}
		
		
		int leftMax = maxOfTree(rootNode.leftNode);
		int rightMax = maxOfTree(rootNode.rightNode);
		
		return Math.max(Math.max(leftMax, rightMax), rootNode.data);
	}
	
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
	
		Node rootNode = createBinaryTree();
		
		System.out.println("Minimum value = " + minOfTree(rootNode));
		System.out.println("Maximum value = " + maxOfTree(rootNode));
	}
	
}
