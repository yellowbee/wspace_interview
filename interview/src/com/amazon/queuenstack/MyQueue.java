package com.amazon.queuenstack;

class MyListNode {
	public int val;
	MyListNode next;
	
	public MyListNode(int val) {
		this.val = val;
		next = null;
	}
}

// Linked list implementation of a queue
public class MyQueue {
	public static void main(String[] args) {
		MyQueue myQ = new MyQueue();
		myQ.enqueue(1);
		myQ.enqueue(2);
		myQ.enqueue(3);
		System.out.println(myQ.toString());
		
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		
		myQ.enqueue(4);
		myQ.enqueue(5);
		myQ.enqueue(6);
		System.out.println(myQ.toString());
		
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		System.out.println(myQ.dequeue());
		
		myQ.enqueue(3);
		System.out.println(myQ.toString());
	}
	
	public MyListNode first;
	public MyListNode last;
	
	public MyQueue() {
		first = null;
		last = null;
	}
	
	// always add new element to the end of the list
	public void enqueue(int x) {
		if (first == null) {
			last = new MyListNode(x);
			first = last;
		}
		else {
			last.next = new MyListNode(x);
			last = last.next;
		}
	}
	
	// always remove element from the start of the list
	public int dequeue() {
		if (first == null) return -1;
		
		int val = first.val;
		if (first == last) {
			first = null;
			last = null;
		}
		else {
			first = first.next;
		}
		
		return val;
	}
	
	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		MyListNode p = first;
		while (p != null) {
			sb.append(p.val + " ");
			p = p.next;
		}
		return sb.toString();
	}
}
