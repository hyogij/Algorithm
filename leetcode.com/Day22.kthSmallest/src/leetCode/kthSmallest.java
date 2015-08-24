package leetCode;

import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.24
 Question Number : 89
 Link : https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 ==========================================================
 */

public class kthSmallest {
	/*
	 * Given a binary search tree, write a function kthSmallest to find the kth
	 * smallest element in it.
	 * 
	 * Note: You may assume k is always valid, 1 ¡Â k ¡Â BST's total elements.
	 * 
	 * Follow up: What if the BST is modified (insert/delete operations) often
	 * and you need to find the kth smallest frequently? How would you optimize
	 * the kthSmallest routine?
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		System.out.println("kth " + kthSmallest(root, 1));
		System.out.println("kth " + kthSmallestUsingStack(root, 1));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	// Find the kth smallest node in binary search tree using recursive method
	public static int kthSmallest(TreeNode root, int k) {
		while (root != null) {
			int leftSubTreeNum = getNodeNumber(root.left);
			if (k == leftSubTreeNum + 1) {
				return root.val;
			} else if (k > leftSubTreeNum + 1) {
				root = root.right;
				k -= (leftSubTreeNum + 1);
			} else {
				root = root.left;
			}
		}
		return -1;
	}

	public static int getNodeNumber(TreeNode root) {
		if (root != null) {
			return 1 + getNodeNumber(root.left) + getNodeNumber(root.right);
		}
		return 0;
	}

	// Find the kth smallest node in binary search tree using stack
	public static int kthSmallestUsingStack(TreeNode root, int k) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode current = root;

		while (stack.isEmpty() != true || current != null) {
			if (current != null) {
				stack.push(current);
				current = current.left;
			} else {
				current = stack.pop();
				k--;

				if (k == 0) {
					return current.val;
				}

				current = current.right;
			}
		}

		return -1;
	}
}
