/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.03
 Question Number : 95
 Link : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 ==========================================================
 */

public class Solution {
	/*
	 * Given a singly linked list where elements are sorted in ascending order,
	 * convert it to a height balanced BST.
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		head.next.next.next.next = new ListNode(5);
		head.next.next.next.next.next = new ListNode(6);
		head.next.next.next.next.next.next = new ListNode(7);

		TreeNode root = sortedListToBST(head);
		inorder(root);
	}

	static ListNode current = null;
	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		current = head;
		int size = getSize(head);

		TreeNode root = helper(0, size - 1);
		return root;
	}

	public static TreeNode helper(int left, int right) {
		if (left > right)
			return null;

		int mid = (right - left) / 2 + left;
		TreeNode leftTreeNode = helper(left, mid - 1);

		TreeNode root = new TreeNode(current.val);
		current = current.next;

		TreeNode rightTreeNode = helper(mid + 1, right);

		root.left = leftTreeNode;
		root.right = rightTreeNode;
		return root;
	}

	public static int getSize(ListNode head) {
		ListNode current = head;
		int count = 0;
		while (current != null) {
			current = current.next;
			count++;
		}
		return count;
	}

	public static class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// Traverse the binary search tree, then elements would be stored in array
	// in order.
	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print("-" + root.val);
			inorder(root.right);
		}
	}
}