import java.util.Arrays;

public class QueueImplementationUsingArray {
	
	static class Queue{
		
		int[] arr;
		int size;
		int front;
		int rear;
		
		
		public Queue(int N) {
			this.arr = new int[N];
			this.size = N;
			this.front = -1;
			this.rear = -1;
		}
		
		
		void offer(int data) {
			
			if(this.rear == this.size-1) {
				System.out.println("Queue is Full...");
			}
			else {
				this.rear++;
				if(rear == 1) {
					front++;
				}
				this.arr[rear] = data;
			}
		}
		
		
		int poll() {
			
			if(this.front == -1) {
				System.out.println("Queue is Empty...");
				return -1;
			}
			else {
				int value = this.arr[0];
				for(int i=0; i<rear; i++) {
					this.arr[i] = this.arr[i+1]; 
				}
				this.arr[rear] = 0;
				rear--;
				return value;
			}
		}
		
		
		int size() {
			return this.rear + 1;
		}
		
		
		int peek() {
			
			if(this.front == -1) {
				System.out.println("Queue is Empty...");
				return -1;
			}
			
			return this.arr[front];
		}
		
		
		boolean isEmpty() {
			return this.rear == -1;
		}
		
		
		void print() {
			System.out.println(Arrays.toString(this.arr));
		}
		
	}
	
	
	public static void main(String[] args) {
		
		QueueImplementationUsingArray.Queue queue = new Queue(5);
		
		queue.offer(1);
		queue.offer(2);
		queue.offer(3);
		
		queue.print();
		
		System.out.println("Front element = " + queue.peek());
		
		System.out.println("Removed element = " + queue.poll());
		System.out.println("Removed element = " + queue.poll());
		
		System.out.println("Front element = " + queue.peek());
		
		queue.print();
		
		queue.offer(4);
		queue.offer(5);
		queue.offer(6);
		queue.offer(7);
		queue.offer(8);
		
		queue.print();
		
		System.out.println("Removed element = " + queue.poll());
		System.out.println("Removed element = " + queue.poll());
		
		queue.print();
		
		System.out.println(queue.size());
		
		System.out.println("Queue is Empty = "+ queue.isEmpty());
		
	}
	
}
