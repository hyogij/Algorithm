package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.07
 Question Number : 111
 Link : https://leetcode.com/problems/linked-list-cycle-ii/
 ==========================================================
 */

public class hasCycle2 {
	/*
	 * Given a linked list, return the node where the cycle begins. If there is
	 * no cycle, return null.
	 * 
	 * Note: Do not modify the linked list.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(8);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(12);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l3;

		System.out.println("detectCycle " + detectCycle(l1).val);
	}

	public static ListNode detectCycle(ListNode head) {
		if (head == null) {
			return null;
		}

		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			// Linked list has cycle
			if (slow == fast) {
				slow = head;
				while (slow != fast) {
					slow = slow.next;
					fast = fast.next;
				}
				return slow;
			}
		}
		return null;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
}
