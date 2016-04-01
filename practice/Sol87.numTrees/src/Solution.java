import java.util.LinkedList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.01
 Problem : https://leetcode.com/problems/unique-binary-search-trees/
 ==========================================================
 */
public class Solution {
	/*
	 * Given n, how many structurally unique BST's (binary search trees) that
	 * store values 1...n?
	 * 
	 * For example, Given n = 3, there are a total of 5 unique BST's.
	 */
	public static void main(String[] args) {
		System.out.println("numTrees " + numTrees(3));
		System.out.println("numTrees " + numTrees(4));

		List<TreeNode> trees = generateTrees(4);
		for (int i = 0; i < trees.size(); i++) {
			inorder(trees.get(i));
			System.out.println();
		}
	}

	// 1: 1
	// 2: 2 --> 1 2, 1 2
	// 3: 5 --> 1 {2, 3}, {1} 2 {3}, {1, 2}, 3
	// 4 : 14 --> {2, 3, 4}, {1} 2 {3, 4}, {1, 2} 3 {4}, {1, 2, 3} 4
	// Find the number of unique BSTs
	public static int numTrees(int n) {
		int[] nums = new int[n + 1];

		nums[0] = nums[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				int left = j - 1;
				int right = i - j;
				nums[i] += (nums[left] * nums[right]);
			}
		}

		return nums[n];
	}

	public static List<TreeNode> generateTrees(int n) {
		return generateTreesHelper(1, n);
	}

	public static List<TreeNode> generateTreesHelper(int start, int end) {
		List<TreeNode> list = new LinkedList<TreeNode>();

		if (start > end) {
			list.add(null);
			return list;
		}

		for (int i = start; i <= end; i++) {
			List<TreeNode> lefts = generateTreesHelper(start, i - 1);
			List<TreeNode> rights = generateTreesHelper(i + 1, end);
			for (TreeNode left : lefts) {
				for (TreeNode right : rights) {
					TreeNode node = new TreeNode(i);
					node.left = left;
					node.right = right;
					list.add(node);
				}
			}
		}

		return list;
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

	public static void inorder(TreeNode root) {
		if (root != null) {
			System.out.print(root.val + " ");
			inorder(root.left);
			inorder(root.right);
		}
	}

}
