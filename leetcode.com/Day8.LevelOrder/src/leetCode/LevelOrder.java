package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.14
 Question Number : 34
 Link : https://leetcode.com/problems/binary-tree-level-order-traversal/
 ==========================================================
 */
public class LevelOrder {
	/*
	 * Given a binary tree, return the level order traversal of its nodes'
	 * values. (ie, from left to right, level by level).
	 * 
	 * For example: Given binary tree {3,9,20,#,#,15,7}, 
	 * 3 
	 * / \ 
	 * 9 20 
	 *    / \ 
	 *   15 7
	 * return its level order traversal as: 
	 * [ 
	 * [3], 
	 * [9,20], 
	 * [15,7] 
	 * ]
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println("levelOrder " + levelOrder(root).toString());
	}

	// Level order traversal using queue
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
		
		while (queue.isEmpty() == false) {
			NodeInfo currentInfo = queue.remove();
			
			if(list.size() < currentInfo.height + 1) {
				list.add(new ArrayList<Integer>());
			}
			list.get(currentInfo.height).add(currentInfo.node.val);

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
