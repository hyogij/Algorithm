package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.20
 Question Number : 48
 Link : https://leetcode.com/problems/compare-version-numbers/
 ==========================================================
 */
public class CompareVersion {
	/*
	 * Compare two version numbers version1 and version2. If version1 > version2
	 * return 1, if version1 < version2 return -1, otherwise return 0.
	 * 
	 * You may assume that the version strings are non-empty and contain only
	 * digits and the . character. The . character does not represent a decimal
	 * point and is used to separate number sequences. For instance, 2.5 is not
	 * "two and a half" or "half way to version three", it is the fifth
	 * second-level revision of the second first-level revision.
	 * 
	 * Here is an example of version numbers ordering:
	 * 
	 * 0.1 < 1.1 < 1.2 < 13.37 0.0.1 < 0.0.1.2
	 */
	public static void main(String[] args) {
		System.out.println(compareVersion("1", "1.0"));
	}

	public static int compareVersion(String version1, String version2) {
		// We have to use escape characters such as "\\" in front of regex
		String[] array1 = version1.split("\\.");
		String[] array2 = version2.split("\\.");
		int number1 = 0, number2 = 0;

		int i = 0, j = 0;
		for (; i < array1.length && j < array2.length; i++, j++) {
			number1 = Integer.valueOf(array1[i]);
			number2 = Integer.valueOf(array2[j]);

			if (number1 > number2) {
				return 1;
			} else if (number1 < number2) {
				return -1;
			}
		}

		if (array1.length > array2.length && Integer.valueOf(array1[i]) != 0) {
			return 1;
		} else if (array1.length < array2.length
				&& Integer.valueOf(array2[j]) != 0) {
			return -1;
		}
		return 0;
	}
}
