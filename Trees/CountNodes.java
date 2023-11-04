package Dsa_Practice.Trees;

public class CountNodes {
	
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
	
	
	public static int countNode(Node node) {
		
		if(node == null) {
			return 0;
		}
		
		
		int leftCount = countNode(node.leftNode);
		int rightCount = countNode(node.rightNode);
		
		return leftCount + rightCount + 1;
	}
	
	
	public static void main(String[] args) {
		
		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		
		Node rootNode = BinaryTree.builtTree(nodes);
		
		System.out.println(countNode(rootNode));
		
	}
	
}
