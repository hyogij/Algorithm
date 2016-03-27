
/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.27
 Link : http://www.geeksforgeeks.org/find-the-largest-subtree-in-a-tree-that-is-also-a-bst/
 ==========================================================
 */

public class Solution {
	/*
	 * Find the largest BST subtree in a given Binary Tree Given a Binary Tree,
	 * write a function that returns the size of the largest subtree which is
	 * also a Binary Search Tree (BST). If the complete Binary Tree is BST, then
	 * return the size of whole tree.
	 */
	public static void main(String[] args) {
		// TreeNode tree = new TreeNode(5);
		// tree.left = new TreeNode(2);
		// tree.right = new TreeNode(4);
		// tree.right.right = new TreeNode(6);
		// tree.left.left = new TreeNode(1);
		// tree.left.right = new TreeNode(3);

		TreeNode tree = new TreeNode(50);
		tree.left = new TreeNode(30);
		tree.left.left = new TreeNode(5);
		tree.left.right = new TreeNode(20);
		tree.right = new TreeNode(60);
		tree.right.left = new TreeNode(55);
		tree.right.left.left = new TreeNode(61);
		tree.right.right = new TreeNode(70);
		tree.right.right.left = new TreeNode(65);
		tree.right.right.right = new TreeNode(80);

		System.out.println("largestBST " + largestBST(tree));
	}

	private static int largestBST(TreeNode root) {
		int[] max = { 0 };
		largestBSTHelper(root, max);
		return max[0];
	}

	private static BstInfo largestBSTHelper(TreeNode root, int[] max) {
		if (root == null) {
			return null;
		}

		BstInfo leftBstInfo = largestBSTHelper(root.left, max);
		BstInfo rightBstInfo = largestBSTHelper(root.right, max);

		if (leftBstInfo == null && rightBstInfo == null) {
			BstInfo bstInfo = new BstInfo();
			bstInfo.treeSize = 1;
			bstInfo.isBST = true;
			bstInfo.max = bstInfo.min = root.val;
			return bstInfo;
		}

		// 한쪽만 있는 경우
		if (leftBstInfo == null && rightBstInfo != null) {
			if (rightBstInfo.isBST && rightBstInfo.min > root.val) {
				BstInfo bstInfo = new BstInfo();
				bstInfo.treeSize = rightBstInfo.treeSize + 1;
				bstInfo.min = root.val;
				bstInfo.max = rightBstInfo.max;

				if (bstInfo.treeSize > max[0])
					max[0] = bstInfo.treeSize;
				return bstInfo;
			}
		} else if (leftBstInfo != null && rightBstInfo == null) {
			if (leftBstInfo.isBST && leftBstInfo.max < root.val) {
				BstInfo bstInfo = new BstInfo();
				bstInfo.isBST = true;
				bstInfo.treeSize = leftBstInfo.treeSize + 1;
				bstInfo.min = leftBstInfo.min;
				bstInfo.max = root.val;

				if (bstInfo.treeSize > max[0])
					max[0] = bstInfo.treeSize;
				return bstInfo;
			}
		} else {
			// 둘 다 있는 경우
			if (leftBstInfo.isBST && rightBstInfo.isBST) {
				if (leftBstInfo.max < root.val && rightBstInfo.min > root.val) {
					BstInfo bstInfo = new BstInfo();
					bstInfo.isBST = true;
					bstInfo.treeSize = leftBstInfo.treeSize + rightBstInfo.treeSize + 1;
					bstInfo.min = leftBstInfo.min;
					bstInfo.max = rightBstInfo.max;

					if (bstInfo.treeSize > max[0])
						max[0] = bstInfo.treeSize;
					return bstInfo;
				}
			}
		}

		BstInfo bstInfo = new BstInfo();
		return bstInfo;
	}

	public static class BstInfo {
		int treeSize = 0;
		boolean isBST = false;
		int max = Integer.MAX_VALUE;
		int min = Integer.MIN_VALUE;

		@Override
		public String toString() {
			return isBST + " : " + treeSize;
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
