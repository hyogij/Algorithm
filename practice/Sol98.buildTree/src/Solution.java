import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.04
 Problem : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 ==========================================================
 */
public class Solution {
	/*
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree. 
	 * Inorder sequence: 4, 2, 5, 1, 6, 7, 3, 8
	 * Preorder sequence: 1, 2, 4, 5, 3, 7, 6, 8
	 */
	public static void main(String[] args) {
		int[] preorder = {1, 2, 4, 5, 3, 7, 6, 8};
		int[] inorder = {4, 2, 5, 1, 6, 7, 3, 8};
		TreeNode root = buildTree(preorder, inorder);
		inorder(root);
	}

	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		return buildTreeHelper(preorder, inorder, 0, inorder.length - 1, 0);
	}

	public static TreeNode buildTreeHelper(int[] preorder, int[] inorder,
			int left, int right, int index) {
		if (left < right && index < preorder.length) {
			int value = preorder[index];
			TreeNode node = new TreeNode(value);
			int mid = findIndex(inorder, value, left, right);
			node.left = buildTreeHelper(preorder, inorder, left, mid - 1,
					index + 1);
			node.right = buildTreeHelper(preorder, inorder, mid + 1, right,
					index + mid - left + 1);
			return node;
		}
		return null;
	}

	public static int findIndex(int[] inorder, int target, int left, int right) {
		for (int i = left; i <= right; i++)
			if (target == inorder[i])
				return i;
		return -1;
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
