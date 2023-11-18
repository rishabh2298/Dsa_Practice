package Dsa_Practice.Trees;

public class BSTInsert {
	
	static class Node{
		int data;
		Node leftNode;
		Node rightNode;
		
		public Node(int data) {
			this.data = data;
		}
	}

	
	static Node insertElement(Node rootNode, int element) {
		
		if(rootNode == null) {
			return new Node(element);
		}
		
		
		if(rootNode.data > element) {
			rootNode.leftNode = insertElement(rootNode.leftNode, element);
		}
		else {
			rootNode.rightNode = insertElement(rootNode.rightNode, element);
		}
		
		return rootNode;
	}
	
	
	static void inOrder(Node rootNode) {
		
		if(rootNode == null) {
			return;
		}
		
		
		inOrder(rootNode.leftNode);
		System.out.print(rootNode.data + " ");
		inOrder(rootNode.rightNode);
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {5,2,7,8,4,3,1,6};
		
		Node rootNode = null;
		
		for(int i=0; i<arr.length; i++) {
			rootNode = insertElement(rootNode, arr[i]);
		}
		
		inOrder(rootNode);
		System.out.println();
	}
}