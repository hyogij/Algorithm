/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.10
 Link : http://www.geeksforgeeks.org/convert-given-binary-tree-doubly-linked-list-set-3/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a Binary Tree (BT), convert it to a Doubly Linked List(DLL)
	 * In-Place. The left and right pointers in nodes are to be used as previous
	 * and next pointers respectively in converted DLL. The order of nodes in
	 * DLL must be same as Inorder of the given Binary Tree. The first node of
	 * Inorder traversal (left most node in BT) must be head node of the DLL.
	 * 
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

		System.out.println("printTree");
		printTree(tree);
		System.out.println("");

		convertToDDL(tree);
		printLinkedList(head);
	}

	static TreeNode head = null;
	static TreeNode prev = null;

	public static void convertToDDL(TreeNode root) {
		if (root != null) {

			convertToDDL(root.left);
			if (prev == null) {
				head = root;
				System.out.println("head " + head.val + " ");
			} else {
				prev.right = root;
				root.left = prev;
			}
			prev = root;

			convertToDDL(root.right);
		}
	}

	public static void printTree(TreeNode root) {
		if (root != null) {
			printTree(root.left);
			System.out.print(root.val + " ");
			printTree(root.right);
		}
	}

	public static void printLinkedList(TreeNode root) {
		TreeNode current = root;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.right;
		}
	}

	public static void TreeNode(TreeNode head) {
		TreeNode current = head;
		while (current != null) {
			System.out.print(current.val + " ");
			current = current.right;
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

	public static class Node {
		int val;
		Node pre;
		Node next;

		public Node(int value) {
			this.val = value;
		}
	}

}