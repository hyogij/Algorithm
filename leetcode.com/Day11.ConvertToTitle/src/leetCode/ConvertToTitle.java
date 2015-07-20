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
		System.out.println("convertToTitle " + convertToTitle(78));
	}

	private static final int NUMBER_OF_ALPHABETS = 26;
	public static String convertToTitle(int n) {
		StringBuffer title = new StringBuffer();

		while (n > 0) {
			n--;
			char ch = (char) (n % NUMBER_OF_ALPHABETS + 'A');
			title.append(ch);
			n /= NUMBER_OF_ALPHABETS;
		}
		
		title.reverse();
		return title.toString();
	}
}
