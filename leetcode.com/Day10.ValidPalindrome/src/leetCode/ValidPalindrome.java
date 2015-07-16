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
		System.out.println("isPalindrome " + isPalindrome(",.a"));
		System.out.println("isPalindrome "
				+ isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println("isPalindrome " + isPalindrome("race a car"));
		System.out.println("isPalindrome " + isPalindrome(" "));
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
