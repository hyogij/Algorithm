package leetCode;

public class sumRegion {
	/*
	 * Given a 2D matrix matrix, find the sum of the elements inside the
	 * rectangle defined by its upper left corner (row1, col1) and lower right
	 * corner (row2, col2).
	 * 
	 * Range Sum Query 2D The above rectangle (with the red border) is defined
	 * by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum =
	 * 8.
	 * 
	 * Example: Given matrix = 
	 * [[3, 0, 1, 4, 2], 
	 * [5, 6, 3, 2, 1], 
	 * [1, 2, 0, 1, 5], 
	 * [4, 1, 0, 1, 7], 
	 * [1, 0, 3, 0, 5]]
	 * 
	 * sumRegion(2, 1, 4, 3) -> 8 
	 * sumRegion(1, 1, 2, 2) -> 11 
	 * sumRegion(1, 2, 2, 4) -> 12 
	 * 
	 * Note: You may assume that the matrix does not change. 
	 * There are many calls to sumRegion function. 
	 * You may assume that row1 ¡Â row2 and col1 ¡Â col2.
	 */

	public static void main(String[] args) {
		int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5},
				{4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
		NumMatrix numMatrix = new NumMatrix(matrix);
		int result1 = numMatrix.sumRegion(2, 1, 4, 3);
		int result2 = numMatrix.sumRegion(1, 1, 2, 2);
		int result3 = numMatrix.sumRegion(1, 2, 2, 4);

		System.out.println(result1);
		System.out.println(result2);
		System.out.println(result3);
	}

	public static class NumMatrix {
		private int[][] sums = null;

		public NumMatrix(int[][] matrix) {
			if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
				return;
			}

			// A new matrix is bigger than original matrix because of index of
			// zero.
			sums = new int[matrix.length + 1][matrix[0].length + 1];
			
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					sums[i + 1][j + 1] = matrix[i][j] + sums[i][j + 1]
							+ sums[i + 1][j] - sums[i][j];
				}
			}
		}

		public int sumRegion(int row1, int col1, int row2, int col2) {
			row2++;
			col2++;
			
			return sums[row2][col2] - sums[row1][col2] - sums[row2][col1]
					+ sums[row1][col1];
		}
	}
}