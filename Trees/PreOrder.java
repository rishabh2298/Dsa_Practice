package Dsa_Practice.Trees;

public class PreOrder {

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
	
	
	static class BinaryTree{
		
		static int idx = -1;
		
		public static Node builtTree(int[] nodes) {
			idx++;
			
			if(nodes[idx] == -1) {
				return null;
			}
			
			Node newNode = new Node(nodes[idx]);
			
			newNode.leftNode = builtTree(nodes);
			newNode.rightNode = builtTree(nodes);
			
			return newNode;
		}
		
	}
	
	
	public static void preOrder(Node node) {
		
		if(node == null) {
			return;
		}
		
		
		System.out.print(node.data +" -> ");
		preOrder(node.leftNode);
		preOrder(node.rightNode);
		
	}
	
	
	public static void main(String[] args) {

		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		
		Node rootNode = BinaryTree.builtTree(nodes);
		
		preOrder(rootNode);
		
		System.out.println("DONE");
	}
	
}
