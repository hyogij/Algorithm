import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/*
==========================================================
Author : Hyogi Jung(hyogij@gmail.com)
Date : 2016.03.26
Problem : https://leetcode.com/problems/symmetric-tree/
==========================================================
*/
public class Solution {
	/*
	 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(5);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(2);
		tree.right.right = new TreeNode(6);
		tree.left.right = new TreeNode(6);
		// tree.left.left = new TreeNode(1);
		// tree.left.right = new TreeNode(3);

		System.out.println("isSymmetric " + isSymmetric(tree));
	}

	public static boolean isSymmetric(TreeNode root) {
		if (root == null)
			return true;

		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);

		while (queue.isEmpty() != true) {
			ArrayList<TreeNode> list = new ArrayList<TreeNode>();
			int length = queue.size();
			for (int i = 0; i < length; i++) {
				TreeNode node = queue.poll();
				list.add(node.left);
				list.add(node.right);
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}

			System.out.println(list.toString());

			// Compare values in linked list
			for (int i = 0; i < list.size() / 2; i++) {
				TreeNode node1 = (TreeNode) list.get(i);
				TreeNode node2 = (TreeNode) list.get(list.size() - i - 1);
				if (node1 != null && node2 != null && node1.val != node2.val)
					return false;
				if (node1 == null && node2 != null)
					return false;
				if (node1 != null && node2 == null)
					return false;
			}
		}

		return true;
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
