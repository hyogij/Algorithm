import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.05
 Question Number : 03
 Description : http://www.geeksforgeeks.org/inorder-successor-in-binary-search-tree/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a node n in a binary search tree, explain and code the most
	 * efficient way to find the inoder successor of n. Analyze the runtime
	 * complexity of your solution.
	 */
	public static void main(String[] args) {
		TreeNode head = new TreeNode(10);
		head.left = new TreeNode(5);
		head.left.left = new TreeNode(2);
		head.left.right = new TreeNode(7);
		head.right = new TreeNode(15);
		head.right.left = new TreeNode(12);
		head.right.right = new TreeNode(17);

		TreeNode n = new TreeNode(5);
		TreeNode node = findParentNode(head, n);
		System.out.println("findParentNode : " + node.val);
		System.out.println("inoderTraversalRecusive");
		inoderTraversalRecusive(head);
		System.out.println("\ninoderTraversalIterative");
		inoderTraversalIterative(head);
	}

	// Recursive method
	private static void inoderTraversalRecusive(TreeNode head) {
		if (head != null) {
			inoderTraversalRecusive(head.left);
			System.out.print(" " + head.val);
			inoderTraversalRecusive(head.right);
		}
	}

	// Iterative method
	private static void inoderTraversalIterative(TreeNode head) {
		if (head == null) {
			return;
		}

		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = head;

		while (stack.isEmpty() == false || node != null) {
			if (node != null) {
				stack.push(node);
				node = node.left;
			} else {
				node = stack.pop();
				System.out.print(" " + node.val);
				node = node.right;
			}
		}

		return;
	}

	private static TreeNode findParentNode(TreeNode head, TreeNode n) {
		TreeNode successor = null;
		TreeNode node = head;
		while (node != null) {
			if (node.val == n.val) {
				return successor;
			}

			successor = node;
			if (node.val < n.val) {
				node = node.right;
			} else if (node.val > n.val) {
				node = node.left;
			}
		}
		return null;
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
