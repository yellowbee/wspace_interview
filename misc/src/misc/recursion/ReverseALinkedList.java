package misc.recursion;


/*
 * Reverse a linked list.
 * 
 * Solution: recursion
 */

public class ReverseALinkedList {
	/*public static void main(String[] args) {
		int[] A = {2, 3, 5, 8, 9, 10};
		ListNode head = ListUtilities.arrayToList(A);
		ListNode newHead = ReverseALinkedList.reverse(head);
		ListUtilities.printList(newHead);
	}
	
	// return the new head of the reversed linked list
	public static ListNode reverse(ListNode head) {
		if (head == null) return null;
		if (head.next == null) {
			return head;
		}
		
		// get the next node of head
		ListNode next = head.next;
		// get the reversed linked list with orginal size - 1
		ListNode newHead = reverse(next);
		
		next.next = head;
		head.next = null;
		
		return newHead;
	}*/
}
