package com.leetcode.oj.llist;

import java.util.ArrayList;
import java.util.List;

import com.leetcode.oj.common.ListNode;
import com.leetcode.oj.common.ListUtilities;

/*
 * Merge k sorted linked lists and return it as one sorted list.
 * Analyze and describe its complexity.
 * 
 * Solution: create a method to merge two sorted linked lists first;
 * then iterate through the whole list of linked lists joining the result
 * from previous loop and the current linked list.
 */

public class MergeKSortedLists {
	public static void main(String[] args) {
		List<ListNode> lists = new ArrayList<ListNode>();
		lists.add(ListUtilities.arrayToList(new int[]{2,6,7}));
		lists.add(ListUtilities.arrayToList(new int[]{1,4,8}));
		lists.add(ListUtilities.arrayToList(new int[]{3,5,9}));
		MergeKSortedLists msl = new MergeKSortedLists();
		ListNode result = msl.mergeKLists(lists);
		ListUtilities.printList(result);
	}
	
	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists.size() == 0) {
			return null;
		}
		else if (lists.size() == 1) {
			return lists.get(0);
		}
        ListNode result = lists.get(0);
        for (int i=1; i<lists.size(); i++) {
        	result = mergeTwoLists(result, lists.get(i));
        }
        
        return result;
    }
	
	public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
		if (list1 == null) {
			return list2;
		}
		else if (list2 == null) {
			return list1;
		}
		
		ListNode newHead = null;
		ListNode cur_new_pos = null;
		if (list1.val < list2.val) {
			newHead = list1;
			list1 = list1.next;
		}
		else {
			newHead = list2;
			list2 = list2.next;
		}
		
		cur_new_pos = newHead;
		while (list1 != null && list2 != null) {
			if (list1.val < list2.val) {
				cur_new_pos.next = list1;
				list1 = list1.next;
			}
			else {
				cur_new_pos.next = list2;
				list2 = list2.next;
			}
			cur_new_pos = cur_new_pos.next;
		}
		if (list1 == null) {
			cur_new_pos.next = list2;
		}
		else if (list2 == null) {
			cur_new_pos.next = list1;
		}
		
		return newHead;
	}
}
