import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.06
 Problem : http://www.geeksforgeeks.org/fix-two-swapped-nodes-of-bst/
 ==========================================================
 */
public class Solution {
	/*
	 * Two of the nodes of a Binary Search Tree (BST) are swapped. Fix (or
	 * correct) the BST.
	 * 
	 * Input Tree: 10 / \ 5 8 / \ 2 20
	 * 
	 * In the above tree, nodes 20 and 8 must be swapped to fix the tree.
	 * Following is the output tree 10 / \ 5 20 / \ 2 8
	 */
	public static void main(String[] args) {
		/*   6
	        /  \
	       10    2
	      / \   / \
	     1   3 7  12
	     10 and 2 are swapped
	    */
		TreeNode tree = new TreeNode(6);
		tree.left = new TreeNode(10);
		tree.right = new TreeNode(2);
		tree.left.left = new TreeNode(1);
		tree.left.right = new TreeNode(3);
		tree.right.left = new TreeNode(7);
		tree.right.right = new TreeNode(12);

		inorder(tree);
		System.out.println();

		correctBST(tree);

		inorder(tree);
		System.out.println();
	}

	// A function to fix a given BST where two nodes are swapped. This
	// function uses correctBSTUtil() to find out two nodes and swaps the
	// nodes to fix the BST
	public static void correctBST(TreeNode root) {
		if (root == null)
			return;

		TreeNode swap1 = null, swap2 = null;
		swap1 = findSwapNode(root);
		swap2 = findSwapNodeReverse(root);

		swap(swap1, swap2);
	}

	private static TreeNode findSwapNode(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		// Traverse binary tree from left to right
		TreeNode current = root, prev = null, swap = null;
		while (current != null) {
			stack.push(current);
			current = current.left;
		}

		while (!stack.isEmpty()) {
			current = stack.pop();

			// Find swap node in inorder traverse
			if (prev != null && prev.val > current.val) {
				swap = prev;
				break;
			}

			prev = current;
			current = current.right;
			while (current != null) {
				stack.push(current);
				current = current.left;
			}
		}
		return swap;
	}

	private static TreeNode findSwapNodeReverse(TreeNode root) {
		Stack<TreeNode> stack = new Stack<TreeNode>();

		// Traverse binary tree from left to right
		TreeNode current = root, prev = null, swap = null;
		while (current != null) {
			stack.push(current);
			current = current.right;
		}

		while (!stack.isEmpty()) {
			current = stack.pop();

			// Find swap node in reverse inorder traverse
			if (prev != null && prev.val < current.val) {
				swap = prev;
				break;
			}

			prev = current;
			current = current.left;
			while (current != null) {
				stack.push(current);
				current = current.right;
			}
		}
		return swap;
	}

	private static void swap(TreeNode swap1, TreeNode swap2) {
		int tmp = swap1.val;
		swap1.val = swap2.val;
		swap2.val = tmp;

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
