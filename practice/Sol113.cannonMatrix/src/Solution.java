import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.08
 ==========================================================
 */
public class Solution {
	/*
	 * Find the number of enemies that lies in row and col
	 */
	public static void main(String[] args) {
		// {{W, 0, E, 0}, {E, W, 0, E}, {0, E, W, E}, {E, W, 0, 0}};
		List<Coord> enemies = new ArrayList<Coord>();
		enemies.add(new Coord(0, 2));
		enemies.add(new Coord(1, 0));
		enemies.add(new Coord(1, 3));
		enemies.add(new Coord(2, 1));
		enemies.add(new Coord(2, 3));
		enemies.add(new Coord(3, 0));

		List<Coord> walls = new ArrayList<Coord>();
		walls.add(new Coord(0, 0));
		walls.add(new Coord(1, 1));
		walls.add(new Coord(2, 2));
		walls.add(new Coord(3, 1));

		Coord coord = maxEnemies(4, enemies, walls);
		coord.print();
	}

	public static Coord maxEnemies(int n, List<Coord> enemies, List<Coord> walls) {
		// Make enemies and walls matrix using given informations
		char[][] matrix = makeMatrix(n, enemies, walls);
		printMatrix(matrix);

		int[][] sum = new int[n][n];

		// Calculate the number of enemies in the rows and cols
		checkRows(n, matrix, sum);
		checkCols(n, matrix, sum);
		printSumMatrix(sum);
		
		// Find the maximum position of sum matrix
		return findMaximumSum(sum);
	}
	
	public static Coord findMaximumSum(int[][] sum) {
		Coord coord = null;
		int max = 0;

		for (int i = 0; i < sum.length; i++) {
			for (int j = 0; j < sum[i].length; j++) {
				if (sum[i][j] > max) {
					max = sum[i][j];
					coord = new Coord(i, j);
				}
			}
		}

		return coord;
	}

	private static void checkRows(int n, char[][] matrix, int[][] sum) {
		for (int row = 0; row < n; row++) {
			int count = 0;
			// Check the number of enemies from left to right
			for (int col = 0; col < n; col++) {
				if (matrix[row][col] == 'E') {
					count++;
				} else if (matrix[row][col] == 'W') {
					count = 0;
				} else {
					sum[row][col] += count;
				}
			}

			// Check the number of enemies from left to right
			count = 0;
			for (int col = n - 1; col >= 0; col--) {
				if (matrix[row][col] == 'E') {
					count++;
				} else if (matrix[row][col] == 'W') {
					count = 0;
				} else {
					sum[row][col] += count;
				}
			}
		}
	}

	private static void checkCols(int n, char[][] matrix, int[][] sum) {
		for (int col = 0; col < n; col++) {
			int count = 0;
			// Check the number of enemies from left to right
			for (int row = 0; row < n; row++) {
				if (matrix[row][col] == 'E') {
					count++;
				} else if (matrix[row][col] == 'W') {
					count = 0;
				} else {
					sum[row][col] += count;
				}
			}

			// Check the number of enemies from left to right
			count = 0;
			for (int row = n - 1; row >= 0; row--) {
				if (matrix[row][col] == 'E') {
					count++;
				} else if (matrix[row][col] == 'W') {
					count = 0;
				} else {
					sum[row][col] += count;
				}
			}
		}
	}

	public static void printMatrix(char[][] matrix) {
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}

	public static void printSumMatrix(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++)
			System.out.println(Arrays.toString(matrix[i]));
	}

	private static char[][] makeMatrix(int n, List<Coord> enemies,
			List<Coord> walls) {
		char[][] matrix = new char[n][n];
		for (int i = 0; i < enemies.size(); i++) {
			Coord enemy = enemies.get(i);
			matrix[enemy.x][enemy.y] = 'E';
		}
		for (int i = 0; i < walls.size(); i++) {
			Coord wall = walls.get(i);
			matrix[wall.x][wall.y] = 'W';
		}
		return matrix;
	}

	public static class Coord {
		int x, y;
		public Coord(int x, int y) {
			this.x = x;
			this.y = y;
		}

		public void print() {
			System.out.println(x + ", " + y);
		}
	}
}
