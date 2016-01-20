package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.10.05
 Question Number : 132
 Link : https://leetcode.com/problems/decode-ways/
 ==========================================================
 */
public class NumDecodings {
	/*
	 * A message containing letters from A-Z is being encoded to numbers using
	 * the following mapping:
	 * 
	 * 'A' -> 1 'B' -> 2 ... 'Z' -> 26 Given an encoded message containing
	 * digits, determine the total number of ways to decode it.
	 * 
	 * For example, Given encoded message "12", it could be decoded as "AB" (1
	 * 2) or "L" (12).
	 * 
	 * The number of ways decoding "12" is 2.
	 */
	public static void main(String[] args) {
		String s1 = "1212121211";
		System.out.println("numDecodingsDynamic " + numDecodingsDynamic(s1));
		System.out.println("numDecodings " + numDecodings(s1));

		String s2 = "11111";
		System.out.println("numDecodingsDynamic " + numDecodingsDynamic(s2));
		System.out.println("numDecodings " + numDecodings(s2));
	}

	// How can I solve this problem?
	// 2612 --> ZAB, ZL
	// 11111 --> AAAAA, AKAA, AKK, KAAA, KKA
	// 121 --> A, L, AB, AU, LA, ABA
	// Recursive method
	// If string could be decoded, then return 1
	// All input string could be decoded? There are edge examples : 010, 100
	// Can I ignore these cases?
	// But this algorithm exceed time limitations
	public static int numDecodings(String s) {
		if (s == null || s.length() == 0) {
			return 0;
		}

		return numDecodingsHelper(s);
	}

	public static int numDecodingsHelper(String s) {
		if (s.length() == 0) {
			return 1;
		}

		int digitTwo = 0;
		if (s.length() >= 2) {
			digitTwo = Integer.valueOf(s.substring(0, 2));
		}

		if (s.length() >= 2 && digitTwo <= 26) {
			return numDecodingsHelper(s.substring(1, s.length()))
					+ numDecodingsHelper(s.substring(2, s.length()));
		} else {
			return numDecodingsHelper(s.substring(1, s.length()));
		}
	}

	public static int numDecodingsDynamic(String s) {
		if (s.length() == 0)
			return 0;
		int n = s.length();
		int[] A = new int[n + 1];
		A[n] = 1;

		if (s.charAt(n - 1) != '0') {
			A[n - 1] = 1;
		}

		for (int i = n - 2; i >= 0; i--) {
			if (s.charAt(i) != '0') {
				A[i] = A[i + 1];
				int val = Integer.parseInt(s.substring(i, i + 2));
				if (val > 0 && val <= 26) {
					A[i] += A[i + 2];
				}
			}
		}
		return A[0];
	}
}
