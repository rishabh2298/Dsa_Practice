package Dsa_Practice.Trees;
	
public class BSTDelete {

	static class Node{
		int data;
		Node leftNode;
		Node rightNode;
		
		Node(int data){
			this.data = data;
		}
	}
	
	
	static Node insertElement(Node rootNode, int element) {
		
		if(rootNode == null) {
			return new Node(element);
		}
		
		
		if(rootNode.data < element) {
			rootNode.rightNode = insertElement(rootNode.rightNode, element);
		}
		else {
			rootNode.leftNode = insertElement(rootNode.leftNode, element);
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
	
	
	static int findMinInRightTree(Node rootNode) {
		
		int minValue = rootNode.data;
		
		while(rootNode.leftNode != null) {
			minValue = rootNode.leftNode.data;
			rootNode = rootNode.leftNode;
		}
		
		return minValue;
	}
	
	
	static Node deleteElement(Node rootNode, int element) {
		
		if(rootNode == null) {
			return null;
		}
		
		
		if(rootNode.data < element) {
			rootNode.rightNode = deleteElement(rootNode.rightNode, element);
		}
		else if(rootNode.data > element) {
			rootNode.leftNode = deleteElement(rootNode.leftNode, element);
		}
		else {
			
			if(rootNode.leftNode == null) {
				return rootNode.rightNode;
			}
			else if(rootNode.rightNode == null) {
				return rootNode.leftNode;
			}
			else {
				int minValue = findMinInRightTree(rootNode.rightNode);
				
				rootNode.data = minValue;
				rootNode.rightNode = deleteElement(rootNode.rightNode, minValue);
				
				return rootNode;
			}
			
		}
		
		return rootNode;
	}
	
	
	public static void main(String[] args) {
		
		int arr[] = {10,2,11,1,8,4,9,3,6,7,5,12,17,16,14,13,15,18,19};
		
		Node rootNode = null;
		
		for(int i=0; i<arr.length; i++) {
			rootNode = insertElement(rootNode, arr[i]);
		}
		
		inOrder(rootNode);
		System.out.println();
		
		// still its changing main rootNode after deleting element from node2 and node3
		
		Node rootNode2 = rootNode;
		rootNode2 = deleteElement(rootNode2, 12);
		inOrder(rootNode2);
		System.out.println();
		
		Node rootNode3 = rootNode;
		rootNode3 = deleteElement(rootNode3, 17);
		inOrder(rootNode3);
		System.out.println();
	}
	
}
