package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.09
 Question Number : 19
 Link : https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 ==========================================================
 */
public class BuildTree {
	/*
	 * Given preorder and inorder traversal of a tree, construct the binary
	 * tree.
	 * 
	 * Note: You may assume that duplicates do not exist in the tree.
	 */
	public static void main(String[] args) {
	}

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		TreeNode treeNode = new TreeNode(0);
		return treeNode;
	}

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
