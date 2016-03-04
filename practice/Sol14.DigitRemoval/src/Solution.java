/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.04
 Problem : https://leetcode.com/discuss/88166/given-integer-find-digit-equal-either-adjacent-digits-remove
 ==========================================================
 */
public class Solution {
	/*
	 * Given an integer x, find ONE digit who is equal to its adjacent digits,
	 * and remove it. If there are multiple outcomes, return the largest number.
	 * 
	 * Example: 
	 * Given the number 2234256623 
	 * You could return either: 234256623 or 223425623 
	 * The correct answer would be 234256623, because 234256623 > 223425623. 
	 * You may assume that all inputs have at least one adjacent pair.
	 */
	public static void main(String[] args) {
		int x = 3332266;
		System.out.println(removeOneDigit(x));
	}

	private static int removeOneDigit(int x) {
		String in = String.valueOf(x);
		int max = Integer.MIN_VALUE;
		for (int i = 0; i < in.length() - 1; i++) {
			if (in.charAt(i) == in.charAt(i + 1)) {
				// Get result which is consisted of front part and end part
				int pow = (int) Math.pow(10, in.length() - i - 1);
				int current = (x / pow) * (pow / 10);
				current += (x % (pow / 10));
				if (current > max) {
					max = current;
				}
			}
		}

		return max;
	}
}
