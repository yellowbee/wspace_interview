package com.leetcode.oj.llist;

/*
 * category: sinlgy linked list; sorting
 */
// Merge sort on singly linked list is in-place
public class SortList {
	
	public static void main(String[] args) {
		SortList sl = new SortList();
		ListNode to_be_sorted = new ListNode(8);
		ListNode cursor = to_be_sorted;
		cursor.next = new ListNode(5);
		cursor = cursor.next;
		cursor.next = new ListNode(15);
		cursor = cursor.next;
		cursor.next = new ListNode(9);
		cursor = cursor.next;
		cursor.next = new ListNode(2);
		cursor = cursor.next;
		cursor.next = new ListNode(1);
		cursor = cursor.next;
		
		sl.printList(to_be_sorted);
		/*ListNode rightHalf = sl.devide(to_be_sorted);
		sl.printList(to_be_sorted);
		sl.printList(rightHalf);*/
		ListNode sorted = sl.sortList(to_be_sorted);
		sl.printList(sorted);
	}
	
	public void printList(ListNode node) {
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
	
	private static class ListNode {
		int val;
		ListNode next;
		
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	
	public ListNode sortList(ListNode head) {
        if (head == null) {
        	return null;
        }
        else if (head.next == null) {
        	return head;
        }
        
        ListNode rightHalf = devide(head);
        return merge(sortList(head), sortList(rightHalf));
    }
	
	// devide the list into two halves
	public ListNode devide(ListNode node) {
		if (node == null) {
			return null;
		}
		else if (node.next == null) {
			return node;
		}
		
		ListNode slow = node;
		ListNode fast = node.next;
		
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next;
			if (fast.next != null) {
				fast = fast.next;
			}
			else {
				break;
			}
		}
		
		ListNode rightHalf = slow.next;
		slow.next = null;
		return rightHalf;
	}
	
	// merge two sorted linked lists into one single sorted linked list
	public ListNode merge(ListNode node1, ListNode node2) {
		ListNode merged = null;
		ListNode cursor = null;
		
		// Let the merged list head point to the smaller node
		// at the beginning of either lists to be merged.
		if (node1.val <= node2.val) {
			merged = node1;
			cursor = merged;
			node1 = node1.next;
		}
		else {
			merged = node2;
			cursor = merged;
			node2 = node2.next;
		}
		
		// Iterate until one of the lists is exhausted.
		while (node1 != null && node2 != null) {
			if (node1.val <= node2.val) {
				cursor.next = node1;
				node1 = node1.next;
			}
			else {
				cursor.next = node2;
				node2 = node2.next;
			}
			cursor = cursor.next;
		}
		
		// Concatenate the list that's not yet exhausted.
		if (node1 != null) {
			cursor.next = node1;
		}
		else {
			cursor.next = node2;
		}
		
		return merged;
	}
}
