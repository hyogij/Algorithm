package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.07
 Question Number : 11
 Link : https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
 ==========================================================
 */
public class ConvertArrayToBST {

	/*
	 * Given an array where elements are sorted in ascending order, convert it
	 * to a height balanced BST.
	 */
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4, 5, 6, 7};
		TreeNode root = sortedArrayToBST(nums);
		inorder(root);
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

	public static TreeNode sortedArrayToBST(int[] nums) {
		return sortedArrayToBSTHelper(nums, 0, nums.length - 1);
	}

	public static TreeNode sortedArrayToBSTHelper(int[] nums, int left,
			int right) {
		if (left > right) {
			return null;
		}

		int mid = left + (right - left) / 2;
		TreeNode newNode = new TreeNode(nums[mid]);
		newNode.left = sortedArrayToBSTHelper(nums, left, mid - 1);
		newNode.right = sortedArrayToBSTHelper(nums, mid + 1, right);
		return newNode;
	}

	public static void inorder(TreeNode tree) {
		if (tree != null) {
			inorder(tree.left);
			System.out.println(tree.val);
			inorder(tree.right);
		}
	}
}
