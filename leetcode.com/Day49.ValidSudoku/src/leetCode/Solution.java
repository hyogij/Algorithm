package leetCode;

import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.12
 Question Number : 162
 Link : https://leetcode.com/problems/valid-sudoku/
 http://shanjiaxin.blogspot.kr/2014/04/valid-sudoku-leetcode.html
 ==========================================================
 */
public class Solution {
	/*
	 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
	 * The Sudoku board could be partially filled, where empty cells are filled
	 * with the character '.'.
	 * 
	 * A partially filled sudoku which is valid. Note: A valid Sudoku board
	 * (partially filled) is not necessarily solvable. Only the filled cells
	 * need to be validated.
	 * 
	 * Subscribe to see which companies asked this question
	 */
	private static final int SQUARE_SIZE = 3;
	public static void main(String[] args) {
		String[] array1 = {"..4...63.", ".........", "5......9.", "...56....",
				"4.3.....1", "...7.....", "...5.....", ".........", "........."};
		String[] array2 = {".87654321", "2........", "3........", "4........",
				"5........", "6........", "7........", "8........", "9........"};
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = array2[i].charAt(j);
			}
		}
		System.out.println("isValidSudoku " + isValidSudoku(board));
	}

	public static boolean isValidSudoku(char[][] board) {
		// Check every rows
		for (int i = 0; i < board.length; i++) {
			if (isValidRow(board, i) == false) {
				System.out.println("isValidRow " + i);
				return false;
			}
		}

		// Check every cols
		for (int i = 0; i < board[0].length; i++) {
			if (isValidCol(board, i) == false) {
				System.out.println("isValidCol " + i);
				return false;
			}
		}

		// Check every squares
		for (int i = 0; i < SQUARE_SIZE; i++) {
			for (int j = 0; j < SQUARE_SIZE; j++) {
				if (isValidSquare(board, i * SQUARE_SIZE, j * SQUARE_SIZE) == false) {
					System.out.println("isValidSquare " + i);
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isValidRow(char[][] board, int row) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < board[row].length; i++) {
			char c = board[row][i];
			if (c == '.') {
				continue;
			}
			int num = Character.getNumericValue(c);
			if (num <= 0 || num > 9 || set.contains(num) == true) {
				System.out.println(set.toString());
				return false;
			} else {
				set.add(num);
			}
		}
		return true;
	}

	private static boolean isValidCol(char[][] board, int col) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = 0; i < board.length; i++) {
			char c = board[i][col];
			if (c == '.') {
				continue;
			}
			int num = Character.getNumericValue(c);
			if (num <= 0 || num > 9 || set.contains(num) == true) {
				return false;
			} else {
				set.add(num);
			}
		}
		return true;
	}

	private static boolean isValidSquare(char[][] board, int col, int row) {
		HashSet<Integer> set = new HashSet<Integer>();
		for (int i = col; i < col + SQUARE_SIZE; i++) {
			for (int j = row; j < row + SQUARE_SIZE; j++) {
				char c = board[i][j];
				if (c == '.') {
					continue;
				}
				int num = Character.getNumericValue(c);
				if (num <= 0 || num > 9 || set.contains(num) == true) {
					return false;
				} else {
					set.add(num);
				}
			}
		}
		return true;
	}
}
