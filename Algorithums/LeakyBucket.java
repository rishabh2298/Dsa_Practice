package Algorithums;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.locks.ReentrantLock;

public class demo2 {

	private static class Bucket {
		
		private final int capacity;
		private final double leakRate;
		private double waterLevel;
		private long lastLeakTime;
		
		private final ReentrantLock lock = new ReentrantLock();
		
		
		public Bucket(int capacity, double leakRate) {
			this.capacity = capacity;
			this.leakRate = leakRate;
			this.lastLeakTime = System.currentTimeMillis();
			this.waterLevel = 0;
		}
		
		public boolean addData(double dataSize) {
			lock.lock();
			
			try {
				leak();
				if(dataSize + waterLevel <= capacity) {
					waterLevel += dataSize;
					System.out.println("Water Level : " + waterLevel + " at Time : "+ new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
					return true;
				}
				else {
					System.out.println("Water Level : " + waterLevel + " at Time : "+ new SimpleDateFormat("HH:mm:ss").format(new Date(System.currentTimeMillis())));
					return false;
				}
			} finally {
				lock.unlock();
			}
		}
		
		public void leak() {
			long now = System.currentTimeMillis();
			long timeElapsed = now - lastLeakTime;
			double leakedAmount = (timeElapsed * leakRate) / 1000.0;
			
			if(leakedAmount > 0.0) {
				lastLeakTime = now;
				waterLevel = Math.max(0, waterLevel - leakedAmount);
				System.out.println("Leaked Amount : " + leakedAmount + " and updated Leak Time : "+ new SimpleDateFormat("HH:mm:ss").format(new Date(now)));
			}
		}
		
		public double getWaterLevel() {
			lock.lock();
			try {
				leak();
				return waterLevel;
			}
			finally {
				lock.unlock();
			}
		}
	}
	
	public static void main(String[] args) {
		Bucket bucket = new Bucket(10, 2);
		
		Thread producer = new Thread(() -> {
			int[] dataList = {1,2,3,4,5,1,2,3,4,5};
			
			for(int data : dataList) {
				if(bucket.addData(data)) {
					System.out.println("Data added successfully, water level : " + bucket.getWaterLevel());
				}
				else {
					System.out.println("Failed to add data, Water Level : " + bucket.getWaterLevel() + " data size : " + data);
				}
				
				try {
					Thread.sleep(500);
				} catch (InterruptedException iex) {
					iex.printStackTrace();
				}
			}
			
		});
		
		
		Thread consumer = new Thread(() -> {
			while(true) {
				System.out.println("Current water level : " + bucket.getWaterLevel());
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		producer.start();
		consumer.start();

	}
	
}

