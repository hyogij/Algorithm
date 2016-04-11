package leetCode;

import java.util.Stack;

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
		testEvenListNode();
		testOddListNode();
	}

	public static void testEvenListNode() {
		ListNode l1 = new ListNode(0);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(31);
		ListNode l4 = new ListNode(31);
		ListNode l5 = new ListNode(2);
		ListNode l6 = new ListNode(17);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;

		System.out.println("isPalindrome " + isPalindromeStack(l1));
		System.out.println("isPalindrome " + isPalindrome(l1));
		System.out.println("isPalindrome " + isPalindromeRecursive(l1));
	}

	public static void testOddListNode() {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(1);

		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;

		System.out.println("isPalindrome " + isPalindromeStack(l1));
		System.out.println("isPalindrome " + isPalindrome(l1));
		System.out.println("isPalindrome " + isPalindromeRecursive(l1));
	}

	// Make new number and check the palindrome in nubmer. In this case, there
	// are some problems when list has negative numbers.
	// If we use stringbuffer class, it also has potential errors. If list node
	// value is "100", its reverse string is "001". It returns false.
	public static boolean isPalindromeStack(ListNode head) {
		// We use stack data structure, but it requires space.
		Stack<Integer> stack = new Stack<Integer>();
		ListNode slow = head, fast = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		// Slow points the middle of linked list
		ListNode node = head;
		while (node != slow) {
			stack.push(node.val);
			node = node.next;
		}

		// odd/even linked list
		if (fast != null && fast.next == null) {
			slow = slow.next;
		}

		while (stack.isEmpty() == false) {
			int val = stack.pop();
			if (val != slow.val) {
				return false;
			}
			slow = slow.next;
		}

		return true;
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

	public boolean isPalindromeMySolution(ListNode root) {
		ListNode slow = root, fast = root;
		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode mid = slow, next = mid.next;
		if (fast.next == null) {
			// Odd list
			mid.next = null;
			mid = reverse(root).next;
		} else {
			// Even list
			mid.next = null;
			mid = reverse(root);
		}

		while (next != null && mid != null) {
			if (next.val != mid.val)
				return false;
			next = next.next;
			mid = mid.next;
		}
		return true;
	}

	// first = head, last = head, initially
	static boolean x = true;
	public static boolean isPalindromeUtil(ListNode first, ListNode last) {
		// whenever last will reach at the end of the linkedlist, we will return
		// true.
		if (last == null)
			return true;

		// in each recursive call, we won't modify first, but modify last.
		x = isPalindromeUtil(first, last.next);

		// remember, when an element of stack return false, we will return false
		// to each bottom most element.
		if (!x)
			return false;

		// if x is true, we will check the next entry.
		boolean y = false;
		if (first.val == last.val) {
			y = true;
		}

		// advancing first before returning from the current element of the
		// stack.
		first = first.next;
		return y;
	}

	// A wrapper over isPalindromeUtil()
	public static boolean isPalindromeRecursive(ListNode head) {
		return isPalindromeUtil(head, head);
	}
}
