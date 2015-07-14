package leetCode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.14
 Question Number : 38
 Link : https://leetcode.com/problems/symmetric-tree/
 ==========================================================
 */
public class SymmetricTree {
	/*
	 * Given a binary tree, check whether it is a mirror of itself (ie,
	 * symmetric around its center).
	 * 
	 * For example, this binary tree is symmetric: 
	 *    1 
	 *   / \
	 *  2 2
	 * / \ / \ 
	 *3 4 4 3 
	 * But the following is not: 
	 *     1 
	 *    / \ 
	 *    2 2 
	 *     \  \ 
	 *      3 3 
	 * Note: Bonus points if you could solve it both recursively and iteratively.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
//		root.right = new TreeNode(2);
//		root.left.left = new TreeNode(3);
//		root.left.right = new TreeNode(4);
//		root.right.left = new TreeNode(4);
//		root.right.right = new TreeNode(3);
		System.out.println("isSameTree " + isSymmetric(root));
	}
	
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	// i) iterative 한 method : level order를 이용하여 각 level이 symmetric 한지 체크, 이렇게
	// 풀면 안된다
	// ii) recursive 한 method :
	public static boolean isSymmetric(TreeNode root) {
		if (root == null) {
			return true;
		}

		List<List<Integer>> list = levelOrder(root);
		
		// Starting value of i is 1 because we can skip the root node
		if(list.size() == 1) {
			return true;
		}
			
		for (int i = 1; i < list.size(); i++) {
			List<Integer> subList = list.get(i);

			// Checkes subList is symmetric?
			if (subList.size() % 2 != 0) {
				return false;
			}
			for (int j = subList.size() / 2 - 1, k = 0; j >= 0; j--, k++) {
				if (subList.get(j) != subList.get(subList.size() / 2 + k)) {
					return false;
				}
			}
		}
		return true;
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

			if (list.size() < currentInfo.height + 1) {
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
}
