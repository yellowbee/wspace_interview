package sxt.thread;

import java.util.Random;

public class ProducerConsumer {
	public static void main(String[] args) {
		IntBuffer buffer = new IntBuffer();
		Producer p = new Producer(buffer);
		Consumer c = new Consumer(buffer);
		p.start();
		c.start();
	}
}

class IntBuffer {
	private int index;
	private int[] buffer = new int[8];
	
	// synchronization will cause a lock up
	// whenever the buffer is full in add()
	// or empty in remove()
	public synchronized void add(int num) {
		while (index == buffer.length - 1) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				
			}
		}
		buffer[index++] = num;
		notifyAll();
	}
	
	public synchronized int remove() {
		while (index == 0) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				
			}
		}
		int ret = buffer[--index];
		notifyAll();
		return ret;
	}
}

class Producer extends Thread {
	private IntBuffer buffer;
	public Producer(IntBuffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		Random r = new Random();
		while (true) {
			int num = r.nextInt();
			buffer.add(num);
			System.out.println("Produced " + num);
		}
	}
}
class Consumer extends Thread {
	private IntBuffer buffer;
	public Consumer(IntBuffer buffer) {
		this.buffer = buffer;
	}
	
	public void run() {
		while (true) {
			int num = buffer.remove();
			System.out.println("Consumed " + num);
		}
	}
}