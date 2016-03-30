import java.util.Stack;


/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.30
 Problem : http://www.geeksforgeeks.org/find-a-pair-with-given-sum-in-bst/
 ==========================================================
 */

public class Solution {
	/*
	 * Find a pair with given sum in a Balanced BST Given a Balanced Binary
	 * Search Tree and a target sum, write a function that returns true if there
	 * is a pair with sum equals to target sum, otherwise return false. Expected
	 * time complexity is O(n) and only O(Logn) extra space can be used. Any
	 * modification to Binary Search Tree is not allowed. Note that height of a
	 * Balanced BST is always O(Logn). 
	 * 				15 
	 * 				/ \ 
	 * 			10   20 
	 * 			/ \   / \ 
	 * 		   8 12 16 25
	 */

	public static void main(String[] args) {
		TreeNode tree = new TreeNode(15);
		tree.left = new TreeNode(10);
		tree.right = new TreeNode(20);
		tree.left.left = new TreeNode(8);
		tree.left.right = new TreeNode(12);
		tree.right.left = new TreeNode(16);
		tree.right.right = new TreeNode(25);

		// printGraph(tree);
		inorder(tree);
		System.out.println("isPairPresent " + isPairPresent(tree, 33));
	}
	
	public static boolean isPairPresent(TreeNode root, int target) {
		if(root == null)
			return false;
		
		Stack<TreeNode> stack1 = new Stack<TreeNode>();
		Stack<TreeNode> stack2 = new Stack<TreeNode>();
		
		TreeNode forward = root, reverse = root;
		// Insert left children into stack1
		while(forward != null) {
			stack1.add(forward);
			forward = forward.left;
		}
		
		// Insert right children into stack2
		while(reverse != null) {
			stack2.add(reverse);
			reverse = reverse.right;
		}
		
		while (stack1.isEmpty() != true && stack2.isEmpty() != true) {
			TreeNode node1 = stack1.peek();
			TreeNode node2 = stack2.peek();
			
			if(node1.val + node2.val == target) {
				return true;
			} else if(node1.val + node2.val > target) {
				// TODO(hyogij)
			}
		}
		
		return false;
	}
	
	// Inorder traverse using stack
	public static void inorder(TreeNode root) {
		if (root == null)
			return;

		TreeNode current = root;
		Stack<TreeNode> stack = new Stack<TreeNode>();

		// Push nodes from root's left children
		while (current != null) {
			stack.add(current);
			current = current.left;
		}

		while (stack.isEmpty() != true) {
			current = stack.pop();
			System.out.print(current.val + " ");

			current = current.right;
			// Push nodes from root's left children
			while (current != null) {
				stack.add(current);
				current = current.left;
			}
		}
		return;
	}

	// Definition for a binary tree node.
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}

		public String toString() {
			return val + " ";
		}
	}
}