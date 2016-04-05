/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.05
 Problem : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
 ==========================================================
 */
public class Solution {
	/*
	 * Serialization is the process of converting a data structure or object
	 * into a sequence of bits so that it can be stored in a file or memory
	 * buffer, or transmitted across a network connection link to be
	 * reconstructed later in the same or another computer environment.
	 * 
	 * Design an algorithm to serialize and deserialize a binary tree. There is
	 * no restriction on how your serialization/deserialization algorithm should
	 * work. You just need to ensure that a binary tree can be serialized to a
	 * string and this string can be deserialized to the original tree
	 * structure.
	 * 
	 * For example, you may serialize the following tree
	 * 
	 * 1 / \ 2 3 / \ 4 5 as "[1,2,3,null,null,4,5]", just the same as how
	 * LeetCode OJ serializes a binary tree. You do not necessarily need to
	 * follow this format, so please be creative and come up with different
	 * approaches yourself. Note: Do not use class member/global/static
	 * variables to store states. Your serialize and deserialize algorithms
	 * should be stateless.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(2);
		root.left.left.left = new TreeNode(1);
		root.right = new TreeNode(12);
		root.right.right = new TreeNode(22);
		root.right.right.right = new TreeNode(31);
		inorder(root);
		System.out.println();

		// Your Codec object will be instantiated and called as such:
		Codec codec = new Codec();
		String data = codec.serialize(root);
		System.out.println(data);
		TreeNode node = codec.deserialize(data);
		inorder(node);
		System.out.println();
	}

	public static class Codec {

		// Encodes a tree to a single string.
		public static String serialize(TreeNode root) {
			StringBuffer sb = new StringBuffer();
			serializeHelper(root, sb);
			return sb.toString();
		}

		public static void serializeHelper(TreeNode root, StringBuffer sb) {
			if (root == null) {
				sb.append("##");
				sb.append(",");
				return;
			}

			sb.append(root.val);
			sb.append(",");
			serializeHelper(root.left, sb);
			serializeHelper(root.right, sb);
		}

		// Decodes your encoded data to tree.
		public static TreeNode deserialize(String data) {
			String[] array = data.split(",");
			int[] index = {0};
			return deserializeHelper(array, index);
		}

		public static TreeNode deserializeHelper(String[] array, int[] index) {
			if (index[0] >= array.length) {
				return null;
			}

			if (array[index[0]].equals("##")) {
				// Increase index of array
				index[0]++;
				return null;
			}

			TreeNode node = new TreeNode(Integer.valueOf(array[index[0]]));
			index[0]++;
			node.left = deserializeHelper(array, index);
			node.right = deserializeHelper(array, index);
			return node;
		}
	}

	/**
	 * Definition for a binary tree node.
	 */
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) {
			val = x;
		}
	}

	public static void inorder(TreeNode root) {
		if (root != null) {
			inorder(root.left);
			System.out.print(root.val + " ");
			inorder(root.right);
		}
	}
}