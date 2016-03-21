/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.21
 Problem : http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 ==========================================================
 */
public class Solution {
	/*
	 * Given two numbers represented by two linked lists, write a function that
	 * returns sum list. The sum list is linked list representation of addition
	 * of two input numbers. It is not allowed to modify the lists. Also, not
	 * allowed to use explicit extra space (Hint: Use Recursion).
	 * 
	 * Example
	 * 
	 * Input: 
	 * First List: 5->6->3 // represents number 563 
	 * Second List: 8->4->2 // represents number 842 
	 * Output 
	 * Resultant list: 1->4->0->5 // represents number 1405
	 */
	public static void main(String[] args) {
		ListNode num1 = new ListNode(5);
		num1.next = new ListNode(6);
		num1.next.next = new ListNode(3);

		ListNode num2 = new ListNode(8);
		num2.next = new ListNode(4);
		num2.next.next = new ListNode(2);

		ListNode sum = addTwoList(num1, num2);
		printNode(sum);
	}

	public static ListNode addTwoList(ListNode a, ListNode b) {
		int[] carry = {0};
		ListNode sum = helper(a, b, carry);
		if (carry[0] != 0) {
			ListNode node = new ListNode(carry[0]);
			node.next = sum;
			return node;
		}
		return sum;
	}

	public static ListNode helper(ListNode a, ListNode b, int[] carry) {
		if (a == null && b == null)
			return null;

		System.out.println(a.val + " + " + b.val + " : " + carry[0]);

		ListNode node = new ListNode(0);
		node.next = helper(a.next, b.next, carry);
		node.val = (a.val + b.val + carry[0]) % 10;
		carry[0] = (a.val + b.val + carry[0]) / 10;
		return node;
	}

	static class ListNode {
		int val;
		ListNode next = null;
		public ListNode(int val) {
			this.val = val;
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
}