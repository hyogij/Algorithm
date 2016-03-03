/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.03
 Link : http://www.geeksforgeeks.org/run-length-encoding/
 http://algorithms.tutorialhorizon.com/string-compression-using-count-of-repeated-characters-run-length-encoding/
 ==========================================================
 */
public class Solution {
	/*
	 * Given an input string, write a function that returns the Run Length
	 * Encoded string for the input string.
	 * 
	 * For example, if the input string is "wwwwaaadexxxxxx", then the function
	 * should return "w4a3d1e1x6".
	 * 
	 * Similar problem : Given a string with repeated characters e.g.
	 * 'aaaalllriiiii', write a function to encode it repeating any sequence of
	 * duplicate characters with <number>x<character>, e.g. in that case
	 * '4xa3xlr4xi'. Only replace if it shortens the string. Then questions
	 * about edge cases.
	 */

	public static void main(String[] args) {
		String message = encoding("wwwwaaadexxxxxx");
		System.out.println("encoding : " + message);
		System.out.println("decoding : " + decoding(message));

		message = encoding("ssssuuuummmmmmiiiittttttttttttt");
		System.out.println("encoding : " + message);
		System.out.println("decoding : " + decoding(message));

		message = encoding("Jaain");
		System.out.println("encoding : " + message);
		System.out.println("decoding : " + decoding(message));
		
		message = encoding("wwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwwaaadexxxxxx");
		System.out.println("encoding : " + message);
		System.out.println("decoding : " + decoding(message));
	}

	public static String encoding(String message) {
		if (message == null || message.length() == 0) {
			return "";
		}
		System.out.println("original   : " + message);

		StringBuilder sb = new StringBuilder();
		char c = message.charAt(0);
		int count = 1;
		for (int i = 1; i < message.length(); i++) {
			if (c != message.charAt(i)) {
				sb.append(c);
				sb.append(count);

				// Set a new character
				c = message.charAt(i);
				count = 1;
			} else {
				count++;
			}
		}

		// Append the last character
		sb.append(c);
		sb.append(count);

		if (sb.length() > message.length()) {
			return message;
		}

		return sb.toString();
	}

	public static String decoding(String message) {
		if (message == null || message.length() == 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder();

		char c = message.charAt(0);
		int num = 0;
		for (int i = 1; i < message.length(); i++) {
			char tmp = message.charAt(i);
			if (tmp >= '0' && tmp <= '9') {
				num *= 10;
				num += (tmp - '0');
			} else {
				sb.append(c);
				for (int j = 0; j < num - 1; j++) {
					sb.append(c);
				}

				// Initialize the character and counter value
				c = tmp;
				num = 0;
			}
		}

		// Append the last character
		sb.append(c);
		for (int j = 0; j < num - 1; j++) {
			sb.append(c);
		}

		return sb.toString();
	}
}
