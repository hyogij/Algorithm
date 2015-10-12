package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.12
 Question Number : 140
 Link : https://leetcode.com/problems/partition-list/
 ==========================================================
 */

public class Partition {
	/*
	 * Given a linked list and a value x, partition it such that all nodes less
	 * than x come before nodes greater than or equal to x.
	 * 
	 * You should preserve the original relative order of the nodes in each of
	 * the two partitions.
	 * 
	 * For example, 
	 * 
	 * Given 1->4->3->2->5->2 and x = 3, 
	 * return 1->2->2->4->3->5.
	 */

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(4);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		printNode(l1);
		ListNode head = partition(l1, 2);
		printNode(head);
	}

	public static ListNode partition(ListNode head, int x) {
		// Use two pointers to track less ones and greater ones
		if(head == null) {
			return null;
		}

		ListNode list = head;
		ListNode lessStart = null, lessEnd = null;
		ListNode greaterStart = null, greaterEnd = null;
		while(list != null) {
			if(list.val < x) {
				// If the value is less than target, then append list to less pointer
				if(lessEnd != null) {
					lessEnd.next = list;
				} else {
					lessStart = list;
				}
				lessEnd = list;
			} else {
				// If the value is greater than or equal to target, then append
				// list to less pointer
				if(greaterEnd != null) {
					greaterEnd.next = list;
				} else {
					greaterStart = list;
				}
				greaterEnd = list;
			}
			list = list.next;
		}
		
		// Connect the less pointer and greater pointer
		if(lessStart != null) {
			head = lessStart;
			lessEnd.next = greaterStart;
		} else {
			head = greaterStart;
		}
		if(greaterEnd != null) {
			greaterEnd.next = null;
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
