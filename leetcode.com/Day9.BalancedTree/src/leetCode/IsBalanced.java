package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.15
 Question Number : 40
 Link : https://leetcode.com/problems/balanced-binary-tree/ 
 ==========================================================
 */
public class IsBalanced {
	/*
	 * Given a binary tree, determine if it is height-balanced.
	 * 
	 * For this problem, a height-balanced binary tree is defined as a binary
	 * tree in which the depth of the two subtrees of every node never differ by
	 * more than 1.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(4);
		// root.right.left = new TreeNode(4);
		// root.right.right = new TreeNode(3);
		System.out.println("isBalanced " + isBalanced(root));
	}

	// Belows method's time complexity is O(n^2). We have to optimize this
	// method from O(n^2) to O(n).
	// http://www.geeksforgeeks.org/how-to-determine-if-a-binary-tree-is-balanced/
	public static boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1) {
			return isBalanced(root.left) && isBalanced(root.right);
		} else {
			return false;
		}
	}

	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		} else {
			return 1 + Math.max(getHeight(root.right), getHeight(root.left));
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
