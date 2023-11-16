package Dsa_Practice.Trees;

public class BSTSearch {
	// Binary Search Tree
	
	static class Node{
		
		int data;
		Node leftNode;
		Node rightNode;
		
		public Node(int data) {
			this.data = data;
			this.leftNode = null;
			this.rightNode = null;
		}
		
	}
	
	
	public static boolean searchElement(Node rootNode, int element) {
		
		if(rootNode == null)
			return false;
		
		if(rootNode.data == element)
			return true;
		
		
		if(rootNode.data < element) {
			return searchElement(rootNode.rightNode, element);
		}
		
		return searchElement(rootNode.leftNode, element);
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {};
		
	}

}
