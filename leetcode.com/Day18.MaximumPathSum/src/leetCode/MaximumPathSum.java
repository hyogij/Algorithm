package leetCode;


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
		TreeNode tree = new TreeNode(11);
		tree.left = new TreeNode(-2);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(10);
		tree.left.right = new TreeNode(4);

		printGraph(tree);
		System.out.println("maxPathSum : " + maxPathSum(tree));
	}

	// 1) Recursively solve this problem
	// 2) Get largest left sum and right sum
	// 2) Compare to the stored maximum
	static int maxValue = Integer.MIN_VALUE;
	public static int maxPathSum(TreeNode root) {
		maxPathDown(root);
		return maxValue;
	}
	
	public static int maxPathDown(TreeNode node) {
		if(node == null)
			return 0;
		int left = Math.max(0, maxPathDown(node.left));
		int right = Math.max(0, maxPathDown(node.left));
		maxValue = Math.max(maxValue, left + right + node.val);
		return Math.max(left, right) + node.val;
	}

	public static void printGraph(TreeNode root) {
		if (root != null) {
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
