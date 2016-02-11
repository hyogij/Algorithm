package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.11
 Question Number : 160
 Link : https://leetcode.com/problems/odd-even-linked-list/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a singly linked list, group all odd nodes together followed by the
	 * even nodes. Please note here we are talking about the node number and not
	 * the value in the nodes.
	 * 
	 * You should try to do it in place. The program should run in O(1) space
	 * complexity and O(nodes) time complexity.
	 * 
	 * Example: Given 1->2->3->4->5->NULL, return 1->3->5->2->4->NULL.
	 * 
	 * Note: The relative order inside both the even and odd groups should
	 * remain as it was in the input. The first node is considered odd, the
	 * second node even and so on ...
	 */
	public static void main(String[] args) {
		ListNode node = new ListNode(1);
		node.next = new ListNode(2);
		node.next.next = new ListNode(3);
		node.next.next.next = new ListNode(4);
		node.next.next.next.next = new ListNode(5);

		System.out.println("\nprintListNode ");
		printListNode(node);
		node = oddEvenList(node);
		System.out.println("\nprintListNode ");
		printListNode(node);
	}
	/*
	 * Input: [2,1,4,3,6,5,7,8] Output: [2,4,6,8,1,3,5,7] Expected:
	 * [2,4,6,7,1,3,5,8]
	 */

	public static ListNode oddEvenList(ListNode head) {
		ListNode odd = null, even = null;
		ListNode oddHead = null, evenHead = null;
		ListNode node = head;

		if (head == null) {
			return null;
		}

		int count = 1;
		while (node != null) {
			if (count % 2 == 0) {
				if (even != null) {
					even.next = node;
				} else {
					// Set head even node of linked list
					evenHead = node;
				}
				even = node;
			} else {
				if (odd != null) {
					odd.next = node;
				} else {
					// Set head odd node of linked list
					oddHead = node;
				}
				odd = node;
			}
			node = node.next;
			count++;
		}

		// Set the null point to the last node of linked list
		if (odd != null) {
			// Connect the even linked list into the odd linked list
			odd.next = evenHead;
		}
		if (even != null) {
			even.next = null;
		}

		return oddHead;
	}

	// Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}

	private static void printListNode(ListNode head) {
		while (head != null) {
			System.out.print(" " + head.val);
			head = head.next;
		}
	}
}
