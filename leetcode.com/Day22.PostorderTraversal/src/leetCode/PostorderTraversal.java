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

public class PostorderTraversal {
	/*
	 * Given a binary tree, return the postorder traversal of its nodes' values.
	 * 
	 * For example: Given binary tree {1,#,2,3}, 
	 * 1 
	 *  \ 
	 *   2 
	 *   / 
	 * 3 
	 * return [3,2,1].
	 * 
	 * Note: Recursive solution is trivial, could you do it iteratively?
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(4);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(11);
		
		System.out.println("inorderTraversal"
				+ postorderTraversal(root).toString());
		System.out.println("inorderTraversal"
				+ postorderTraversalRecursive(root).toString());
	}

	public static class TreeNode {
		int val;
		boolean isVisited = false;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	// Recursive solution to traverse bst by postorder
	public static List<Integer> postorderTraversalRecursive(TreeNode root) {
		List<Integer> postorder = new ArrayList<Integer>();
		postorderTraversalHelper(root, postorder);
		return postorder;
	}

	public static void postorderTraversalHelper(TreeNode root,
			List<Integer> preorder) {
		if (root != null) {
			postorderTraversalHelper(root.left, preorder);
			postorderTraversalHelper(root.right, preorder);
			preorder.add(root.val);
		}
	}

	// Iterative solution to traverse bst by postorder using stack
	public static List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> postorder = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		
		TreeNode prev = null;

		stack.push(root);
		while (stack.isEmpty() != true || root != null) {
			if (root != null) {
				if (root.right != null && root.right.isVisited == false) {
					stack.push(root.right);
				}
				if (root.left != null && root.left.isVisited == false) {
					stack.push(root.left);
				}
				if (root.left == null && root.right == null) {
					stack.pop();
					postorder.add(root.val);
				}
				root = null;
			} else {
				root = stack.peek();
				if (root.isVisited == false) {
					root.isVisited = true;
				} else {
					stack.pop();
					postorder.add(root.val);
				}
			}
		}

		return postorder;
	}
}
