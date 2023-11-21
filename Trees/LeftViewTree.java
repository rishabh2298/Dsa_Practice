package Dsa_Practice.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LeftViewTree {
	
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

	
	static void printLeftView1(Node rootNode) {
		
		if(rootNode == null) {
			System.out.println("No elements");
			return;
		}
		
		
		Queue<Node> queue = new LinkedList<>();
		
		queue.add(rootNode);
		queue.add(null);
		
		System.out.print(rootNode.data + " ");
		
		while(!queue.isEmpty()) {
			
			Node currNode = queue.remove();
			
			if(currNode == null) {
				if(queue.isEmpty()) {
					System.out.println();
					break;
				}
				else {
					System.out.print(queue.peek().data + " ");
					queue.add(null);
				}
			}
			else {
				if(currNode.leftNode != null) {
					queue.add(currNode.leftNode);
				}
				if(currNode.rightNode != null) {
					queue.add(currNode.rightNode);
				}
			}
		}
		
	}
	
	
	static void printLeftView2(Node rootNode, ArrayList<Node> list, int level) {
		
		if(rootNode == null) {
			return;
		}
		
		
		if(list.size() < level + 1) {
//			list.get(level) == null
			list.add(rootNode);
		}
		
		
		printLeftView2(rootNode.leftNode, list, level + 1);
		printLeftView2(rootNode.rightNode, list, level + 1);
		
	}
	
	
	static ArrayList<Node> list;
	
	public static void main(String[] args) {
		
		int[] arr = {4,7,-1,-1,6,-1,2,5,-1,-1,1,3,-1,-1,-1};
		
		Node rootNode = builtTree(arr);
		
		printLeftView1(rootNode);
		
		list = new ArrayList<>();
		
		printLeftView2(rootNode, list, 0);
		
		for(Node node : list) {
			System.out.print(node.data + " ");
		}
		System.out.println();
		
	}
	
}
