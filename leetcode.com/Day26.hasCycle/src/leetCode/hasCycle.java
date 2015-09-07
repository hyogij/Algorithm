package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.07
 Question Number : 110
 Link : https://leetcode.com/problems/linked-list-cycle/
 ==========================================================
 */

public class hasCycle {
	/*
	 * Given a linked list, determine if it has a cycle in it.
	 * 
	 * Follow up: Can you solve it without using extra space?
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(5);
		ListNode l2 = new ListNode(8);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(12);

//		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;

		System.out.println("hasCycle " + hasCycle(l1));
	}

	public static boolean hasCycle(ListNode head) {
		if (head == null) {
			return false;
		}

		ListNode slow = head, fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			
			if (slow == fast) {
				return true;
			}
		}
		return false;
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
