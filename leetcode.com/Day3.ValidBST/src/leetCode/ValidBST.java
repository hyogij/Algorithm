package leetCode;

import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.07
 Question Number : 10
 Link : https://leetcode.com/problems/validate-binary-search-tree/
 ==========================================================
 */
public class ValidBST {
	/*
	 * Given a binary tree, determine if it is a valid binary search tree (BST).
	 * 
	 * Assume a BST is defined as follows:
	 * 
	 * The left subtree of a node contains only nodes with keys less than the
	 * node's key. The right subtree of a node contains only nodes with keys
	 * greater than the node's key. Both the left and right subtrees must also
	 * be binary search trees.
	 */
	private ArrayList<Integer> array = new ArrayList<Integer>();

	public static void main(String[] args) {
	}

	public boolean isValidBST(TreeNode root) {
		// return isValidBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
		return isValidBSTHelper(root, null, null);
	}

	// Recursive method
	// If we use min, max values in integer then there is a corner case. So we
	// have to pass null object to solve this corner case.
	public boolean isValidBSTHelper(TreeNode root, Integer min, Integer max) {
		if (root != null) {
			if ((min != null && root.val <= min)
					|| (max != null && root.val >= max)) {
				return false;
			}
			return isValidBSTHelper(root.left, min, root.val)
					&& isValidBSTHelper(root.right, root.val, max);
		}
		return true;
	}

	// Below solution is not efficient becuase it needs an additional storage
	// such as arraylist to store elements in BST.
	public boolean inorder(TreeNode root) {
		boolean result = true;
		if (root != null) {
			result = inorder(root.left);
			if (result == false) {
				return false;
			}

			array.add(root.val);
			if (array.size() > 1
					&& array.get(array.size() - 2) >= array
							.get(array.size() - 1)) {
				return false;
			}
			result = inorder(root.right);
		}

		if (result == false) {
			return false;
		}
		return true;
	}

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
