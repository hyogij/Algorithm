package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.16
 Question Number : 148
 Link : http://buttercola.blogspot.kr/2015/09/leetcode-closest-binary-search-tree.html
 ==========================================================
 */

public class ClosestValue {
	/*
	 * Given a non-empty binary search tree and a target value, find the value
	 * in the BST that is closest to the target.
	 * 
	 * Note: Given target value is a floating point. You are guaranteed to have
	 * only one unique value in the BST that is closest to the target.
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(7);
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(20);
		tree.right.right = new TreeNode(22);
		tree.right.left = new TreeNode(18);
		tree.right.left.left = new TreeNode(16);

		System.out.println("closestValue : " + closestValue(tree, 17.5));
	}

	public static int closestValue(TreeNode root, double target) {
		if (root == null) {
			return -1;
		}

		int value = closetValueHelper(root, root, target);
		return value;
	}

	public static int closetValueHelper(TreeNode parent, TreeNode root,
			double target) {
		if (root == null) {
			return -1;
		}

		// Compare with parent value when current node hasn't children
		if (root.left == null && root.right == null) {
			if (Math.abs(parent.val - target) > Math.abs(root.val - target)) {
				return root.val;
			}
			return parent.val;
		}

		if (root.val < target) {
			return closetValueHelper(root, root.right, target);
		} else if (root.val > target) {
			return closetValueHelper(root, root.left, target);
		} else {
			return root.val;
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
