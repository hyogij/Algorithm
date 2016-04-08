import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.03.30
 Problem : https://leetcode.com/problems/n-queens/
 ==========================================================
 */

public class Solution {
	/*
	 * The n-queens puzzle is the problem of placing n queens on an n¡¿n
	 * chessboard such that no two queens attack each other.
	 * 
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 * 
	 * Each solution contains a distinct board configuration of the n-queens'
	 * placement, where 'Q' and '.' both indicate a queen and an empty space
	 * respectively.
	 * 
	 * For example, There exist two distinct solutions to the 4-queens puzzle:
	 * // Solution 1
	 * [[".Q..",  "...Q", "Q...", "..Q."],
	 * // Solution 2
	 * ["..Q.", "Q...", "...Q", ".Q.."] ]
	 */
	public static void main(String[] args) {
		int board[][] = {{0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 0}};
		// System.out.println("solveNQUtil : " + solveNQueensGeeks(board));
		// printBoard(board);

		List<List<String>> list = solveNQueens(4);
		System.out.println(list.toString());
	}
	
	public static int totalNQueens(int n) {
		List<List<String>> list = new ArrayList<List<String>>();
		int board[][] = new int[n][n];
		solveNQueensSetHelper(board, 0, list);
		return list.size();
	}

	public static List<List<String>> solveNQueens(int n) {
		List<List<String>> list = new ArrayList<List<String>>();
		int board[][] = new int[n][n];
		solveNQueensSetHelper(board, 0, list);
		return list;
	};

	public static void solveNQueensSetHelper(int[][] board, int n,
			List<List<String>> list) {
		if (n == board.length) {
			// Print board to array list
			list.add(printBoardAsString(board));
			return;
		}

		// Find correct col in given row
		for (int i = 0; i < board[n].length; i++) {
			if (isSafePosition(board, n, i)) {
				board[n][i] = 1; // Place queen
				solveNQueensSetHelper(board, n + 1, list);
				board[n][i] = 0; // Repalce queen
			}
		}
		return;
	}

	private static List<String> printBoardAsString(int[][] board) {
		List<String> list = new ArrayList<String>();
		for (int i = 0; i < board.length; i++) {
			StringBuffer sb = new StringBuffer();
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1)
					sb.append("Q");
				else
					sb.append(".");
			}
			list.add(sb.toString());
		}

		return list;
	}
	
	public static boolean isSafePosition(int[][] board, int row, int col) {
		// This position is already placed another queen
		if (board[row][col] == 1)
			return false;

		// Compare with other queens
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] == 1) {
					if (row == i || col == j || (i - j) == (row - col)
							|| (i + j) == (row + col))
						return false;
				}
			}
		}
		return true;
	}

	public static boolean solveNQueensGeeks(int[][] board) {
		return solveNQueensHelper(board, 0);
	}

	public static boolean solveNQueensHelper(int[][] board, int n) {
		if (n == board.length)
			return true;

		// Find correct col in given row
		for (int i = 0; i < board[n].length; i++) {
			if (isSafePosition(board, n, i)) {
				board[n][i] = 1; // Place queen
				if (solveNQueensHelper(board, n + 1))
					return true;

				board[n][i] = 0; // Repalce queen
			}
		}
		return false;
	}

	public static void printBoard(int[][] board) {
		for (int i = 0; i < board.length; i++) {
			System.out.println(Arrays.toString(board[i]));
		}
	}
}
