// 1 
// 2 3 
// 4 5 6 


package Dsa_Practice.Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
	
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
		
		public static Node builtBinaryTree(int[] nodes) {
			idx++;
			
			if(nodes[idx] == -1) {
				return null;
			}
			
			
			Node newNode = new Node(nodes[idx]);
			newNode.leftNode = builtBinaryTree(nodes);
			newNode.rightNode = builtBinaryTree(nodes);
			
			return newNode;
		}
		
	}
	
	
	public static void levelOrder(Node node) {
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(node);
		queue.add(null);
		
		while(!queue.isEmpty()) {

			Node currNode = queue.remove();
			
			if(currNode == null) {
				System.out.println();
				if(queue.isEmpty()) {
					break;
				}
				else {
					queue.add(null);
				}
			}
			else {
				System.out.print(currNode.data + " ");
				
				if(currNode.leftNode != null) {
					queue.add(currNode.leftNode);
				}
				
				if(currNode.rightNode != null) {
					queue.add(currNode.rightNode);
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		
		int[] nodes = {1,2,4,-1,-1,5,-1,-1,3,-1,6,-1,-1};
		
		Node rootNode = BinaryTree.builtBinaryTree(nodes);
		
		levelOrder(rootNode);
	
    }
	
}
