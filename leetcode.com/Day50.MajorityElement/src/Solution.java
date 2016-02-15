/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.15
 Question Number : 165
 Link : https://leetcode.com/problems/majority-element/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than n/2 times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 */
	public static void main(String[] args) {
		int[] num = {47, 47, 72, 47, 72, 47, 79, 47, 12, 92, 13, 47, 47, 83,
				33, 15, 18, 47, 47, 47, 47, 64, 47, 65, 47, 47, 47, 47, 70, 47,
				47, 55, 47, 15, 60, 47, 47, 47, 47, 47, 46, 30, 58, 59, 47, 47,
				47, 47, 47, 90, 64, 37, 20, 47, 100, 84, 47, 47, 47, 47, 47,
				89, 47, 36, 47, 60, 47, 18, 47, 34, 47, 47, 47, 47, 47, 22, 47,
				54, 30, 11, 47, 47, 86, 47, 55, 40, 49, 34, 19, 67, 16, 47, 36,
				47, 41, 19, 80, 47, 47, 27};

		System.out.println("MajorityElement : " + majorityElement(num));
		System.out.println("majorityElementSolution : "
				+ majorityElementSolution(num));
	}

	public static int majorityElement(int[] nums) {
		int count = 0, major = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (count == 0) {
				major = num;
				count = 1;
			} else if (major != num) {
				count--;
			} else {
				count++;
			}
		}
		return major;
	}

	public static int majorityElementSolution(int[] nums) {
		int result = 0, count = 0;

		for (int i = 0; i < nums.length; i++) {
			if (count == 0) {
				result = nums[i];
				count = 1;
			} else if (result == nums[i]) {
				count++;
			} else {
				count--;
			}
		}

		return result;
	}
}