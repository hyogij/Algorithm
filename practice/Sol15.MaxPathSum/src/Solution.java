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
	 * is 7->10. 10 / \ -2 7 / \ 8 -4
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(10);
		tree.left = new TreeNode(-2);
		tree.right = new TreeNode(7);
		tree.left.left = new TreeNode(8);
		tree.left.right = new TreeNode(4);

		// printGraph(tree);
		System.out.println("maxPathSum : " + maxPathSum(tree));
		for(int i = 0; i < path.size(); i++) {
			System.out.println("val : " + path.get(i).val);
		}
	}

	public static int maxPathSum(TreeNode root) {
		if (root == null) {
			return -1;
		}
		List<TreeNode> list = new ArrayList<TreeNode>();
		maxPathSumHelper(root, list, 0);
		return max;
	}

	private static List<TreeNode> path = null;
	private static int max = Integer.MIN_VALUE;
	private static void maxPathSumHelper(TreeNode root, List<TreeNode> list, int sum) {
		if(root == null) {
			if(sum > max) {
				max = sum;
				path = new ArrayList<TreeNode>(list);
			}
			return;
		}
		
		list.add(root);
		maxPathSumHelper(root.left, list, sum + root.val);
		maxPathSumHelper(root.right, list, sum + root.val);
		list.remove(list.size() - 1);
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
		if (node == leaf || printPath(node.left, leaf) || printPath(node.right, leaf)) {
			System.out.print(node.val + " ");
			return true;
		}

		return false;
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