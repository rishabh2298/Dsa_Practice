
public class CreateLinkedList {

	static class Node{
		int data;
		Node nextNode;
		
		public Node(int data) {
			this.data = data;
			this.nextNode = null;
		}
	}
	
	
	public static Node createLinkedList(int[] arr) {
		
		Node head = new Node(arr[0]);
		
		Node currNode = head;
		System.out.print(currNode.data + " -> ");
		
		int idx = 1;
		
		while(idx < arr.length) {
			
			Node newNode = new Node(arr[idx++]);
			currNode.nextNode = newNode;
			
			currNode = currNode.nextNode;
			
			System.out.print(currNode.data + " -> ");
		}
		
		System.out.println("DONE");
		
		return head;
	}
	
	
	public static void main(String[] args) {
		
		int[] arr = {10,8,3,6,26,5};

		System.out.print("Your Linked List => ");
		createLinkedList(arr);
	}
	
}
