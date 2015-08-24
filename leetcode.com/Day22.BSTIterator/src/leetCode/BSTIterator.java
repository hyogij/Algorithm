package leetCode;

import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.24
 Question Number : 88
 Link : https://leetcode.com/problems/binary-search-tree-iterator/
 ==========================================================
 */

public class BSTIterator {
	/*
	 * Implement an iterator over a binary search tree (BST). Your iterator will
	 * be initialized with the root node of a BST.
	 * 
	 * Calling next() will return the next smallest number in the BST.
	 * 
	 * Note: next() and hasNext() should run in average O(1) time and uses O(h)
	 * memory, where h is the height of the tree.
	 */
	public static void main(String[] args) {
	}

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	ArrayList<Integer> bst = null;
	int position = 0;

	public BSTIterator(TreeNode root) {
		bst = new ArrayList<Integer>();
		inorder(root);
	}

	// Traverse the binary search tree, then elements would be stored in array
	// in order.
	public void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			bst.add(root.val);
			inorder(root.right);
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
		if (position < bst.size()) {
			return true;
		} else {
			return false;
		}
	}

	/** @return the next smallest number */
	public int next() {
		return bst.get(position++);
	}
}
