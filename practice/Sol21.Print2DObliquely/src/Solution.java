/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.09
 Problem : https://leetcode.com/discuss/59895/print-two-dimensional-array-of-obliquely
 ==========================================================
 */
public class Solution {
	/*
	 * Print two-dimensional array of obliquely.
	 * 1 3 6 10 15
	 * 2 5 9 14 19
	 * 4 8 13 18 22
	 * 7 12 17 21 24
	 * 11 16 20 23 25
	 * 
	 * Expected result is 1, 2, 3, 4, 5, 6, .... , 25
	 */
	
	public static void main(String[] args) {
		int[][] matrix = {{1, 3, 6}, {2, 5, 8}, {4, 7, 9}};
		zigzagPrint(matrix);
	}

	public static void zigzagPrint(int[][] M) {
		int n = M.length, m = M[0].length;

		// Print upper left part
		for (int r = 0; r < n; r++) {
			int i = r, j = 0;
			while (i >= 0 && j < m) {
				System.out.format("%d ", M[i--][j++]);
			}
		}

		// Print lower right part
		for (int c = 1; c < m; c++) {
			int i = n - 1, j = c;
			while (i >= 0 && j < m) {
				System.out.format("%d ", M[i--][j++]);
			}
		}
	}
}