package leetCode;

import java.util.LinkedList;
import java.util.Queue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.08.25
 Question Number : 95
 Link : https://leetcode.com/problems/count-complete-tree-nodes/
 ==========================================================
 */

public class CountNodes {
	/*
	 * Given a complete binary tree, count the number of nodes.
	 * 
	 * Definition of a complete binary tree from Wikipedia: In a complete binary
	 * tree every level, except possibly the last, is completely filled, and all
	 * nodes in the last level are as far left as possible. It can have between
	 * 1 and 2h nodes inclusive at the last level h.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(4);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(8);
		root.right.right = new TreeNode(11);

		System.out.println("countNodes " + countNodes(root));
		System.out.println("countNodes " + countNodesQueue(root));
		System.out.println("countNodes " + countNodesFast(root));
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public static int countNodesFast(TreeNode root) {
		int left = getLeftHeight(root);
		int right = getRightHeight(root);

		if (left == right) {
			return (int) (Math.pow(2, left) - 1);
		} else {
			return countNodesFast(root.left) + countNodesFast(root.right) + 1;
		}
	}

	// Height of left most node in binary tree
	public static int getLeftHeight(TreeNode root) {
		int height = 0;
		while (root != null) {
			root = root.left;
			height++;
		}
		return height;
	}

	// Height of right most node in binary tree
	public static int getRightHeight(TreeNode root) {
		int height = 0;
		while (root != null) {
			root = root.right;
			height++;
		}
		return height;
	}

	// Count the nodes in binary tree using queue
	public static int countNodesQueue(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int count = 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while (queue.isEmpty() != true) {
			TreeNode node = queue.remove();
			count++;

			if (node.right != null) {
				queue.add(node.right);
			}
			if (node.left != null) {
				queue.add(node.left);
			}
		}

		return count;
	}

	// Count the nodes in binary tree using recursive method
	public int countNodesRecursive(TreeNode root) {
		if (root != null) {
			return 1 + countNodesRecursive(root.left)
					+ countNodesRecursive(root.right);
		}
		return 0;
	}

	// Count the nodes in binary tree using tree's height and number of leaf
	// nodes
	public static int countNodes(TreeNode root) {
		int height = getHeight(root);
		return (int) ((Math.pow(2, height - 1) - 1) + getLeafNodes(root));
	}

	public static int getHeight(TreeNode root) {
		if (root != null) {
			return 1 + Math.max(getHeight(root.left), getHeight(root.right));
		}
		return 0;
	}

	public static int getLeafNodes(TreeNode root) {
		if (root == null) {
			return 0;
		}
		if (root.left == null && root.right == null) {
			return 1;
		}
		return getLeafNodes(root.left) + getLeafNodes(root.right);
	}
}
