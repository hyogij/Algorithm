package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.02
 Question Number : 7
 Link : https://leetcode.com/problems/spiral-matrix/
 ==========================================================
 */
public class LargestNumber {
	/*
	 * Given a list of non negative integers, arrange them such that they form
	 * the largest number.
	 * 
	 * For example, given [3, 30, 34, 5, 9], the largest formed number is
	 * 9534330.
	 * 
	 * Note: The result may be very large, so you need to return a string
	 * instead of an integer.
	 */

	public static void main(String[] args) {
		int[] nums = {3, 30, 34, 5, 9};
		System.out.println("largestNumber = " + largestNumber(nums));
	}

	public static String largestNumber(int[] nums) {
		StringBuffer number = new StringBuffer();
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j > 0; j--) {
				if (less(nums[j], nums[j - 1])) {
					swap(nums, j, j - 1);
				}
			}
		}

		for (int i = 0; i < nums.length; i++) {
			number.append(nums[i]);
		}

		// Removes '0' character if string starts with '0'
		while (number.charAt(0) == '0' && number.length() > 1) {
			number.deleteCharAt(0);
		}

		return number.toString();
	}

	// We can use java basic method to compare two integer values
	public static boolean less(int a, int b) {
		String valueAB = String.valueOf(a) + String.valueOf(b);
		String valueBA = String.valueOf(b) + String.valueOf(a);

		if (valueAB.compareTo(valueBA) < 0) {
			return false;
		}
		return true;
	}

	public static void swap(int[] nums, int a, int b) {
		int tmp = nums[a];
		nums[a] = nums[b];
		nums[b] = tmp;
	}
}
