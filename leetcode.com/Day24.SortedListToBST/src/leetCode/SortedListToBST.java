package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.03
 Question Number : 95
 Link : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
 ==========================================================
 */

public class SortedListToBST {
	/*
	 * Given a singly linked list where elements are sorted in ascending order,
	 * convert it to a height balanced BST.
	 */
	public static void main(String[] args) {
		ListNode head = new ListNode(1);
		head.next = new ListNode(2);
		head.next.next = new ListNode(3);
		head.next.next.next = new ListNode(4);
		// head.next.next.next.next = new ListNode(5);
		// head.next.next.next.next.next = new ListNode(6);
		// head.next.next.next.next.next.next = new ListNode(7);

		TreeNode root = sortedListToBST(head);
		inorder(root);
	}

	public static int getListSize(ListNode head) {
		int count = 0;
		while (head != null) {
			head = head.next;
			count++;
		}

		return count;
	}

	static ListNode h;

	public static TreeNode sortedListToBST(ListNode head) {
		if (head == null)
			return null;

		h = head;
		int len = getListSize(head);
		return sortedListToBST(0, len - 1);
	}

	// get list length
	public int getLength(ListNode head) {
		int len = 0;
		ListNode p = head;

		while (p != null) {
			len++;
			p = p.next;
		}
		return len;
	}

	// build tree bottom-up
	public static TreeNode sortedListToBST(int start, int end) {
		if (start > end)
			return null;

		// mid
		int mid = (start + end) / 2;

		TreeNode left = sortedListToBST(start, mid - 1);
		TreeNode root = new TreeNode(h.val);
		h = h.next;
		TreeNode right = sortedListToBST(mid + 1, end);

		root.left = left;
		root.right = right;

		return root;
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
