import java.util.Arrays;
import java.util.Comparator;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.31
 Problem : https://www.careercup.com/question?id=5723915160649728
 ==========================================================
 */

public class Solution {
	/*
	 * Given a list of integers, find the highest value obtainable by
	 * concatenating these together.
	 * 
	 * For example, given 9, 918, 917 - The answer is 9918917. But given
	 * 1,112,113 - The answer is 1131121
	 */
	public static void main(String[] args) {
		int[] nums1 = {9, 918, 917};
		int[] nums2 = {1, 112, 113};

		System.out.println("highestValue " + highestValue(nums1));
		System.out.println("highestValue " + highestValue(nums2));
	}

	public static String highestValue(int[] nums) {
		Integer[] array = new Integer[nums.length];
		for (int i = 0; i < nums.length; i++)
			array[i] = nums[i];

		// Sorting array
		Arrays.sort(array, new NumberComparator());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < array.length; i++)
			sb.append(array[i]);

		return sb.toString();
	}

	// Custom comparator to compare integers
	public static class NumberComparator implements Comparator<Integer> {
		@Override
		public int compare(Integer o1, Integer o2) {
			String str1 = String.valueOf(o1);
			String str2 = String.valueOf(o2);
			if (str1.length() < str2.length()) {
				// Fill the last character of str1 with str2.length -
				// str1.length to equal of input string's length
				StringBuffer sb = new StringBuffer(str1);
				char c = str1.charAt(str1.length() - 1);
				for (int i = str1.length(); i < str2.length(); i++)
					sb.append(c);
				str1 = sb.toString();
			} else if (str1.length() > str2.length()) {
				// Fill the last character of str2 with str1.length -
				// str2.length to equal of input string's length
				StringBuffer sb = new StringBuffer(str2);
				char c = str2.charAt(str2.length() - 1);
				for (int i = str2.length(); i < str1.length(); i++)
					sb.append(c);
				str2 = sb.toString();
			}

			return str2.compareTo(str1);
		}
	}
}
