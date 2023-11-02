package Dsa_Practice.Trees;

import java.util.Arrays;

public class CircularQueueImplementationUsingArray {
	
	static class CircularQueue{

		int[] arr;
		int size;
		int front;
		int rear;
		
		
		public CircularQueue(int size) {
			this.arr = new int[size];
			this.size = size;
			this.front = -1;
			this.rear = -1;
		}
		
		
		void enqueue(int data) {
			if((this.rear +1)%size == front) {
				System.out.println("Queue is Full...");
				return;
			}
			else if(this.front == -1){
				this.front = 0;
			}
			this.rear = (this.rear+1)%size;
			this.arr[rear] = data;
		}
		
		void printQueue() {
			StringBuilder result = new StringBuilder();
			
			for(int i=front; i<=rear; i++) {
				if(front == size-1 && rear != size-1) {
					result.append(this.arr[i]+" ");
					i = 0;
				}
				else {
					result.append(this.arr[i]+" ");
				}
			}
			System.out.println(Arrays.toString(this.arr));
			System.out.println(result.toString());
		}
		
		
		int peek() {
			return 0;
		}
		
		
		boolean isEmpty() {
			return false;
		}
		
		
		int sizeOfQueue() {
			return 0;
		}
		
	}
	
	public static void main(String[] args) {
		
		CircularQueue circularQueue = new CircularQueue(5);
		
		// System.out.println("Dequeue Element = "+ circularQueue.dequeue());
		
		circularQueue.enqueue(10);
		circularQueue.enqueue(20);
		circularQueue.enqueue(30);
		
		circularQueue.printQueue();
		
		// System.out.println("Dequeue Element = "+ circularQueue.dequeue());
		// System.out.println("Dequeue Element = "+ circularQueue.dequeue());
		
		circularQueue.printQueue();
		
		circularQueue.enqueue(10);
		circularQueue.enqueue(20);
		circularQueue.enqueue(30);
		
		circularQueue.enqueue(40);
		circularQueue.enqueue(50);
		circularQueue.enqueue(60);
		
		circularQueue.printQueue();
		
	}
	
}
