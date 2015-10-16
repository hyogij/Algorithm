package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.16
 Question Number : 149
 Link : http://buttercola.blogspot.kr/2015/09/leetcode-closest-binary-search-tree_8.html
 ==========================================================
 */

public class ClosestValue2 {
	/*
	 * Given a non-empty binary search tree and a target value, find k values in
	 * the BST that are closest to the target. 
	 * 
	 * Note: 
	 * Given target value is a floating point. 
	 * You may assume k is always valid, that is: k ¡Â total nodes. 
	 * You are guaranteed to have only one unique set of k values in the BST 
	 * that are closest to the target. 
	 * 
	 * Follow up: 
	 * Assume that the BST is balanced, could you solve it in less than O(n) runtime 
	 * (where n = total nodes)? 
	 * 
	 * Hint: 
	 * Consider implement these two helper functions: 
	 * getPredecessor(N), which returns the next smaller node to N.
	 * getSuccessor(N), which returns the next larger node to N. 
	 * 
	 * Try to assume that each node has a parent pointer, it makes the problem 
	 * much easier.
	 * Without parent pointer we just need to keep track of the path from the
	 * root to the current node using a stack. 
	 * You would need two stacks to track the path in finding predecessor and 
	 * successor node separately.
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(20);
		tree.left = new TreeNode(16);
		tree.left.left = new TreeNode(16);
		tree.right = new TreeNode(20);
		tree.right.right = new TreeNode(22);
		tree.right.left = new TreeNode(18);
		tree.right.left.left = new TreeNode(16);

		System.out.println("closestValue : "
				+ closestKValues(tree, 17.1, 2).toString());
	}

	public static List<Integer> closestKValues(TreeNode root, double target,
			int k) {
		List<Integer> list = new ArrayList<Integer>();

		return list;
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
