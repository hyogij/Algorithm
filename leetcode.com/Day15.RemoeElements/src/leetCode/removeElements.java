package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.07
 Question Number : 62
 Link : https://leetcode.com/problems/rotate-array/
 ==========================================================
 */

public class removeElements {
	/*
	 * Remove all elements from a linked list of integers that have value val.
	 * 
	 * Example Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6 
	 * Return: 1 --> 2 --> 3 --> 4 --> 5
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(1);
		// ListNode l5 = new ListNode(4);
		// ListNode l6 = new ListNode(5);
		// ListNode l7 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		// l4.next = l5;
		// l5.next = l6;
		// l6.next = l7;

		printNode(l1);
		removeElements(l1, 2);
		printNode(l1);
	}

	public static ListNode removeElements(ListNode head, int val) {
		ListNode list = head, prev = null;

		if (list == null) {
			return null;
		}

		while (list != null) {
			if (list.val == val) {
				if (list == head) {
					head = list.next;
				} else {
					prev.next = list.next;
				}
			} else {
				prev = list;
			}

			list = list.next;
		}

		return head;
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
