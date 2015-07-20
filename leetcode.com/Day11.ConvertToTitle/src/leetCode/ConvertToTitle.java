package leetCode;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.20
 Question Number : 49
 Link : https://leetcode.com/problems/excel-sheet-column-title/
 ==========================================================
 */
public class ConvertToTitle {
	/*
	 * Given a positive integer, return its corresponding column title as appear
	 * in an Excel sheet.
	 * 
	 * For example:
	 * 
	 * 1 -> A 2 -> B 3 -> C ... 26 -> Z 27 -> AA 28 -> AB
	 */
	public static void main(String[] args) {
		System.out.println("convertToTitle " + convertToTitle(52));
	}

	private static final int NUMBER_OF_ALPHABETS = 26;
	public static String convertToTitle(int n) {
		StringBuffer title = new StringBuffer();

		int value = n;
		while (value > 0) {
			int number = value / NUMBER_OF_ALPHABETS;
			int remains = n % NUMBER_OF_ALPHABETS;

			if (number == 0) {
				title.append((char) ('A' + remains - 1));
			} else if (remains == 0) {
				title.append((char) ('A' + NUMBER_OF_ALPHABETS - 1));
				if(number <= NUMBER_OF_ALPHABETS) {
					break;
				}
			} else {
				title.append((char) ('A' + number - 1));
			}
			value /= NUMBER_OF_ALPHABETS;
		}

		return title.toString();
	}
}
