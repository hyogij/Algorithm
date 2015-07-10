package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.10
 Question Number : 24
 Link : https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 ==========================================================
 */
public class RemoveNthFromEnd {
	/*
	 * Given a linked list, remove the nth node from the end of list and return
	 * its head.
	 * 
	 * For example,
	 * 
	 * Given linked list: 1->2->3->4->5, and n = 2.
	 * 
	 * After removing the second node from the end, the linked list becomes
	 * 1->2->3->5. Note: Given n will always be valid. Try to do this in one
	 * pass.
	 */
	public static void main(String[] args) {
	}

	public ListNode removeNthFromEnd(ListNode head, int n) {
		ListNode prev = null;
		ListNode node = head;
		ListNode nForward = head;

		// Forwards nth in list
		for (int i = 0; i < n; i++) {
			nForward = nForward.next;
		}

		while (nForward != null) {
			prev = node;
			node = node.next;
			nForward = nForward.next;
		}

		// Removes nth node and connects previous node to node's next node
		if (prev == null) {
			head = node.next;
		} else {
			prev.next = node.next;
		}

		return head;
	}

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
