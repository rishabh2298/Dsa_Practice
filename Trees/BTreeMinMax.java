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
	
	
	public static void main(String[] args) {
		
		sc = new Scanner(System.in);
	
		createBinaryTree();
	}
	
}
