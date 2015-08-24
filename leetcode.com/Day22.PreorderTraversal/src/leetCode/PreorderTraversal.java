package leetCode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.24
 Question Number : 91
 Link : https://leetcode.com/problems/binary-tree-preorder-traversal/
 ==========================================================
 */

public class PreorderTraversal {
	/*
	 * Given a binary tree, return the preorder traversal of its nodes' values.
	 * 
	 * For example: Given binary tree {1,#,2,3}, 
	 * 1 
	 *  \ 
	 *   2 
	 *   / 
	 * 3 
	 * return [1,2,3].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(3);
		
		System.out.println("inorderTraversal"
				+ preorderTraversal(root).toString());
		System.out.println("inorderTraversal"
				+ preorderTraversalRecursive(root).toString());
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	// Recursive solution to traverse bst by preorder
	public static List<Integer> preorderTraversalRecursive(TreeNode root) {
		List<Integer> preorder = new ArrayList<Integer>();
		preorderTraversalHelper(root, preorder);
		return preorder;
	}

	public static void preorderTraversalHelper(TreeNode root,
			List<Integer> preorder) {
		if (root != null) {
			preorder.add(root.val);
			preorderTraversalHelper(root.left, preorder);
			preorderTraversalHelper(root.right, preorder);
		}
	}

	// Iterative solution to traverse bst by preorder using stack
	public static List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> preorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();

		while (stack.isEmpty() != true || root != null) {
			if (root != null) {
				stack.push(root);
				preorder.add(root.val);
				root = root.left;
			} else {
				root = stack.pop();

				root = root.right;
			}
		}

		return preorder;
	}
}
