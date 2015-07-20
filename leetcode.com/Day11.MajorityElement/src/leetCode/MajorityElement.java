package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.20
 Question Number : 50
 Link : https://leetcode.com/problems/majority-element/
 ==========================================================
 */
public class MajorityElement {
	/*
	 * Given an array of size n, find the majority element. The majority element
	 * is the element that appears more than [n/2] times.
	 * 
	 * You may assume that the array is non-empty and the majority element
	 * always exist in the array.
	 */
	public static void main(String[] args) {
		int[] nums = {1};
		System.out.println("majorityElement " + majorityElement(nums));
	}

	public static int majorityElement(int[] nums) {
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
