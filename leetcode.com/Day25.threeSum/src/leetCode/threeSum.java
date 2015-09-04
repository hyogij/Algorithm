package leetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.04
 Question Number : 101
 Link : https://leetcode.com/problems/3sum/
 ==========================================================
 */

public class threeSum {
	/*
	 * Given an array S of n integers, are there elements a, b, c in S such that
	 * a + b + c = 0? Find all unique triplets in the array which gives the sum
	 * of zero.
	 * 
	 * Note: Elements in a triplet (a,b,c) must be in non-descending order. (ie,
	 * a ¡Â b ¡Â c) The solution set must not contain duplicate triplets. For
	 * example, given array S = {-1 0 1 2 -1 -4},
	 * 
	 * A solution set is: (-1, 0, 1) (-1, -1, 2)
	 */
	public static void main(String[] args) {
		int[] nums = {-5, 14, 1, -2, 11, 11, -10, 3, -6, 0, 3, -4, -9, -13, -8,
				-7, 9, 8, -7, 11, 12, -7, 4, -7, -1, -5, 13, 1, -2, 8, -13, 0,
				-1, 3, 13, -13, -1, 10, 5, 1, -13, -15, 12, -7, -13, -11, -7,
				3, 13, 1, 0, 2, 1, 11, 10, 8, -8, 1, -14, -3, -6, -12, 12, 0,
				6, 2, 2, -9, -3, 14, -1, -9, 14, -4, -1, 8, -8, 7, -4, 12, -14,
				3, -9, 2, 0, -13, -13, -1, 3, -12, 11, 4, -9, 8, 11, 5, -5,
				-10, 3, -1, -11, -13, 5, -12, -10, 11, 11, -3, -5, 14, -13, -4,
				-5, -7, 6, 2, -13, 0, 8, -3, 4, 4, -14, 2};
		System.out.println("threeSum " + threeSum(nums).toString());
	}

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					if (nums[i] + nums[j] + nums[k] == 0) {
						List<Integer> list = new ArrayList<Integer>();
						list.add(nums[i]);
						list.add(nums[j]);
						list.add(nums[k]);

						// Sort elements in non-descending order
						Collections.sort(list);

						if (lists.contains(list) == false) {
							lists.add(list);
						}
					}
				}
			}
		}

		return lists;
	}
}

