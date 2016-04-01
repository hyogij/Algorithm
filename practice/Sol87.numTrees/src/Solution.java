import java.util.Arrays;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.01
 Problem : https://leetcode.com/problems/unique-binary-search-trees/
 ==========================================================
 */
public class Solution {
	/*
	 * Given n, how many structurally unique BST's (binary search trees) that
	 * store values 1...n?
	 * 
	 * For example, Given n = 3, there are a total of 5 unique BST's.
	 */
	public static void main(String[] args) {
		System.out.println("numTrees " + numTrees(3));
		System.out.println("numTrees " + numTrees(4));
	}

	// 1: 1
	// 2: 2 --> 1 2, 1 2
	// 3: 5 --> 1 {2, 3}, {1} 2 {3}, {1, 2}, 3
	// 4 : 14 --> {2, 3, 4}, {1} 2 {3, 4}, {1, 2} 3 {4}, {1, 2, 3} 4
	public static int numTrees(int n) {
		int[] nums = new int[n + 1];

		nums[0] = nums[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				int left = j - 1;
				int right = i - j;
				nums[i] += (nums[left] * nums[right]);
			}
		}

		return nums[n];
	}
}
