package leetCode;

import java.awt.Point;
import java.util.Stack;

/*
 ==========================================================
 Author : Hyogi Jung(hyogij@gmail.com)
 Date : 2015.09.04
 Question Number : 100
 Link : https://leetcode.com/problems/number-of-islands/
 ==========================================================
 */

public class numIslands {
	/*
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of
	 * islands. An island is surrounded by water and is formed by connecting
	 * adjacent lands horizontally or vertically. You may assume all four edges
	 * of the grid are all surrounded by water.
	 * 
	 * Example 1: 
	 * 11110 
	 * 11010 
	 * 11000 
	 * 00000  
	 * Answer: 1
	 * 
	 * Example 2: 
	 * 11000 
	 * 11000 
	 * 00100 
	 * 00011  
	 * Answer: 3
	 */
	public static void main(String[] args) {
		char[][] grid = {{'1', '1', '1', '1', '0'}, 
				{'1', '1', '0', '1', '0'},
				{'1', '1', '0', '0', '1'},
				{'0', '0', '1', '0', '1'},
		};
		System.out.println("numIslands " + numIslands(grid));
		System.out.println("numIslands " + numIslandRecursive(grid));
	}
	
	public static int numIslandRecursive(char[][] grid) {
		int num = 0;

		if (grid.length == 0) {
			return num;
		}

		int rows = grid.length;
		int cols = grid[0].length;
		boolean[][] visited = new boolean[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (grid[i][j] == '1' && visited[i][j] == false) {
					numIslandRecursiveHelper(grid, visited, i, j);
					num++;
				}
			}
		}
		return num;
	}

	public static void numIslandRecursiveHelper(char[][] grid,
			boolean[][] visited, int x, int y) {
		if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length) {
			return;
		}

		if (grid[x][y] == '0' || visited[x][y] == true) {
			return;
		}

		visited[x][y] = true;
		numIslandRecursiveHelper(grid, visited, x - 1, y);
		numIslandRecursiveHelper(grid, visited, x + 1, y);
		numIslandRecursiveHelper(grid, visited, x, y - 1);
		numIslandRecursiveHelper(grid, visited, x, y + 1);
	}

	public static int numIslands(char[][] grid) {
		int num = 0;
		
		if(grid.length == 0) {
			return num;
		}
	
		// Use another array to store whether visit or not
		boolean[][] visited = new boolean[grid.length][grid[0].length];
		Stack<Point> stack = new Stack<Point>();
		for (int i = 0; i < grid.length; i++) { // row
			for (int j = 0; j < grid[0].length; j++) { // col
				if (grid[i][j] == '1' && visited[i][j] == false) {
					stack.push(new Point(i, j));
					visited[i][j] = true;
					
					// Traverse other paths which are connected from current node 
					while (stack.isEmpty() != true) {
						Point point = stack.pop();
						// UP
						int x = point.x;
						int y = point.y - 1;
						if (y >= 0 && grid[x][y] == '1'
								&& visited[x][y] == false) {
							stack.push(new Point(x, y));
							visited[x][y] = true;
						}
						// DOWN
						x = point.x;
						y = point.y + 1;
						if (y < grid[0].length && grid[x][y] == '1'
								&& visited[x][y] == false) {
							stack.push(new Point(x, y));
							visited[x][y] = true;
						}
						// LEFT
						x = point.x - 1;
						y = point.y;
						if (x >= 0 && grid[x][y] == '1'
								&& visited[x][y] == false) {
							stack.push(new Point(x, y));
							visited[x][y] = true;
						}
						// RIGHT
						x = point.x + 1;
						y = point.y;
						if (x < grid.length && grid[x][y] == '1'
								&& visited[x][y] == false) {
							stack.push(new Point(x, y));
							visited[x][y] = true;
						}
					}
					num++;
				}
			}
		}
		return num;
	}
}
