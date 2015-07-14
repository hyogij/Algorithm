package leetCode;

import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.14
 Question Number : 35
 Link : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 ==========================================================
 */
public class DeleteDuplicates {
	/*
	 * Given a sorted linked list, delete all duplicates such that each element
	 * appear only once.
	 * 
	 * For example, Given 1->1->2, return 1->2. Given 1->1->2->3->3, return
	 * 1->2->3.
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(1);
		head.next.next = new ListNode(1);
		head.next.next.next = new ListNode(2);
		head.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next = new ListNode(3);
		head.next.next.next.next.next.next = new ListNode(2);

		ListNode node = deleteDuplicates(head);
		while (node != null) {
			System.out.println(node.val);
			node = node.next;
		}
	}

	public static ListNode deleteDuplicates(ListNode head) {
		if (head == null) {
			return head;
		}

		HashSet<Integer> set = new HashSet<Integer>();
		ListNode prev = null, current = head;
		while (current != null) {
			if (set.contains(current.val) == false) {
				set.add(current.val);
				prev = current;
			} else {
				// If current node is duplicated, then removes this node
				prev.next = current.next;
			}

			current = current.next;
		}

		return head;
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
