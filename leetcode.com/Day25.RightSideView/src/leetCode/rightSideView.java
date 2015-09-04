package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.04
 Question Number : 99
 Link : https://leetcode.com/problems/binary-tree-right-side-view/
 ==========================================================
 */

public class rightSideView {
	/*
	 * Given a binary tree, imagine yourself standing on the right side of it,
	 * return the values of the nodes you can see ordered from top to bottom.
	 * 
	 * For example: Given the following binary tree, 
	 * 			1 <---
	 * 		   / \ 
	 *       2   3 <--- 
	 *        \    \ 
	 *         5    4 <--- 
	 * You should return [1, 3, 4].
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(1);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(3);
		tree.left.right = new TreeNode(5);
		tree.right.right = new TreeNode(4);

		System.out.println("rightSideView : " + rightSideView(tree).toString());
		System.out.println("rightSideViewFast : "
				+ rightSideViewFast(tree).toString());
	}
	
	public static List<Integer> rightSideViewFast(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if (root == null) {
			return list;
		}

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		TreeNode node = null;
		queue.add(root);
		while (queue.isEmpty() != true) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				node = queue.remove();
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			// If level is changed, then insert the node value in previous level
			list.add(node.val);
		}

		return list;
	}

	public static List<Integer> rightSideView(TreeNode root) {
		List<Integer> list = new ArrayList<Integer>();
		if(root == null) {
			return list;
		}
		
		Queue<NodeInfo> queue = new LinkedList<NodeInfo>();
		int rightSide = root.val;
		int currentLevel = 0;
		
		queue.add(new NodeInfo(root, 0));
		while(queue.isEmpty() != true) {
			NodeInfo nodeInfo = queue.remove();

			// If level is changed, then insert the node value in previous level
			if(currentLevel != nodeInfo.level) {
				currentLevel = nodeInfo.level;
				list.add(rightSide);
			}
			rightSide = nodeInfo.node.val;
			
			if(nodeInfo.node.left != null) {
				queue.add(new NodeInfo(nodeInfo.node.left, nodeInfo.level + 1));				
			}
			if(nodeInfo.node.right != null) {
				queue.add(new NodeInfo(nodeInfo.node.right, nodeInfo.level + 1));				
			}
		}
		// Add the last node into the list
		list.add(rightSide);
		
		return list;
	}

	public static class NodeInfo {
		int level;
		TreeNode node;
		NodeInfo(TreeNode node, int level) {
			this.node = node;
			this.level = level;
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
