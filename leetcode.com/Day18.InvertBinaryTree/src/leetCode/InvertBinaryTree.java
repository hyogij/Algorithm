package leetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.08.18
Question Number : 72
Link : https://leetcode.com/problems/invert-binary-tree/
==========================================================
*/

public class InvertBinaryTree {
	/*
	 * Invert a binary tree.
			     4
			   /   \
			  2     7
			 / \   / \
			1   3 6   9
			to
			     4
			   /   \
			  7     2
			 / \   / \
			9   6 3   1
	 */

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(4);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(3);
		tree.right.left = new TreeNode(6);
		tree.right.right = new TreeNode(9);

		System.out.println("binaryTreePaths1 : "
				+ binaryTreePaths(tree).toString());
		tree = invertTreeIterative(tree);
		System.out.println("binaryTreePaths2 : "
				+ binaryTreePaths(tree).toString());
	}

	public static TreeNode invertTreeRecursive(TreeNode root) {
		if (root == null) {
			return null;
		}
		return invertTreeRecursiveHelper(root);
	}

	// Invert a binary tree through recursive method
	public static TreeNode invertTreeRecursiveHelper(TreeNode root) {
		TreeNode tmp = root.right;
		root.right = root.left;
		root.left = tmp;

		if (root.left != null) {
			invertTreeRecursiveHelper(root.left);
		}

		if (root.right != null) {
			invertTreeRecursiveHelper(root.right);
		}

		return root;
	}

	public static TreeNode invertTreeIterative(TreeNode root) {
		if (root == null) {
			return null;
		}
		return invertTreeIterativeHelper(root);
	}

	// Invert a binary tree through iterative method
	public static TreeNode invertTreeIterativeHelper(TreeNode root) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		list.add(root);

		// Use BFS traverse method to visit a binary tree using queue
		while (list.isEmpty() != true) {
			TreeNode head = list.remove(0);
			
			TreeNode tmp = head.right;
			head.right = head.left;
			head.left = tmp;

			if (head.right != null) {
				list.add(head.right);
			}

			if (head.left != null) {
				list.add(head.left);
			}
		}
		
		return root;
	}

	public static List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();

		if (root != null) {
			binaryTreeDFS(root, paths,
					new StringBuffer(String.valueOf(root.val)));
		}

		return paths;
	}

	public static void binaryTreeDFS(TreeNode root, List<String> paths,
			StringBuffer path) {
		if (root.left == null && root.right == null) {
			paths.add(path.toString());
		}

		if (root.left != null) {
			binaryTreeDFS(root.left, paths, new StringBuffer(path.toString()
					+ "->" + root.left.val));
		}
		if (root.right != null) {
			binaryTreeDFS(root.right, paths, new StringBuffer(path.toString()
					+ "->" + root.right.val));
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
