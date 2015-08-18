package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.08.18
Question Number : 70
Link : https://leetcode.com/problems/implement-queue-using-stacks/
==========================================================
*/

public class BinaryTreePaths {
	/*
	 * Given a binary tree, return all root-to-leaf paths.
	 * 
	 * For example, given the following binary tree:
	 *   1 
	 *   / \ 
	 *  2  3 
	 *    \ 
	 *     5 
	 *     
	 * All root-to-leaf paths are: ["1->2->5", "1->3"]
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.right = new TreeNode(5);
		
		System.out.println("binaryTreePaths : " + binaryTreePaths(tree).toString());
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
