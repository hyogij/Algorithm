package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.06
 Question Number : 60
 Link : https://leetcode.com/problems/palindrome-linked-list/
 ==========================================================
 */

public class palindromLinkedList {
	/*
	 * Given a singly linked list, determine if it is a palindrome.
	 * 
	 * Follow up: Could you do it in O(n) time and O(1) space?
	 */
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(2);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		System.out.println("isPalindrome " + isPalindrome(l1));
	}

	public static boolean isPalindrome(ListNode head) {
		ListNode slow, fast;

		slow = fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Adjusts if number of nodes in linked list is odd
		if (fast != null) {
			slow = slow.next;
		}

		// Reverses linked list
		ListNode secondHead = reverse(slow);

		// Checks linked list whether palindrome or not
		while (head != null && secondHead != null) {
			if (head.val != secondHead.val) {
				return false;
			}
			head = head.next;
			secondHead = secondHead.next;
		}

		return true;
	}

	public static ListNode reverse(ListNode head) {
		ListNode prev = null, current = head, next;
		while (current != null) {
			next = current.next;
			current.next = prev;
			prev = current;
			current = next;
		}
		return prev;
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
