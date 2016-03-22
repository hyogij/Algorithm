/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.22
 Problem : http://buttercola.blogspot.kr/2015/12/blog-post.html
 ==========================================================
 */
public class Solution {
	/*
	 * Given a binary tree, find the length of the longest consecutive sequence
	 * path. The path refers to any sequence of nodes from some starting node to
	 * any node in the tree along the parent-child connections. The longest
	 * consecutive path need to be from parent to child (cannot be the reverse).
	 * For example, 
	 * 		1 
	 * 			\ 
	 * 				3 
	 * 				/ \ 
	 * 			2 		4 
	 * 					\ 
	 * 						5
	 * Longest consecutive sequence path is 3-4-5, so return 3. 
	 * 			2 
	 * 				\ 
	 * 				3 
	 * 				/ 
	 * 			2 
	 * 			/ 
	 * 		1 
	 * Longest consecutive sequence path is 2-3,not3-2-1, so return 2.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);
		
		System.out.println("longestConsecutivePath " + longestConsecutivePath(root));
	}

	public static int longestConsecutivePath(TreeNode root) {
		if (root == null)
			return 0;
		helper(root.left, root.val, 1);
		helper(root.right, root.val, 1);
		return max;
	}

	static int max = 0;
	public static void helper(TreeNode root, int val, int depth) {
		if (root == null)
			return;
		
		if (root.val - val == 1) {
			depth += 1;
			max = Math.max(depth, max);
		} else {
			depth = 1;
		}
		helper(root.left, root.val, depth);
		helper(root.right, root.val, depth);
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

