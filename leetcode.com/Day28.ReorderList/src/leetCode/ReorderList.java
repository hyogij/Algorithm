package leetCode;

import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.14
 Question Number : 118
 Link : https://leetcode.com/problems/reorder-list/
 ==========================================================
 */

public class ReorderList {
	/**
	 * Given a singly linked list L: L0°ÊL1°Ê°¶°ÊLn-1°ÊLn, reorder it to:
	 * L0°ÊLn°ÊL1°ÊLn-1°ÊL2°ÊLn-2°Ê°¶
	 * 
	 * You must do this in-place without altering the nodes' values. For
	 * example, Given {1,2,3,4}, reorder it to {1,4,2,3}.
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		reorderList(l1);
		printNode(l1);
	}

	public static void reorderList(ListNode head) {
		if (head == null) {
			return;
		}

		ListNode slow = head, fast = head, last = null;
		// Find the middle node of linked list
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		last = slow.next;

		// Add the nodes that are behind half node in linked list to stack
		Stack<ListNode> stack = new Stack<ListNode>();
		while (slow != null) {
			stack.push(slow);
			slow = slow.next;
		}

		ListNode current = head, prev = null;
		// Connect the linked list from original linked list and stack
		while (current != last) {
			if (prev != null) {
				prev.next = current;
			}

			ListNode tmp = null;
			if (stack.isEmpty() == false) {
				tmp = stack.pop();
			}

			ListNode next = current.next;
			current.next = tmp;
			prev = tmp;
			current = next;
		}

		if (prev != null) {
			prev.next = null;
		}
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
