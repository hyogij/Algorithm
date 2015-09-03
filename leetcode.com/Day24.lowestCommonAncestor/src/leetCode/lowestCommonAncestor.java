package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.03
 Question Number : 98
 Link : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 ==========================================================
 */

public class lowestCommonAncestor {
	/*
	 * Given a binary tree, find the lowest common ancestor (LCA) of two given
	 * nodes in the tree.
	 * 
	 * According to the definition of LCA on Wikipedia: ¡°The lowest common
	 * ancestor is defined between two nodes v and w as the lowest node in T
	 * that has both v and w as descendants (where we allow a node to be a
	 * descendant of itself).¡±
	 * 
	 * 		       _______6______
	 * 	          /                         \ 
	 *     ___2__                  ___8__ 
	 *    /          \                /           \
	 *   0         _4             7              9 
	 *             /    \ 
	 *            3      5 
	 * For example,
	 * the lowest common ancestor (LCA) of nodes 5 and 1 is 3. Another example
	 * is LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself
	 * according to the LCA definition.
	 */
	public static void main(String[] args) {
		TreeNode tree = new TreeNode(6);
		tree.left = new TreeNode(2);
		tree.right = new TreeNode(8);
		tree.left.left = new TreeNode(0);
		tree.left.right = new TreeNode(4);
		tree.right.left = new TreeNode(7);
		tree.right.right = new TreeNode(9);
		tree.left.right.left = new TreeNode(3);
		tree.left.right.right = new TreeNode(5);

		System.out.println("lowestCommonAncestor : "
				+ lowestCommonAncestor(tree, tree.left.right.left,
						tree.left.right.right).val);
	}

	// Find the lowest common ancestor in binary tree
	public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p,
			TreeNode q) {
		boolean pInLeftSubTree = false, qInLeftSubTree = false;

		// Returns current root node when p or q is same as root node and
		// another node is sub tree of root node.
		if (root == p && isContains(root, q)) {
			return root;
		}
		if (root == q && isContains(root, p)) {
			return root;
		}

		if (isContains(root.left, p)) {
			pInLeftSubTree = true;
		}
		if (isContains(root.left, q)) {
			qInLeftSubTree = true;
		}

		if (pInLeftSubTree == qInLeftSubTree) {
			if (qInLeftSubTree == true) {
				return lowestCommonAncestor(root.left, p, q);
			} else {
				return lowestCommonAncestor(root.right, p, q);
			}
		} else {
			return root;
		}
	}

	public static boolean isContains(TreeNode root, TreeNode target) {
		if (target == null) {
			return false;
		}

		if (root != null) {
			return (root == target) || isContains(root.left, target)
					|| isContains(root.right, target);
		}
		return false;
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
