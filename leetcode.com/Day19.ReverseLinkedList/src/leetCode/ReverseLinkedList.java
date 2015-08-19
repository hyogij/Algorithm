package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.19
 Question Number : 75
 Link : https://leetcode.com/problems/reverse-linked-list/
 ==========================================================
 */

public class ReverseLinkedList {
	/*
	 * Reverse a singly linked list.
	 * 
	 * Hint: A linked list can be reversed either iteratively or recursively.
	 * Could you implement both?
	 */
	static ListNode recursiveHead = null;
	
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		ListNode head = reverseList(l1);
		printNode(head);
		
//		recursiveReverse(head);
//		printNode(recursiveHead);
		
		reverseListRecursive(head);
		printNode(recursiveHead);
	}

	// Reverse a single linked list through iterative method
	public static ListNode reverseList(ListNode head) {
		ListNode prev = null, current = head, next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
	}
	
	// Reverse a single linked list through recursive method
	public static void reverseListRecursive(ListNode head) {
		if(head == null) {
			return;
		}
		
		if(head.next == null) {
			recursiveHead = head;
			return;
		}
		
		reverseListRecursive(head.next);
		head.next.next = head;
		head.next = null; // set "old" next pointer to NULL
	}
	
	public static void recursiveReverse(ListNode currentNode) {
		// check for empty list
		if (currentNode == null)
			return;

		// if we are at the TAIL node: recursive base case:
		if (currentNode.next == null) {
			// set HEAD to current TAIL since we are reversing list
			// since this is the base case
			recursiveHead = currentNode;
			return; 
		}

		recursiveReverse(currentNode.next);
		currentNode.next.next = currentNode;
		currentNode.next = null; // set "old" next pointer to NULL
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
