package glassdoor;

import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.20
 Question Number : 1
 ==========================================================
 */

public class Compression {
	/*
	 * You're given an array of integers sorted ( [1,2,3,5,6,7]) you need to
	 * serialize and compress this array into a string (1-3, 5-7).
	 * Consider an array of integers, which are sequenced, such as 
	 * [1,2,3,5,8,12,13,14,15]. Please write the function which returns a 
	 * comprehensible string, for example [1-3,5,8,12-15].
	 */
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 5, 8, 12, 13, 14, 15};
		System.out.println("compression : " + compression(nums1));
		int[] nums2 = {1, 2, 3, 5, 6, 7, 10, 11, 23, 56};
		System.out.println("compression : " + compression(nums2));
	}

	public static String compression(int[] nums) {
		if (nums == null || nums.length == 0) {
			return null;
		}

		// Save the left and right value during reading the integers in the
		// array.
		// If the array has gap between left and right numbers,
		// then write the left and right values to result string
		StringBuilder sb = new StringBuilder();

		int left = nums[0], right = left;
		int current = 0;
		for (int i = 1; i < nums.length; i++) {
			current = nums[i];

			// There is a gab between two continuous numbers
			if (right != current - 1) {
				if (left == right) {
					sb.append(left);
				} else {
					sb.append(left);
					sb.append("-");
					sb.append(right);
				}
				sb.append(",");
				left = current;
			}
			right = current;
		}

		if (left == right) {
			sb.append(left);
		} else {
			sb.append(left);
			sb.append("-");
			sb.append(right);
		}

		return sb.toString();
	}
}
