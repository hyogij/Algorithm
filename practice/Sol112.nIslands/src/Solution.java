/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2016.04.08
 Problem : http://www.geeksforgeeks.org/find-number-of-islands/
 ==========================================================
 */
public class Solution {
	/*
	 * Given a boolean 2D matrix, find the number of islands.
	 * 
	 * This is an variation of the standard problem: "Counting number of
	 * connected components in a undirected graph".
	 * 
	 * Before we go to the problem, let us understand what is a connected
	 * component. A connected component of an undirected graph is a subgraph in
	 * which every two vertices are connected to each other by a path(s), and
	 * which is connected to no other vertices outside the subgraph. For
	 * example, the graph shown below has three connected components.
	 * 
	 * A graph where all vertices are connected with each other, has exactly one
	 * connected component, consisting of the whole graph. Such graph with only
	 * one connected component is called as Strongly Connected Graph.
	 */
	public static void main(String[] args) {
		int M[][] = new int[][]{{1, 1, 0, 0, 0}, {0, 1, 0, 0, 1},
				{1, 0, 0, 1, 1}, {0, 0, 0, 0, 0}, {1, 0, 1, 0, 1}};
		System.out.println(countIslands(M));
	}

	// The main function that returns count of islands in a given
	// boolean 2D matrix
	public static int countIslands(int M[][]) {
		int count = 0;
		boolean[][] visited = new boolean[M.length][M[0].length];
		for (int i = 0; i < M.length; i++) {
			for (int j = 0; j < M[0].length; j++) {
				// If current node is not visited, then visit node
				if (M[i][j] == 1 && visited[i][j] == false) {
					count++;
					visited[i][j] = true;
					visitIslands(i, j, M, visited);
				}
			}
		}
		return count;
	}

	private static void visitIslands(int row, int col, int M[][],
			boolean visited[][]) {
		// Visit connected node from (row, col)
		for (int i = row - 1; i <= row + 1; i++) {
			for (int j = col - 1; j <= col + 1; j++) {
				// Validate input position
				if (isValid(i, j, M, visited)) {
					visited[i][j] = true;
					visitIslands(i, j, M, visited);
				}
			}
		}
	}

	private static boolean isValid(int row, int col, int M[][],
			boolean visited[][]) {
		if ((row >= 0 && row < M.length) && (col >= 0 && col < M[row].length)
				&& M[row][col] == 1 && visited[row][col] == false) {
			return true;
		}
		return false;
	}
}
