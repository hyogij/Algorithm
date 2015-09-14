package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.14
 Question Number : 115
 Link : https://leetcode.com/problems/reverse-linked-list-ii/
 ==========================================================
 */

public class ReverseBetween {
	/*
	 * Reverse a linked list from position m to n. Do it in-place and in
	 * one-pass.
	 * 
	 * For example: Given 1->2->3->4->5->NULL, m = 2 and n = 4,
	 * 
	 * return 1->4->3->2->5->NULL.
	 * 
	 * Note: Given m, n satisfy the following condition: 1 ¡Â m ¡Â n ¡Â length of
	 * list.
	 */
	static ListNode recursiveHead = null;

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		ListNode head = reverseBetween(l1, 2, 4);
		printNode(head);
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode start = head, prev = start;
		// Move the pointer to the mth position to reverse a linked list
		for (int position = 1; position < m; position++) {
			prev = start;
			start = start.next;
		}

		// Reverse a linked list from m to n
		ListNode subHead = reverseList(start, n - m);

		// Reconnect the reversed list to original list
		if (m == 1) {
			head = subHead;
		} else {
			prev.next = subHead;
		}
		return head;
	}

	// Reverse a single linked list through iterative method
	public static ListNode reverseList(ListNode head, int n) {
		ListNode prev = null, current = head, next;
		while (n >= 0) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
			n--;
		}
		head.next = current;
		return prev;
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
