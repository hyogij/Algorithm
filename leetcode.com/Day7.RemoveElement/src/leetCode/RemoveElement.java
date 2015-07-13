package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.13
 Question Number : 28
 Link : https://leetcode.com/problems/remove-element/
 ==========================================================
 */
public class RemoveElement {
	/*
	 * Given an array and a value, remove all instances of that value in place
	 * and return the new length.
	 * 
	 * The order of elements can be changed. It doesn't matter what you leave
	 * beyond the new length.
	 */
	public static void main(String[] args) {
		// int[] nums = {1, 2, 3, 4, 5, 6, 7, 8, 9, 1, 2, 3, 4, 5};
		int[] nums = {1, 1, 1, 1, 1, 1, 2, 3, 4, 1};
		System.out.println("removeDuplicates " + removeElement(nums, 1));
	}

	public static int removeElement(int[] nums, int val) {
		int write = 0;
		for (int read = 0; read < nums.length; read++) {
			if (nums[read] != val) {
				nums[write++] = nums[read];
			}
		}
		return write;
	}
}
