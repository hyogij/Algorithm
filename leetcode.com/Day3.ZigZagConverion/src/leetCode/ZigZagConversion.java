package leetCode;


/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.07.07
 Question Number : 12
 Link : https://leetcode.com/problems/zigzag-conversion/
 ==========================================================
 */
public class ZigZagConversion {
	/*
	 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given
	 * number of rows like this: (you may want to display this pattern in a
	 * fixed font for better legibility)
	 * 
	 * P    A     H    N
	 * A P L  S  I  I G
	 * Y    I      R
	 * And then read line by line: "PAHNAPLSIIGYIR"
	 * Write the code that will take a string and make this conversion given a
	 * number of rows:
	 * 
	 * string convert(string text, int nRows); convert("PAYPALISHIRING", 3)
	 * should return "PAHNAPLSIIGYIR".
	 */
	public static void main(String[] args) {
		String result = convert("AB", 1);
		System.out.println("convert : " + result);
	}
	
	public static String convert(String s, int numRows) {
		if(numRows <= 1) return s;  
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < numRows; i++) {
			for (int j = i; j < s.length();) {
				System.out.print(j + " ");
				result.append(s.charAt(j));
				if (i > 0 && i <= numRows - 2) {
					int index = j + (2 * (numRows - 2));
					if(index < s.length()) {
						System.out.print("( " + index + ")");
						result.append(s.charAt(index));
					}
				}
				j = j + (numRows - 2) + numRows;
			}
		}
		System.out.println();
		return result.toString();
	}
}
