package Dsa_Practice.Trees;

public class CreateBST {
	
	static class Node{
		int data;
		Node leftNode;
		Node rightNode;
		
		public  Node(int data) {
			this.data = data;
			this.leftNode = null;
			this.rightNode = null;
		}
	}

	
	static Node builtBST(Node rootNode, int element) {
		
		if(rootNode == null) {
			return new Node(element);
		}
		

		if(rootNode.data > element) {
			rootNode.leftNode = builtBST(rootNode.leftNode, element);
		}
		else if(rootNode.data < element) {
			rootNode.rightNode = builtBST(rootNode.rightNode, element);
		}
		
		return rootNode;
	}
	
	
	static void inOrder(Node rootNode) {
		
		if(rootNode == null) {
			return;
		}
		
		inOrder(rootNode.leftNode);
		System.out.println(rootNode.data);
		inOrder(rootNode.rightNode);
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {5,1,3,6,8,2};

		Node rootNode = null;
		
		for(int i=0; i<arr.length; i++) {
			rootNode = builtBST(rootNode, arr[i]);
		}
		
		inOrder(rootNode);
	}
	
}