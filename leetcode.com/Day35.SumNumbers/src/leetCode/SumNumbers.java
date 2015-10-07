package leetCode;

public class SumNumbers {
	/*
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf
	 * path could represent a number.
	 * 
	 * An example is the root-to-leaf path 1->2->3 which represents the number
	 * 123.
	 * 
	 * Find the total sum of all root-to-leaf numbers.
	 * 
	 * For example,
	 * 
	 * 1 / \ 2 3 The root-to-leaf path 1->2 represents the number 12. The
	 * root-to-leaf path 1->3 represents the number 13.
	 * 
	 * Return the sum = 12 + 13 = 25.
	 */

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);

		System.out.println("sumNumbers : " + sumNumbers(tree));
	}

	public static int sumNumbers(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return sumNumbersHelper(root, 0);
	}

	public static int sumNumbersHelper(TreeNode root, int num) {
		if (root == null) {
			return 0;
		}

		// Current number that the path of root to current node
		num *= 10;
		num += root.val;

		if (root.left == null && root.right == null) {
			return num;
		}
		
		return sumNumbersHelper(root.left, num)
				+ sumNumbersHelper(root.right, num);
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
