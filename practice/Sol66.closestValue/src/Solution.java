/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.22
 Problem : http://www.geeksforgeeks.org/sum-of-two-linked-lists/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a non-empty binary search tree and a target value, find the value
	 * in the BST that is closest to the target. Note: Given target value is a
	 * floating point. You are guaranteed to have only one unique value in the
	 * BST that is closest to the target.
	 */
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(2);
		root.right.right = new TreeNode(4);
		root.right.right.right = new TreeNode(5);

		System.out.println("closestValue " + closestValue(root, 1.1f));
		System.out.println("closestValue " + closestValue(root, 2.1f));
		System.out.println("closestValue " + closestValue(root, 5.1f));
		System.out.println("closestValue " + closestValue(root, 6.1f));
		System.out.println("closestValue " + closestValue(root, 2.9f));
		System.out.println("closestValue " + closestValue(root, 3.1f));
		System.out.println("closestValue " + closestValue(root, 3.9f));

		diff = Float.MAX_VALUE;
		closestValueAdvance(root, 1.1f);
		System.out.println("closestValueAdvance " + target);
		
		diff = Float.MAX_VALUE; 
		closestValueAdvance(root, 2.1f);
		System.out.println("closestValueAdvance " + target);
		
		diff = Float.MAX_VALUE;
		closestValueAdvance(root, 5.1f);
		System.out.println("closestValueAdvance " + target);
		
		diff = Float.MAX_VALUE;
		closestValueAdvance(root, 6.1f);
		System.out.println("closestValueAdvance " + target);

		diff = Float.MAX_VALUE;
		closestValueAdvance(root, 2.9f);
		System.out.println("closestValueAdvance " + target);

		diff = Float.MAX_VALUE;
		closestValueAdvance(root, 3.1f);
		System.out.println("closestValueAdvance " + target);

		diff = Float.MAX_VALUE;
		closestValueAdvance(root, 3.9f);
		System.out.println("closestValueAdvance " + target);
	}

	public static int closestValue(TreeNode root, float value) {
		if (root == null)
			return -1;

		return closestValueHelper(root, value, Integer.MIN_VALUE,
				Integer.MAX_VALUE);
	}

	private static int target = 0;
	private static float diff = Float.MAX_VALUE;
	public static void closestValueAdvance(TreeNode root, float value) {
		if (root != null) {
			float tmp = Math.abs(root.val - value);
			if (tmp < diff) {
				diff = tmp;
				target = root.val;
			}

			if (root.val < value) {
				closestValueAdvance(root.right, value);
				return;
			} else {
				closestValueAdvance(root.left, value);
				return;
			}
		}
	}

	public static int closestValueHelper(TreeNode root, float value, int max,
			int min) {
		if (root.val == value)
			return root.val;

		if (root.val > value) {
			if (root.left == null) {
				return findClosest(max, min, root.val, value);
			}
			return closestValueHelper(root.left, value, root.val, min);
		} else {
			if (root.right == null) {
				return findClosest(max, min, root.val, value);
			}
			return closestValueHelper(root.right, value, max, root.val);
		}
	}

	public static int findClosest(int max, int min, int val, float value) {
		float num1 = Math.abs(max - value);
		float num2 = Math.abs(min - value);
		float num3 = Math.abs(val - value);
		float result = Math.min(num1, Math.min(num2, num3));

		if (num1 == result)
			return max;
		else if (num2 == result)
			return min;
		else
			return val;
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
