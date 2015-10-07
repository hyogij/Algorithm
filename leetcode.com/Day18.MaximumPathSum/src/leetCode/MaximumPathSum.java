package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.18
 Question Number : 71
 Link : https://leetcode.com/problems/binary-tree-maximum-path-sum/
 ==========================================================
 */

public class MaximumPathSum {
	/*
	 * Given a binary tree, find the maximum path sum.
	 * The path may start and end at any node in the tree.
	 * 
	 * For example: Given the below binary tree, 
	 *    1 
	 *   / \ 
	 *  2  3
	 *  Return 6.
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(-13);

		printGraph(tree);
		System.out.println("maxPathSum : " + maxPathSum(tree));
	}

	static int max = Integer.MIN_VALUE;

	public static int maxPathSum(TreeNode root) {
		helper(root);
		return max;
	}

	// Helper returns the max branch plus current node's value
	private static int helper(TreeNode root) {
		if (root == null)
			return 0;

		int left = Math.max(helper(root.left), 0);
		int right = Math.max(helper(root.right), 0);

		max = Math.max(max, root.val + left + right);

		return root.val + Math.max(left, right);
	}
	
	// DFS 를 이용한다
	public static void printGraph(TreeNode root) {
		if(root != null) {
			System.out.println(root.val);
			printGraph(root.left);
			printGraph(root.right);
		}
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
