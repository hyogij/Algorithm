package leetCode;

import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.14
 Question Number : 117
 Link : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 ==========================================================
 */

public class DeleteDuplicates {
	/**
	 * Given a sorted linked list, delete all nodes that have duplicate numbers,
	 * leaving only distinct numbers from the original list.
	 * 
	 * For example, 
	 * Given 1->2->3->3->4->4->5, return 1->2->5. 
	 * Given 1->1->1->2->3, return 2->3.
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
//		ListNode l3 = new ListNode(3);
//		ListNode l4 = new ListNode(4);
//		ListNode l5 = new ListNode(4);
//		ListNode l6 = new ListNode(5);

		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;

		ListNode head = deleteDuplicates(l1);
		printNode(head);
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if(head == null) {
			return head;
		}
		
		HashSet<Integer> hashSet = new HashSet<Integer>();
		// ListNode pointers for new ListNode
		ListNode newHead = null, newCurrent = null, firstNode = null;
		ListNode current = head;
		while(current != null) {
			// Connect unique firstNode to new ListNode
			if(firstNode != null && firstNode.val != current.val) {
				if(newHead == null) {
					newHead = firstNode;
				} else {
					newCurrent.next = firstNode;
				}
				newCurrent = firstNode;
			}
			
			if(hashSet.add(current.val) == true) {
				firstNode = current;
			} else {
				firstNode = null;
			}
			current = current.next;
		}
		
		// Handle remain firstNode
		if(firstNode != null) {
			if(newHead == null) {
				newHead = firstNode;
			} else {
				newCurrent.next = firstNode;
			}
			newCurrent = firstNode;
		}
		if(newCurrent != null) {
			newCurrent.next = null;
		}
		
		return newHead;
	}
	
	public static void printNode(ListNode head) {
		System.out.print("printNode : ");
		while (head != null) {
			System.out.print(head.val);
			head = head.next;
		}
		System.out.println();
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
