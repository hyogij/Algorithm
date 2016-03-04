import java.util.ArrayList;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.04
 Problem : http://www.geeksforgeeks.org/find-the-maximum-sum-path-in-a-binary-tree/
 ==========================================================
 */

public class Solution {
	/*
	 * Given a Binary Tree, find the maximum sum path from a leaf to root. For
	 * example, in the following tree, there are three leaf to root paths
	 * 8->-2->10, -4->-2->10 and 7->10. The sums of these three paths are 16, 4
	 * and 17 respectively. The maximum of them is 17 and the path for maximum
	 * is 7->10. 
	 * 				10 
	 * 				/ \ 
	 * 			-2    7
	 *          / \ 
	 *        8   -4
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(11);
		tree.left = new TreeNode(-2);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(10);
		tree.left.right = new TreeNode(4);
		
//		printGraph(tree);
		System.out.println("maxPathSum : " + maxPathSum(tree));
		System.out.println("maxLeaf : " + maxLeaf.val);
		printPath(tree, maxLeaf);
	}
	
	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return -1;
		}
//		ArrayList<TreeNode> path = new ArrayList<TreeNode>();
//		return maxPathSumHelperPath(root, path);
		return maxPathSumHelper(root, null, root.val);
	}

	private static int max = Integer.MIN_VALUE;
	private static TreeNode maxLeaf = null;
	
	// Recursive method to get maximum path from root to leaf in binary tree
	private static int maxPathSumHelper(TreeNode node, TreeNode parent, int val) {
		if (node == null) {
			if(val > max) {
				max = val;
				maxLeaf = parent;
			}
			return val;
		} else {
			val += node.val;
			int sumOfLeft = maxPathSumHelper(node.left, node, val);
			int sumOfRight = maxPathSumHelper(node.right, node, val);
			return Math.max(sumOfLeft, sumOfRight);
		}
	}
	
	// A utility function that prints all nodes on the path from root to
	// target_leaf
	private static boolean printPath(TreeNode node, TreeNode leaf) {
		// base case
		if (node == null) {
			return false;
		}

		// return true if this node is the target_leaf or target leaf is present
		// in one of its descendants
		if (node == leaf || printPath(node.left, leaf)
				|| printPath(node.right, leaf)) {
			System.out.print(node.val + " ");
			return true;
		}

		return false;
	}

	// Recursive method to get maximum path from root to leaf in binary tree
	private static int maxPathSumHelperPath(TreeNode node, ArrayList<TreeNode> path) {
		if (node == null) {
			int sum = 0;
			for (TreeNode tmp : path) {
				sum += tmp.val;
			}
			return sum;
		} else {
			ArrayList<TreeNode> newPath = new ArrayList<TreeNode>(path);
			newPath.add(node);
			int sumOfLeft = maxPathSumHelperPath(node.left, newPath);
			int sumOfRight = maxPathSumHelperPath(node.right, newPath);
			return Math.max(sumOfLeft, sumOfRight);
		}
	}
	
	public static void printGraph(TreeNode root) {
		if (root != null) {
			System.out.println(root.val);
			printGraph(root.left);
			printGraph(root.right);
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