package com.leetcode.miscellaneous;

/*
 * category: singly linked list
 */

/***** Algorithm *****
 * 1. check points
 *    a) linked list traversal and list node operations, including delist and enlist
 *    b) in order to delist/enlist node, a pointer to the previous node is needed
 * 
 * 2. Analysis
 *    This is an insertion sort implementation on a linked list.
 *    The assumption is that the list to be inserted is already sorted. We need to
 *    insert the current node into the list so that the list remains sorted.
 *    
 *    1) We need two sets of pointers: one set to traverse the sorted list;
 *       another set is to point at the current node to insert
 *    2) In order to perform delist a node or insert a node in front of another node
 *       we need two pointers at the affected point.
 *       a) for example, if we need to delist C in the following list:
 *          H --> A -> B -> C -> D -> null
 *                     |    |
 *                    pp    p
 *          as shown, we need both pp and p
 *          code:
 *          pp.next = p.next;
 *       
 *       b) to insert a node in front of another node, we also need two pointers;
 *          As in the following list, we need to insert F in front of C:
 *     
 *         H --> A -> B -> C -> D -> E -> F -> G -> null
 *                    |    |              |
 *                   pp    p             cur
 *         code:
 *         cur.next = pp.next;
 *         pp.next = cur;
 *         
 */

public class InsertionSortList {
	
	public static void main(String[] args) {
		InsertionSortList sl = new InsertionSortList();
		
		ListNode head = new ListNode(10);
		ListNode ptr = head;
		ptr.next = new ListNode(8);
		ptr = ptr.next;
		ptr.next = new ListNode(9);
		ptr = ptr.next;
		ptr.next = new ListNode(2);
		ptr = ptr.next;
		ptr.next = new ListNode(3);
		
		sl.printList(head);
		ListNode sorted = sl.insertionSortList(head);
		sl.printList(sorted);
	}
	
	public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
        	return head;
        }
        
		ListNode cur = head.next; // start from the second node to insert
		ListNode pre_cur = head;
		ListNode ptr = head;
		ListNode pre_ptr = null;
		ListNode detached_cur = null;
		
		// definition: insert point is defined as the node in front of which to insert
		while (cur != null) { // starting from the second node in the list, go through the list
			while (cur.val >= ptr.val && ptr != cur ) { // go through the sorted sub list
				pre_ptr = ptr;
				ptr = ptr.next;
			}
			
			if (cur.val < ptr.val) { // found the insert point
				// detach the current node from the list and update pre_cur and cur
				detached_cur = cur;
				pre_cur.next = cur.next;
				cur = pre_cur.next;
				
				if (ptr == head) { // the insert point is the first node in the list
					// insert the detached node at the beginning of the list
					detached_cur.next = head;
					head = detached_cur;
				}
				else { // otherwise
					// insert the detached node before the insert point
					detached_cur.next = pre_ptr.next;
					pre_ptr.next = detached_cur; 
				}
			}
			else { // no need to rearrange the current node
				// update pre_cur and cur
				pre_cur = cur;
				cur = cur.next;
			}
			
			// move the ptr to the 
			ptr = head;
		}
		
		return head;
    }
	
	private void printList(ListNode head) {
		ListNode ptr = head;
		while (ptr != null) {
			System.out.print(ptr.val + " ");
			ptr = ptr.next;
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
}
