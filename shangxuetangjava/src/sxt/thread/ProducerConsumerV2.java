package sxt.thread;

import java.util.Random;

public class ProducerConsumerV2 {
	public static void main(String[] args) {
		Wok wok = new Wok();
		ProducerV2 p = new ProducerV2(wok);
		ConsumerV2 c = new ConsumerV2(wok);
		p.start();
		c.start();
	}
}

class Wok {
	private int[] container = new int[256];
	private int top;
	
	public Wok() {
		top = 0;
	}

	public synchronized void add(int bun) {
		while (top >= container.length) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		container[top++] = bun;
		notify();
	}
	
	// remove a bun from the wok
	public synchronized int remove() {
		while (top == 0) {
			try {
				wait();
			}
			catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		int bun = container[--top];
		notify();
		return bun;
	}
}

class ProducerV2 extends Thread {
	private Wok wok;
	private Random rand;
	public ProducerV2(Wok wok) {
		this.wok = wok;
		rand = new Random();
	}
	
	@Override
	public void run () {
		while (true) {
			int bun = rand.nextInt();
			wok.add(bun);
			System.out.println("Producing bun " + bun);
		}
	}
}

class ConsumerV2 extends Thread {
	private Wok wok;
	public ConsumerV2(Wok wok) {
		this.wok = wok;
	}
	
	@Override
	public void run () {
		while (true) {
			System.out.println("Consuming bun " + wok.remove());
		}
	}
}