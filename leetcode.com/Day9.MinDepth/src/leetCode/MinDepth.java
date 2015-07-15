package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.15
 Question Number : 41
 Link : https://leetcode.com/problems/minimum-depth-of-binary-tree/
 ==========================================================
 */
public class MinDepth {
	/*
	 * Given a binary tree, find its minimum depth.
	 * 
	 * The minimum depth is the number of nodes along the shortest path from the
	 * root node down to the nearest leaf node.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(3);
		root.right.left.right = new TreeNode(4);
		System.out.println("minDepth " + minDepthAdvanced(root));
	}

	public static int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return minDepthHelper(root, 0);
	}

	public static int minDepthHelper(TreeNode root, Integer height) {
		// This node is not leaf node
		if (root == null) {
			return -1;
		} else {
			if (root.left == null && root.right == null) {
				return height + 1;
			} else {
				int leftChildDepth = minDepthHelper(root.left, height + 1);
				int rightChildDepth = minDepthHelper(root.right, height + 1);
				if (leftChildDepth < 0 && rightChildDepth > 0) {
					return rightChildDepth;
				} else if (leftChildDepth > 0 && rightChildDepth < 0) {
					return leftChildDepth;
				} else if (leftChildDepth < 0 && rightChildDepth < 0) {
					return 0;
				} else {
					return Math.min(leftChildDepth, rightChildDepth);
				}

			}
		}
	}

	public static int minDepthAdvanced(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			if (root.left == null && root.right == null) {
				return 1;
			} else if (root.left != null && root.right == null) {
				return 1 + minDepthAdvanced(root.left);
			} else if (root.left == null && root.right != null) {
				return 1 + minDepthAdvanced(root.right);
			} else {
				return 1 + Math.min(minDepthAdvanced(root.left),
						minDepthAdvanced(root.right));
			}
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
