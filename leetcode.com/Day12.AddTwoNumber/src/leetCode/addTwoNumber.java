package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.04
 Question Number : 51
 Link : https://leetcode.com/problems/add-two-numbers/
 ==========================================================
 */

public class addTwoNumber {

	/*
	 * You are given two linked lists representing two non-negative numbers. The
	 * digits are stored in reverse order and each of their nodes contain a
	 * single digit. Add the two numbers and return it as a linked list.
	 * 
	 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8
	 */

	public static void main(String[] args) {
		ListNode l10 = new ListNode(2);
		ListNode l11 = new ListNode(4);
		ListNode l12 = new ListNode(3);

		l10.next = l11;
		l11.next = l12;
		l12.next = null;

		ListNode l20 = new ListNode(5);
		ListNode l21 = new ListNode(6);
		ListNode l22 = new ListNode(4);

		l20.next = l21;
		l21.next = l22;
		l22.next = null;

		ListNode result = addTwoNumbers(l10, l20);
		printListNode(result);
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode head = null, current = null;
		
		int sum = 0;
		int carry = 0;

		while (true) {
			if (l1 == null && l2 == null) {
				break;
			}

			sum += carry;
			
			if (l1 != null) {
				sum += l1.val;
				l1 = l1.next;
			}

			if (l2 != null) {
				sum += l2.val;
				l2 = l2.next;
			}

			// Creates new node
			ListNode newNode = new ListNode(sum % 10);
			newNode.next = null;
			if(head == null) {
				head = newNode;
			} else {
				current.next = newNode;
			}
			current = newNode;
			carry = sum / 10;
			sum = 0;
		}

		// Adds a carry to result node
		if(carry > 0) {
			ListNode newNode = new ListNode(carry);
			newNode.next = null;
			if (head == null) {
				head = newNode;
			} else {
				current.next = newNode;
			}
		}

		return head;
	}

	public static void printListNode(ListNode list) {
		while (list != null) {
			System.out.print(list.val + " -> ");
			list = list.next;
		}
		System.out.println("null");
	}

	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
}
