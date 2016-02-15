package leetCode;

import java.util.HashSet;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.02.15
 Question Number : 163
 Link : https://leetcode.com/problems/sudoku-solver/
 ==========================================================
 */
public class Solution {
	/*
	 * Write a program to solve a Sudoku puzzle by filling the empty cells.
	 * Empty cells are indicated by the character '.'. You may assume that there
	 * will be only one unique solution.
	 */
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
		System.out.println("solveSudoku " + solveSudoku(board));
	}

	public static boolean solveSudoku(char[][] board) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == '.') {
					for (char num = '1'; num <= '9'; num++) {
						if (isValid(board, i, j, num)) {
							// no conflict
							board[i][j] = num;
							if (solveSudoku(board)) {
								return true;
							} else {
								board[i][j] = '.';
							}
						}
					}
					// if no proper number found, return false
					return false;
				}
			}
		}

		return true;
	}

	private static boolean isValid(char[][] board, int i, int j, char c) {
		// check column
		for (int row = 0; row < 9; row++) {
			if (board[row][j] == c) {
				return false;
			}
		}

		// check row
		for (int col = 0; col < 9; col++) {
			if (board[i][col] == c) {
				return false;
			}
		}

		// check block
		for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
			for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
				if (board[row][col] == c) {
					return false;
				}
			}
		}

		return true;
	}
}