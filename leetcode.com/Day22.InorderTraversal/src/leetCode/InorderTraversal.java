package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.24
 Question Number : 90
 Link : https://leetcode.com/problems/binary-tree-inorder-traversal/
 ==========================================================
 */

public class InorderTraversal {
	/*
	 * Given a binary tree, return the inorder traversal of its nodes' values.
	 * For example: Given binary tree {1,#,2,3}, 1 \ 2 / 3 return [1,3,2].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		System.out.println("inorderTraversal"
				+ inorderTraversal(root).toString());
		System.out.println("inorderTraversal"
				+ inorderTraversalRecursive(root).toString());
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	// Recursive solution to traverse bst by inorder
	public static List<Integer> inorderTraversalRecursive(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();
		inorderTraversalHelper(root, inorder);
		return inorder;
	}

	public static void inorderTraversalHelper(TreeNode root,
			List<Integer> inorder) {
		if (root != null) {
			inorderTraversalHelper(root.left, inorder);
			inorder.add(root.val);
			inorderTraversalHelper(root.right, inorder);
		}
	}

	// Iterative solution to traverse bst by inorder using stack
	public static List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> inorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (stack.isEmpty() != true || root != null) {
			if (root != null) {
				stack.push(root);
				root = root.left;
			} else {
				root = stack.pop();
				inorder.add(root.val);
				root = root.right;
			}
		}

		return inorder;
	}
}
