package leetCode;

import java.util.ArrayList;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.15
 Question Number : 166
 Link : https://leetcode.com/problems/majority-element-ii/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an integer array of size n, find all elements that appear more than
	 * n/3 times. The algorithm should run in linear time and in O(1) space.
	 * Show Hint How many majority elements could it possibly have? 2?
	 */
	public static void main(String[] args) {
		// int[] num = {47, 47, 72, 47, 72, 47, 79, 47, 12, 92, 13, 47, 47, 83,
		// 33, 15, 18, 47, 47, 47, 47, 64, 47, 65, 47, 47, 47, 47, 70, 47,
		// 47, 55, 47, 15, 60, 47, 47, 47, 47, 47, 46, 30, 58, 59, 47, 47,
		// 47, 47, 47, 90, 64, 37, 20, 47, 100, 84, 47, 47, 47, 47, 47,
		// 89, 47, 36, 47, 60, 47, 18, 47, 34, 47, 47, 47, 47, 47, 22, 47,
		// 54, 30, 11, 47, 47, 86, 47, 55, 40, 49, 34, 19, 67, 16, 47, 36,
		// 47, 41, 19, 80, 47, 47, 27};
		int[] num = {8, 8, 2, 2, 2};
		System.out.println("majorityElement : "
				+ majorityElement(num).toString());
	}

	public static List<Integer> majorityElement(int[] nums) {
		List<Integer> list = new ArrayList<Integer>();

		if (nums == null || nums.length == 0) {
			return list;
		}

		int value1 = nums[0], value2 = nums[0];
		int count1 = 0, count2 = 0;

		for (int num : nums) {
			if (value1 == num) {
				count1++;
			} else if (value2 == num) {
				count2++;
			} else if (count1 == 0) {
				value1 = num;
				count1 = 1;
			} else if (count2 == 0) {
				value2 = num;
				count2 = 1;
			} else {
				count1--;
				count2--;
			}
		}

		// Count two majority numbers
		count1 = 0;
		count2 = 0;
		for (int num : nums) {
			if (num == value1) {
				count1++;
			} else if (num == value2) {
				count2++;
			}
		}

		if (count1 > nums.length / 3)
			list.add(value1);
		if (count2 > nums.length / 3)
			list.add(value2);

		return list;
	}
}