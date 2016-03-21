package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2015.08.19
Question Number : 76
Link : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
==========================================================
*/

public class LevelOrderTraversal2 {
	/*
	 * Given a binary tree, return the bottom-up level order traversal of its
	 * nodes' values. (ie, from left to right, level by level from leaf to
	 * root).
	 * 
		 * For example: Given binary tree {3,9,20,#,#,15,7}, 
	 *   3 
	 *  / \ 
	 * 9 20 
	 *    / \ 
	 *   15 7
	 *   
	 * return its level order traversal as: 
	 *  [ 
	 *  [15,7], 
	 *  [9,20], 
	 *  [3] 
	 *  ]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);

		List<List<Integer>> list = levelOrder(root);
		System.out.println("levelOrder " + list.toString());

		Collections.reverse(list);
		System.out.println("levelOrder " + list.toString());
		
		list = levelOrderAdvanced(root);
		System.out.println("levelOrder " + list.toString());
	}
	
	// Level order traversal using queue
	public static List<List<Integer>> levelOrderAdvanced(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (root == null) {
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		Stack<List<Integer>> stack = new Stack<List<Integer>>();
		queue.add(root);
		while (queue.isEmpty() == false) {
			List<Integer> current = new ArrayList<Integer>();

			// Get the number of nodes in current depth
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				current.add(node.val);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
			stack.add(current);
		}

		int size = stack.size();
		for (int i = 0; i < size; i++) {
			List<Integer> current = stack.pop();
			list.add(current);
		}

		return list;
	}

	public static List<List<Integer>> levelOrder(TreeNode root) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();

		if (root == null) {
			return list;
		}

		Queue<NodeInfo> queue = new LinkedList<NodeInfo>();

		// Adds a root node
		NodeInfo nodeInfo = new NodeInfo(0);
		nodeInfo.node = root;
		queue.add(nodeInfo);

		int height = getHeight(root);
		for (int i = 0; i < height; i++) {
			list.add(new ArrayList<Integer>());
		}

		while (queue.isEmpty() == false) {
			NodeInfo currentInfo = queue.remove();

			int index = height - currentInfo.height - 1;
			list.get(index).add(currentInfo.node.val);

			// Adds a left child of current node
			if (currentInfo.node.left != null) {
				nodeInfo = new NodeInfo(currentInfo.height + 1);
				nodeInfo.node = currentInfo.node.left;
				queue.add(nodeInfo);
			}

			// Adds a right child of current node
			if (currentInfo.node.right != null) {
				nodeInfo = new NodeInfo(currentInfo.height + 1);
				nodeInfo.node = currentInfo.node.right;
				queue.add(nodeInfo);
			}
		}

		return list;
	}

	public static int getHeight(TreeNode root) {
		if (root == null) {
			return 0;
		}
		return 1 + Math.max(getHeight(root.left), getHeight(root.right));
	}

	public static class NodeInfo {
		int height;
		TreeNode node;
		NodeInfo(int x) {
			height = x;
		}
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}
}
