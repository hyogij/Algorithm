/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.22
 Problem : http://www.geeksforgeeks.org/remove-nodes-root-leaf-paths-length-k/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a Binary Tree and a number k, remove all nodes that lie only on
	 * root to leaf path(s) of length smaller than k. If a node X lies on
	 * multiple root-to-leaf paths and if any of the paths has path length >= k,
	 * then X is not deleted from Binary Tree. In other words a node is deleted
	 * if all paths going through it have lengths smaller than k.

		Example Binary Tree
		               1
		           /      \
		         2          3
		      /     \         \
		    4         5        6
		  /                   /
		 7                   8 
		Input: Root of above Binary Tree
		       k = 4
       
		         1
		        /     \
		      2          3
		     /             \
		   4                 6
		 /                  /
		7                  8
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.left.left.left = new TreeNode(7);
		root.right.right = new TreeNode(6);
		root.right.right.left = new TreeNode(8);
		root.right.right.left.left = new TreeNode(11);

		DFS(root);
		TreeNode node = removeShortPathNodesAdvanced(root, 6);
		System.out.println();
		DFS(node);
	}


	public static TreeNode removeShortPathNodesAdvanced(TreeNode node, int k) {
		if (node == null || k == 0)
			return null;
		return removeShortPathNodesAdvancedUtil(node, 1, k);
	}
	
	public static TreeNode removeShortPathNodesAdvancedUtil(TreeNode node, int level, int k) {
		if(node == null)
			return null;
		
		node.left = removeShortPathNodesAdvancedUtil(node.left, level+1, k);
		node.right = removeShortPathNodesAdvancedUtil(node.right, level+1, k);
		
		if (node.left == null && node.right == null && level < k) {
            return null;
        }
		
		return node;
	}
	
	public static TreeNode removeShortPathNodes(TreeNode node, int k) {
		if (node == null)
			return null;
		return removeShortPathNodesUtil(node, 1, k);
	}

	public static TreeNode removeShortPathNodesUtil(TreeNode node, int level,
			int k) {
		if (node.left != null) {
			int height = getHeight(node.left);
			if (level + height - 1 < k)
				node.left = null;
			else
				node.left = removeShortPathNodesUtil(node.left, level + 1, k);
		}
		if (node.right != null) {
			int height = getHeight(node.right);
			if (level + height - 1 < k)
				node.right = null;
			else
				node.right = removeShortPathNodesUtil(node.right, level + 1, k);
		}

		return node;
	}

	public static int getHeight(TreeNode node) {
		if (node == null)
			return 0;
		return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
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

	public static void DFS(TreeNode root) {
		if (root != null) {
			DFS(root.left);
			System.out.print(root.val + " ");
			DFS(root.right);
		}
	}
}
