package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.01
 Question Number : 121
 Link : https://leetcode.com/problems/first-bad-version/
 ==========================================================
 */

public class VersionControl {
	/*
	 * You are a product manager and currently leading a team to develop a new
	 * product. Unfortunately, the latest version of your product fails the
	 * quality check. Since each version is developed based on the previous
	 * version, all the versions after a bad version are also bad.
	 * 
	 * Suppose you have n versions [1, 2, ..., n] and you want to find out the
	 * first bad one, which causes all the following ones to be bad.
	 * 
	 * You are given an API bool isBadVersion(version) which will return whether
	 * version is bad. Implement a function to find the first bad version. You
	 * should minimize the number of calls to the API.
	 */
	private static final int BAD_VERSION = 1;

	public static void main(String[] args) {
		int num = 1;
		System.out.println("firstBadVersion " + firstBadVersion(num));
	}

	/*
	 * The isBadVersion API is defined in the parent class VersionControl.
	 * boolean isBadVersion(int version);
	 */
	public static int firstBadVersion(int n) {
		// Find the first bad version through the binary search
		int left = 1, right = n;
		int middle = 0;
		while (left < right) {
			middle = (right - left) / 2 + left;
			if (isBadVersion(middle) == true) {
				if (middle - 1 > 0 && isBadVersion(middle - 1) == false) {
					return middle;
				}
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return left;
	}

	public static boolean isBadVersion(int version) {
		if (version >= BAD_VERSION) {
			return true;
		}
		return false;
	}

}
