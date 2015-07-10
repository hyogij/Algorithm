package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.10
 Question Number : 26
 Link : https://leetcode.com/problems/merge-two-sorted-lists/
 ==========================================================
 */
public class MergeTwoLists {
	/*
	 * Merge two sorted linked lists and return it as a new list. The new list
	 * should be made by splicing together the nodes of the first two lists.
	 */
	public static void main(String[] args) {
		// [5], [1,2,4]
	}

	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode node = null, prev = null;

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

	public class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
