/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.05
 Problem : http://www.geeksforgeeks.org/construct-bst-from-given-preorder-traversa/
 ==========================================================
 */
public class Solution {
	/*
	 * Given preorder traversal of a binary search tree, construct the BST.
	 * 
	 * For example, if the given traversal is {10, 5, 1, 7, 40, 50}, then the
	 * output should be root of following tree.
	 */
	public static void main(String[] args) {
		int[] preorder = {10, 5, 1, 7, 40, 50};
		TreeNode root = buildBST(preorder);
		inorder(root);
	}

	public static TreeNode buildBST(int[] preorder) {
		return buildBSTHelper(preorder, 0, preorder.length - 1, 0);
	}

	public static TreeNode buildBSTHelper(int[] preorder, int left, int right,
			int index) {
		if (left > right || index >= preorder.length)
			return null;

		int value = preorder[index];
		TreeNode node = new TreeNode(value);

		if (left == right)
			return node;

		int mid = left;
		for (; mid <= right; mid++) {
			if (value < preorder[mid])
				break;
		}

		node.left = buildBSTHelper(preorder, left + 1, mid - 1, index + 1);
		node.right = buildBSTHelper(preorder, mid, right, index + (mid - left));
		return node;
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}

	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
