package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.16
 Question Number : 45
 Link : https://leetcode.com/problems/valid-palindrome/
 ==========================================================
 */
public class ValidPalindrome {
	/*
	 * Given a string, determine if it is a palindrome, considering only
	 * alphanumeric characters and ignoring cases.
	 * 
	 * For example, "A man, a plan, a canal: Panama" is a palindrome.
	 * "race a car" is not a palindrome.
	 * 
	 * Note: Have you consider that the string might be empty? This is a good
	 * question to ask during an interview.
	 * 
	 * For the purpose of this problem, we define empty string as valid
	 * palindrome.
	 */
	public static void main(String[] args) {
		System.out.println("isPalindrome " + isPalindrome("1a2"));
		System.out.println("isPalindromePractice "
				+ isPalindromePractice("1a2"));
		System.out.println("isPalindrome " + isPalindrome(",."));
		System.out.println("isPalindromePractice "
				+ isPalindromePractice(",."));
		System.out.println("isPalindrome "
				+ isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println("isPalindromePractice "
				+ isPalindromePractice("A man, a plan, a canal: Panama"));
		System.out.println("isPalindrome " + isPalindrome("race a car"));
		System.out.println("isPalindromePractice "
				+ isPalindromePractice("race a car"));
		System.out.println("isPalindrome " + isPalindrome(" "));
		System.out.println("isPalindromePractice " + isPalindromePractice(" "));
	}

	public static boolean isPalindromePractice(String s) {
		// I will use two pointer, one pointer points the start of string.
		// Another pointer points the end of string. Compares two pointer's
		// equality, if two characters are not equal, then return false. If they
		// are equal, moves two pointer. One pointer moves right side, another
		// pointer moves left side. Repeats above process until two pointer meet
		// each others.
		// myString.matches("[A-Za-z0-9]+")
		char leftChar = 0, rightChar = 0;
		int left = 0, right = s.length() - 1;
		while (left <= right) {
			while (left <= s.length() - 1) {
				leftChar = Character.toLowerCase(s.charAt(left++));
				if (isAlphaNumeric(leftChar)) {
					break;
				} else {
					leftChar = 0;
				}
			}

			while (right >= 0) {
				rightChar = Character.toLowerCase(s.charAt(right--));
				if (isAlphaNumeric(rightChar)) {
					break;
				} else {
					rightChar = 0;
				}
			}
			if (leftChar != rightChar) {
				return false;
			}
		}

		return true;
	}

	public static boolean isAlphaNumeric(char c) {
		String str = String.valueOf(c);
		return str.matches("[A-Za-z0-9]+");
	}

	public static boolean isPalindrome(String s) {
		// s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isAlphanumeric(c)) {
				stringBuffer.append(String.valueOf(c).toLowerCase());
			}
		}

		return stringBuffer.toString()
				.equals(stringBuffer.reverse().toString());
	}

	public static boolean isAlphanumeric(char name) {
		return String.valueOf(name).matches("[a-zA-Z0-9]+");
	}
}
