/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.10
 Problem : https://leetcode.com/discuss/questions/oj/inorder-successor-in-bst
 http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a binary search tree and a node in it, find the in-order successor
	 * of that node in the BST.
	 * 
	 * Example Given tree = [2,1] and node = 1:
	 * 
	 * 		2 
	 * 	   / 
	 * 	  1 
	 * return node 2.
	 * 
	 * Given tree = [2,1,3] and node = 2:
	 * 
	 * 		2
	 *     / \ 
	 *    1   3
	 * return node 3.
	 * 
	 * Note If the given node has no in-order successor in the tree, return
	 * null.
	 * 
	 * Challenge O(h), where h is the height of the BST.
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(6);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(8);
		tree.left.left = new TreeNode(0);
		tree.left.right = new TreeNode(4);
		tree.right.left = new TreeNode(7);
		tree.right.right = new TreeNode(9);
		tree.left.right.left = new TreeNode(3);
		tree.left.right.right = new TreeNode(5);

		System.out.println("inorderSuccessor : "
				+ inorderSuccessor(tree, tree.right.left).val);
	}

	public static TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
		if (root == null || p == null) {
			return null;
		}

		TreeNode successor = null;
		if (p.right == null) {
			successor = findSuccessor(root, p);
		} else {
			successor = leftmostChild(p.right);
		}

		return successor;
	}

	private static TreeNode findSuccessor(TreeNode root, TreeNode target) {
		TreeNode node = root, successor = null;
		while (node != null) {
			if (node.val == target.val) {
				return successor;
			} else if (node.val < target.val) {
				node = node.right;
			} else {
				successor = node;
				node = node.left;
			}
		}
		return null;
	}
	 
	 private static TreeNode leftmostChild(TreeNode node) {
		 TreeNode leftmost = node;
		 while(leftmost.left != null) 
			 leftmost = leftmost.left;
		 
		 return leftmost;
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
