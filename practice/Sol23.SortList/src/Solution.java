/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.09
 Problem : https://leetcode.com/problems/sort-list/
 https://leetcode.com/discuss/44369/java-merge-sort-solution
 ==========================================================
 */
public class Solution {
	/*
	 * Sort a linked list in O(n log n) time using constant space complexity.
	 * Subscribe to see which companies asked this question
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(10);
		head.next = new ListNode(5);
		head.next.next = new ListNode(6);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(7);

		printList(head);

		ListNode list = sortList(head);
		printList(list);
	}

	// Implement merge sort on the linked list
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null)
			return head;

		// step 1. cut the list to two halves

		// slow pointer is pointing middle of linked list
		ListNode prev = null, slow = head, fast = head;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}
		// cut the list
		prev.next = null;

		// step 2. sort each half
		ListNode l1 = sortList(head);
		ListNode l2 = sortList(slow);

		// step 3. merge l1 and l2
		return merge(l1, l2);
//		return mergeTwoLists(l1, l2);
	}

	private static ListNode merge(ListNode l1, ListNode l2) {
		ListNode l = new ListNode(0), p = l;

		while (l1 != null && l2 != null) {
			if (l1.val < l2.val) {
				p.next = l1;
				l1 = l1.next;
			} else {
				p.next = l2;
				l2 = l2.next;
			}
			p = p.next;
		}

		if (l1 != null)
			p.next = l1;

		if (l2 != null)
			p.next = l2;

		return l.next;
	}
	
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		// Checks if the given nodes is null
		if (l1 == null && l2 != null) {
			return l2;
		}
		if (l1 != null && l2 == null) {
			return l1;
		}
		if (l1 == null && l2 == null) {
			return null;
		}

        ListNode head = null, node = null, prev = null;
		while (l1 != null && l2 != null) {
			if (l1.val <= l2.val) {
				node = l1;
				l1 = l1.next;
			} else {
				node = l2;
				l2 = l2.next;
			}

			if (head == null) {
				head = node;
				prev = head;
			} else {
				prev.next = node;
				prev = node;
			}
		}

		// Connects the remaining nodes to sorted list
		if (l1 == null) {
			prev.next = l2;
		} else {
			prev.next = l1;
		}

		return head;
    }

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	private static void printList(ListNode head) {
		ListNode node = head;
		while (node != null) {
			System.out.print(node.val + " ");
			node = node.next;
		}
		System.out.println();
	}
}
