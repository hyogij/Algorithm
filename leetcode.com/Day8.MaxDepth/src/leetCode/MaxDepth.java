package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.14
 Question Number : 35
 Link : https://leetcode.com/problems/maximum-depth-of-binary-tree/
 ==========================================================
 */
public class MaxDepth {
	/*
	 * Given a binary tree, find its maximum depth.
	 * 
	 * The maximum depth is the number of nodes along the longest path from the
	 * root node down to the farthest leaf node.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("maxDepth " + maxDepth(root));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public static int maxDepth(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
		}
	}
}
